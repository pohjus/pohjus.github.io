import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Check {
    static final String DEFAULT_BASE_URL =
        "https://pohjus.github.io/johdatus-ohjelmointiin-3cr";
    static final int ASSIGNMENT_COUNT = 8;
    static final Duration TEST_TIMEOUT = Duration.ofSeconds(120);
    static final Duration CONNECT_TIMEOUT = Duration.ofSeconds(10);
    static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(30);
    static final Pattern EXERCISE_ROW =
        Pattern.compile("^\\|\\s*(\\d{2})\\s*\\|.*\\|\\s*(\\d+)\\s*\\|\\s*$");
    static final Pattern NOTE_FILE =
        Pattern.compile("`notes/(video\\d{2}\\.pdf)`");
    static final Pattern TOTAL_INCREMENT = Pattern.compile("\\btotal\\+\\+");
    static final Pattern ZIP_NAME = Pattern.compile(
        "^(\\d+)-assignment\\d{2}\\.zip$", Pattern.CASE_INSENSITIVE);
    static final int PDF_TAIL_BYTES = 1024;
    static final Set<String> HELP_OPTIONS = Set.of("-h", "--help", "help");
    static final String USAGE = """
        Grade.java: check your assignment points and video notes

        Usage:
          java Grade.java <folder>

        1. Create a folder for your submissions, for example "my-zips".

        2. Copy your assignment zip files into it, exactly as you submit them:

             my-zips/
               12345-assignment01.zip
               12345-assignment02.zip
               ...
               12345-assignment08.zip

           Add zips as you finish assignments. Missing ones count as 0 points.

        3. Each zip must contain one root folder named after the assignment:

             12345-assignment01.zip
               assignment01/
                 01/Main.java
                 01/screenshot.png
                 02/Main.java
                 ...
                 notes/video01.pdf
                 notes/video02.pdf

           Do not include Test.java or .class files.

        4. Run this in the folder where Grade.java is:

             java Grade.java my-zips

        CHECK YOUR STUDENT NUMBER
          Every zip name must start with YOUR OWN student number.
          12345 above is only an example. Grade.java cannot know your real
          student number, so make sure it is correct in every file name.
          A wrong number means your submission may not be credited to you.

        Grade.java downloads the latest checker and tests from the course site,
        runs them on your code and counts your video notes. It needs Java 25
        and an internet connection. Your files are not sent anywhere;
        everything runs on your own computer. The grade it shows is an
        unofficial estimate.
        """;
    static final Pattern SUMMARY_LINE =
        Pattern.compile("Exercise \\d+: (\\d+)/(\\d+) passed");

    record Exercise(String id, int maxPoints) {}

    record Assignment(String id, List<Exercise> exercises, List<String> notes) {
        int maxPoints() {
            return exercises.stream().mapToInt(Exercise::maxPoints).sum();
        }
    }

    record Result(int points, int maxPoints, int notes, int maxNotes) {}

    static class DownloadException extends IOException {
        DownloadException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    private final String baseUrl;
    private final Duration testTimeout;
    private final Map<String, String> testCache = new HashMap<>();
    private final HttpClient http = HttpClient.newBuilder()
        .followRedirects(HttpClient.Redirect.NORMAL)
        .connectTimeout(CONNECT_TIMEOUT)
        .build();

    Check(String baseUrl) {
        this(baseUrl, TEST_TIMEOUT);
    }

    Check(String baseUrl, Duration testTimeout) {
        this.baseUrl = baseUrl;
        this.testTimeout = testTimeout;
    }

    public static void main(String[] args) throws Exception {
        if (args.length == 1 && HELP_OPTIONS.contains(args[0])) {
            IO.println(USAGE);
            System.exit(0);
        }
        if (args.length != 1) {
            IO.println(USAGE);
            System.exit(1);
        }
        final var studentDir = Path.of(args[0]);
        if (!Files.isDirectory(studentDir)) {
            IO.println("Folder not found: " + args[0] + "\n");
            IO.println(USAGE);
            System.exit(1);
        }
        checkZipNames(studentDir);
        try {
            printSummary(new Check(DEFAULT_BASE_URL).checkAll(studentDir));
        } catch (DownloadException e) {
            IO.println("\nERROR: " + describe(e));
            IO.println("Check your internet connection and try again.");
            System.exit(1);
        } catch (IOException e) {
            IO.println("\nERROR: " + describe(e));
            System.exit(1);
        }
    }

    static void checkZipNames(Path studentDir) throws IOException {
        final var numbers = new TreeSet<String>();
        for (final var name : zipNames(studentDir)) {
            final var matcher = ZIP_NAME.matcher(name);
            if (matcher.matches()) {
                numbers.add(matcher.group(1));
            } else {
                IO.println("WARNING: unexpected zip name " + name
                    + ", expected <studentnumber>-assignment0X.zip,"
                    + " for example 12345-assignment01.zip");
            }
        }
        printStudentNumbers(numbers, studentDir);
    }

    static List<String> zipNames(Path studentDir) throws IOException {
        try (final var files = Files.list(studentDir)) {
            return files.map(f -> f.getFileName().toString())
                .filter(name -> name.toLowerCase().endsWith(".zip"))
                .sorted()
                .toList();
        }
    }

    static void printStudentNumbers(SortedSet<String> numbers, Path studentDir) {
        if (numbers.isEmpty()) {
            IO.println("No correctly named zip files found in " + studentDir
                + ". Run java Grade.java --help for instructions.");
        } else if (numbers.size() > 1) {
            IO.println("WARNING: your zip names use different student numbers: "
                + String.join(", ", numbers));
            IO.println("Every zip name must start with your own student number.");
        } else {
            IO.println("Student number in zip names: " + numbers.first());
            IO.println("Make sure this is your own student number.");
        }
    }

    static String describe(Exception e) {
        final var message = String.valueOf(e.getMessage());
        if (message.contains("MALFORMED") || message.contains("bad entry name")) {
            return "a file name has special characters (such as ä or ö),"
                + " rename it and create the zip again";
        }
        return e.getMessage() != null ? e.getMessage()
            : e.getClass().getSimpleName();
    }

    List<Result> checkAll(Path studentDir) throws Exception {
        final var results = new ArrayList<Result>();
        for (int i = 1; i <= ASSIGNMENT_COUNT; i++) {
            final var id = "assignment%02d".formatted(i);
            final var assignment = parseAssignment(id, download(id + "/README.md"));
            requireExercisesAndNotes(assignment);
            results.add(checkAssignment(assignment, studentDir));
        }
        return results;
    }

    static void requireExercisesAndNotes(Assignment assignment)
        throws IOException {
        if (assignment.exercises().isEmpty() || assignment.notes().isEmpty()) {
            throw new IOException("could not read the exercises and notes of "
                + assignment.id() + " from the course page,"
                + " try again later");
        }
    }

    static Assignment parseAssignment(String id, String readme) {
        final var exercises = new ArrayList<Exercise>();
        final var notes = new ArrayList<String>();
        for (final var line : readme.lines().toList()) {
            final var row = EXERCISE_ROW.matcher(line);
            if (row.matches()) {
                exercises.add(new Exercise(row.group(1),
                    Integer.parseInt(row.group(2))));
            }
            final var note = NOTE_FILE.matcher(line);
            if (note.find()) {
                notes.add(note.group(1));
            }
        }
        return new Assignment(id, exercises, notes.stream().distinct().toList());
    }

    String download(String path) throws Exception {
        final var request = HttpRequest.newBuilder(URI.create(baseUrl + "/" + path))
            .timeout(REQUEST_TIMEOUT)
            .build();
        final HttpResponse<String> response;
        try {
            response = http.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new DownloadException("could not download " + path
                + " (" + describe(e) + ")", e);
        }
        if (response.statusCode() != 200) {
            throw new DownloadException("could not download " + path
                + " (HTTP " + response.statusCode() + ")", null);
        }
        return response.body();
    }

    Result checkAssignment(Assignment fromReadme, Path studentDir)
        throws Exception {
        IO.println("\n=== " + fromReadme.id() + " ===");
        final var assignment = withTestPoints(fromReadme);
        final var zip = findZip(studentDir, assignment.id());
        if (zip.isEmpty()) {
            IO.println("  No zip found (*-" + assignment.id() + ".zip)");
            return emptyResult(assignment);
        }
        IO.println("  Zip: " + zip.get().getFileName());
        if (!hasValidName(zip.get(), assignment.id())) {
            return emptyResult(assignment);
        }
        final var tempDir = Files.createTempDirectory("check-");
        try {
            extract(zip.get(), tempDir);
            return checkExtracted(assignment, tempDir);
        } catch (IOException | IllegalArgumentException e) {
            IO.println("  ERROR: could not check this zip: " + describe(e));
            return emptyResult(assignment);
        } finally {
            deleteQuietly(tempDir);
        }
    }

    // Incorrectly named zips are rejected when grading, so they get 0 points
    // here too instead of a full score that would never be credited.
    static boolean hasValidName(Path zip, String assignmentId) {
        if (ZIP_NAME.matcher(zip.getFileName().toString()).matches()) {
            return true;
        }
        IO.println(("  ERROR: wrong zip name, 0 points. Rename it to"
            + " <studentnumber>-%s.zip, for example 12345-%s.zip")
            .formatted(assignmentId, assignmentId));
        return false;
    }

    Assignment withTestPoints(Assignment assignment) throws Exception {
        final var exercises = new ArrayList<Exercise>();
        for (final var exercise : assignment.exercises()) {
            exercises.add(new Exercise(exercise.id(),
                testPoints(assignment.id(), exercise)));
        }
        return new Assignment(assignment.id(), exercises, assignment.notes());
    }

    // Each check in Test.java does total++ once, so the tests themselves
    // define the maximum points. The README value is only a fallback.
    int testPoints(String assignmentId, Exercise exercise) throws Exception {
        final int checks;
        try {
            checks = countChecks(downloadTest(assignmentId, exercise.id()));
        } catch (IOException e) {
            return exercise.maxPoints();
        }
        if (checks == 0) {
            IO.println(("  WARNING: exercise %s: Test.java has no total++,"
                + " using README points").formatted(exercise.id()));
            return exercise.maxPoints();
        }
        if (checks != exercise.maxPoints()) {
            IO.println(("  WARNING: exercise %s: README says %d points but"
                + " Test.java has %d checks, using %d").formatted(exercise.id(),
                exercise.maxPoints(), checks, checks));
        }
        return checks;
    }

    static int countChecks(String test) {
        return (int) TOTAL_INCREMENT.matcher(test).results().count();
    }

    String downloadTest(String assignmentId, String exerciseId) throws Exception {
        final var path = assignmentId + "/" + exerciseId + "/Test.java";
        if (!testCache.containsKey(path)) {
            testCache.put(path, download(path));
        }
        return testCache.get(path);
    }

    static void deleteQuietly(Path dir) {
        try {
            deleteRecursively(dir);
        } catch (IOException e) {
            IO.println("  WARNING: could not delete temporary folder " + dir);
        }
    }

    static Result emptyResult(Assignment assignment) {
        return new Result(0, assignment.maxPoints(), 0,
            assignment.notes().size());
    }

    static Optional<Path> findZip(Path studentDir, String assignmentId)
        throws IOException {
        final var suffix = "-" + assignmentId + ".zip";
        try (final var files = Files.list(studentDir)) {
            final var zips = files
                .filter(f -> f.getFileName().toString().toLowerCase()
                    .endsWith(suffix))
                .sorted()
                .toList();
            if (zips.size() > 1) {
                IO.println("  WARNING: several zips found, using "
                    + zips.getFirst().getFileName());
            }
            return zips.stream().findFirst();
        }
    }

    static void extract(Path zip, Path targetDir) throws IOException {
        try (final var in = new ZipInputStream(Files.newInputStream(zip))) {
            ZipEntry entry;
            while ((entry = in.getNextEntry()) != null) {
                if (!entry.getName().startsWith("__MACOSX/")) {
                    extractEntry(in, entry, targetDir);
                }
            }
        }
    }

    static void extractEntry(InputStream in, ZipEntry entry, Path targetDir)
        throws IOException {
        final var target = targetDir.resolve(entry.getName()).normalize();
        if (!target.startsWith(targetDir)) {
            throw new IOException("Invalid path in zip: " + entry.getName());
        }
        if (entry.isDirectory()) {
            Files.createDirectories(target);
            return;
        }
        Files.createDirectories(target.getParent());
        Files.copy(in, target, StandardCopyOption.REPLACE_EXISTING);
    }

    Result checkExtracted(Assignment assignment, Path tempDir) throws Exception {
        final var root = tempDir.resolve(assignment.id());
        if (!Files.isDirectory(root)) {
            IO.println("  ERROR: root folder " + assignment.id()
                + "/ not found in zip");
            return emptyResult(assignment);
        }
        warnAboutForbiddenFiles(root);
        int points = 0;
        for (final var exercise : assignment.exercises()) {
            points += checkExercise(assignment.id(), exercise, root);
        }
        final var notes = countNotes(assignment, root);
        return new Result(points, assignment.maxPoints(), notes,
            assignment.notes().size());
    }

    static List<String> findForbiddenFiles(Path root) throws IOException {
        try (final var files = Files.walk(root)) {
            return files.map(f -> root.relativize(f).toString())
                .filter(f -> f.endsWith("Test.java") || f.endsWith(".class"))
                .sorted()
                .toList();
        }
    }

    static void warnAboutForbiddenFiles(Path root) throws IOException {
        findForbiddenFiles(root).forEach(f -> IO.println("  WARNING: remove " + f
            + " from your zip (Test.java and .class files are not allowed)"));
    }

    int checkExercise(String assignmentId, Exercise exercise, Path root)
        throws Exception {
        final var dir = root.resolve(exercise.id());
        if (!Files.isDirectory(dir)) {
            printExercise(exercise, 0, "missing");
            return 0;
        }
        final String test;
        try {
            test = downloadTest(assignmentId, exercise.id());
        } catch (IOException e) {
            printExercise(exercise, 0, "could not download test: " + describe(e));
            return 0;
        }
        Files.writeString(dir.resolve("Test.java"), test);
        final var output = runTest(dir);
        final var points = Math.min(parsePoints(output), exercise.maxPoints());
        printExercise(exercise, points, "");
        output.lines()
            .filter(line -> line.contains("FAIL"))
            .forEach(line -> IO.println("        " + line.trim()));
        return points;
    }

    static void printExercise(Exercise exercise, int points, String note) {
        IO.println("  %s: %d/%d %s".formatted(exercise.id(), points,
            exercise.maxPoints(), note));
    }

    String runTest(Path dir) throws Exception {
        final var log = Files.createTempFile("check-output-", ".txt");
        try {
            final var process = new ProcessBuilder(javaCommand(), "Test.java")
                .directory(dir.toFile())
                .redirectErrorStream(true)
                .redirectOutput(log.toFile())
                .start();
            process.getOutputStream().close();
            if (!process.waitFor(testTimeout.toMillis(), TimeUnit.MILLISECONDS)) {
                killProcessTree(process);
                return "FAIL: test timed out";
            }
            return Files.readString(log);
        } finally {
            Files.deleteIfExists(log);
        }
    }

    // Test.java starts the student's program as a child process, which
    // would keep running (for example in an infinite loop) if only the
    // test process were killed. The test is killed first so that it cannot
    // start a new child after its current one dies.
    static void killProcessTree(Process process) throws InterruptedException {
        final var children = process.descendants().toList();
        process.destroyForcibly();
        children.forEach(ProcessHandle::destroyForcibly);
        process.waitFor(10, TimeUnit.SECONDS);
    }

    static String javaCommand() {
        return ProcessHandle.current().info().command().orElse("java");
    }

    // The test prints its summary last; earlier matches may come from the
    // student's own output echoed in FAIL lines.
    static int parsePoints(String output) {
        return SUMMARY_LINE.matcher(output).results()
            .reduce((first, second) -> second)
            .map(m -> Integer.parseInt(m.group(1)))
            .orElse(0);
    }

    static int countNotes(Assignment assignment, Path root) throws IOException {
        int count = 0;
        for (final var name : assignment.notes()) {
            final var note = root.resolve("notes").resolve(name);
            if (isPdf(note)) {
                count++;
            } else {
                IO.println("  Note missing or not a PDF: notes/" + name);
            }
        }
        IO.println("  Notes: %d/%d".formatted(count, assignment.notes().size()));
        return count;
    }

    // A complete PDF starts with %PDF and has %%EOF near its end, so a file
    // that was cut off while copying or uploading is rejected.
    static boolean isPdf(Path file) throws IOException {
        if (!Files.isRegularFile(file)) {
            return false;
        }
        try (final var in = new RandomAccessFile(file.toFile(), "r")) {
            final long tailStart = Math.max(0, in.length() - PDF_TAIL_BYTES);
            return readText(in, 0, 4).equals("%PDF")
                && readText(in, tailStart, PDF_TAIL_BYTES).contains("%%EOF");
        }
    }

    static String readText(RandomAccessFile in, long start, int maxBytes)
        throws IOException {
        final var bytes = new byte[(int) Math.min(maxBytes, in.length() - start)];
        in.seek(start);
        in.readFully(bytes);
        return new String(bytes, StandardCharsets.ISO_8859_1);
    }

    static void deleteRecursively(Path dir) throws IOException {
        try (final Stream<Path> files = Files.walk(dir)) {
            for (final var file : files.sorted(Comparator.reverseOrder()).toList()) {
                Files.deleteIfExists(file);
            }
        }
    }

    static void printSummary(List<Result> results) {
        IO.println("\n=== Summary ===");
        for (int i = 0; i < results.size(); i++) {
            final var r = results.get(i);
            IO.println("  assignment%02d: points %d/%d, notes %d/%d".formatted(
                i + 1, r.points(), r.maxPoints(), r.notes(), r.maxNotes()));
        }
        final int points = results.stream().mapToInt(Result::points).sum();
        final int maxPoints = results.stream().mapToInt(Result::maxPoints).sum();
        final int notes = results.stream().mapToInt(Result::notes).sum();
        final int maxNotes = results.stream().mapToInt(Result::maxNotes).sum();
        final double pointsPct = 100.0 * points / maxPoints;
        final double notesPct = 100.0 * notes / maxNotes;
        IO.println("\n  Total points: %d/%d (%.1f%%), minimum 50%%"
            .formatted(points, maxPoints, pointsPct));
        IO.println("  Total notes:  %d/%d (%.1f%%), minimum 70%%"
            .formatted(notes, maxNotes, notesPct));
        IO.println("  Estimated grade: " + estimateGrade(pointsPct, notesPct));
        IO.println("\n  This is an unofficial estimate. The official results"
            + " are on the results page.");
    }

    static String estimateGrade(double pointsPct, double notesPct) {
        if (notesPct < 70 || pointsPct < 50) {
            return "fail (requirements not met yet)";
        }
        final int grade = Math.min(5, (int) ((pointsPct - 50) / 10) + 1);
        return String.valueOf(grade);
    }
}
