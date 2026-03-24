import java.util.concurrent.TimeUnit;
import java.nio.file.Files;
import java.nio.file.Path;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    var output = run(null);
    var lines = output.lines().filter(l -> !l.isBlank()).toList();

    // Test 1: output contains Rectangle@ (default toString)
    total++;
    boolean hasRectAt = lines.stream().anyMatch(l -> l.contains("Rectangle@"));
    if (hasRectAt) {
        IO.println("  PASS: output contains 'Rectangle@' (default toString)");
        passed++;
    } else {
        IO.println("  FAIL: expected output to contain 'Rectangle@', got: " + output.trim());
    }

    // Test 2: output shows modified width value 10
    total++;
    boolean has10 = lines.stream().anyMatch(l -> l.trim().equals("10"));
    if (has10) {
        IO.println("  PASS: output contains '10' (modified width via reference)");
        passed++;
    } else {
        IO.println("  FAIL: expected '10' in output after modifying a.width");
    }

    // Test 3: output shows modified height value 20
    total++;
    boolean has20 = lines.stream().anyMatch(l -> l.trim().equals("20"));
    if (has20) {
        IO.println("  PASS: output contains '20' (modified height via reference)");
        passed++;
    } else {
        IO.println("  FAIL: expected '20' in output after modifying a.height");
    }

    // Test 4: source contains a comment about reference behavior
    total++;
    String testSource = Files.readString(Path.of("Main.java"));
    if (testSource.contains("//") || testSource.contains("/*")) {
        IO.println("  PASS: Main.java contains a comment");
        passed++;
    } else {
        IO.println("  FAIL: expected a comment explaining reference behavior");
    }

    IO.println("Exercise 02: " + passed + "/" + total + " passed");
}

String compile() throws Exception {
    var pb = new ProcessBuilder("javac", "Rectangle.java", "Main.java");
    pb.redirectErrorStream(true);
    var process = pb.start();
    var output = new String(process.getInputStream().readAllBytes());
    process.waitFor(10, TimeUnit.SECONDS);
    if (process.exitValue() != 0) {
        return output;
    }
    return null;
}

String run(String input) throws Exception {
    compile();
    var pb = new ProcessBuilder("java", "Main");
    pb.redirectErrorStream(true);
    var process = pb.start();
    if (input != null) {
        process.getOutputStream().write(input.getBytes());
    }
    process.getOutputStream().close();
    var output = new String(process.getInputStream().readAllBytes());
    boolean exited = process.waitFor(10, TimeUnit.SECONDS);
    if (!exited) {
        process.destroyForcibly();
        return "";
    }
    return output;
}
