import java.util.concurrent.TimeUnit;
import java.nio.file.Files;
import java.nio.file.Path;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    // Test 1: output contains 0 for default width
    total++;
    var output = run(null);
    var lines = output.lines().filter(l -> !l.isBlank()).toList();
    if (lines.size() >= 2 && lines.get(0).trim().equals("0")) {
        IO.println("  PASS: default width is 0");
        passed++;
    } else {
        IO.println("  FAIL: expected first line to be '0', got: " + output.trim());
    }

    // Test 2: output contains 0 for default height
    total++;
    if (lines.size() >= 2 && lines.get(1).trim().equals("0")) {
        IO.println("  PASS: default height is 0");
        passed++;
    } else {
        IO.println("  FAIL: expected second line to be '0', got: " + output.trim());
    }

    // Test 3: Rectangle.java contains public int width
    total++;
    String rectSource = Files.readString(Path.of("Rectangle.java"));
    if (rectSource.contains("public int width")) {
        IO.println("  PASS: Rectangle has 'public int width'");
        passed++;
    } else {
        IO.println("  FAIL: expected 'public int width' in Rectangle.java");
    }

    // Test 4: Rectangle.java contains public int height
    total++;
    if (rectSource.contains("public int height")) {
        IO.println("  PASS: Rectangle has 'public int height'");
        passed++;
    } else {
        IO.println("  FAIL: expected 'public int height' in Rectangle.java");
    }

    // Test 5: Main.java contains a comment
    total++;
    String testSource = Files.readString(Path.of("Main.java"));
    if (testSource.contains("//") || testSource.contains("/*")) {
        IO.println("  PASS: Main.java contains a comment");
        passed++;
    } else {
        IO.println("  FAIL: expected a comment explaining default values");
    }

    IO.println("Exercise 01: " + passed + "/" + total + " passed");
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
