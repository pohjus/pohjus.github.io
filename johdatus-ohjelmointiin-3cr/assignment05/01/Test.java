import java.util.concurrent.TimeUnit;
import java.nio.file.Files;
import java.nio.file.Path;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    String source = Files.readString(Path.of("Main.java"));

    // Test 1: source contains printName method
    total++;
    if (source.matches("(?s).*void\\s+printName\\s*\\(\\s*\\).*")) {
        IO.println("  PASS: source contains printName() method");
        passed++;
    } else {
        IO.println("  FAIL: expected a 'void printName()' method in Main.java");
    }

    // Test 2: main calls printName
    total++;
    if (source.matches("(?s).*void\\s+main\\s*\\(.*\\)\\s*\\{[^}]*printName\\s*\\(\\s*\\).*")) {
        IO.println("  PASS: main calls printName()");
        passed++;
    } else {
        IO.println("  FAIL: expected main to call printName()");
    }

    // Test 3: program produces non-empty output
    total++;
    String out1 = run(null);
    if (!out1.trim().isEmpty()) {
        IO.println("  PASS: produces non-empty output");
        passed++;
    } else {
        IO.println("  FAIL: expected non-empty output");
    }

    // Test 4: output has exactly one non-empty line
    total++;
    String[] lines = out1.trim().split("\n");
    int nonEmptyCount = 0;
    for (var line : lines) {
        if (!line.trim().isEmpty()) {
            nonEmptyCount++;
        }
    }
    if (nonEmptyCount == 1) {
        IO.println("  PASS: output has exactly one non-empty line");
        passed++;
    } else {
        IO.println("  FAIL: expected exactly one non-empty line, got " + nonEmptyCount);
    }

    // Test 5: output contains at least 2 characters (a name)
    total++;
    String trimmed = out1.trim();
    if (trimmed.length() >= 2) {
        IO.println("  PASS: output contains at least 2 characters");
        passed++;
    } else {
        IO.println("  FAIL: expected a name with at least 2 characters, got '" + trimmed + "'");
    }

    IO.println("Exercise 01: " + passed + "/" + total + " passed");
}

String run(String input) throws Exception {
    var pb = new ProcessBuilder("java", "Main.java");
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
