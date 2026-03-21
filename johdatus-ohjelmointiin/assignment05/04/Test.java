import java.util.concurrent.TimeUnit;
import java.nio.file.Files;
import java.nio.file.Path;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    String source = Files.readString(Path.of("Main.java"));

    // Test 1: source contains returnDate method
    total++;
    if (source.matches("(?s).*String\\s+returnDate\\s*\\(\\s*\\).*")) {
        IO.println("  PASS: source contains returnDate() method");
        passed++;
    } else {
        IO.println("  FAIL: expected a 'String returnDate()' method in Main.java");
    }

    String out1 = run(null);

    // Test 2: output contains the date
    total++;
    if (out1.contains("21.3.2026")) {
        IO.println("  PASS: output contains date 21.3.2026");
        passed++;
    } else {
        IO.println("  FAIL: expected output to contain '21.3.2026', got '" + out1.trim() + "'");
    }

    // Test 3: output has exactly one non-empty line
    total++;
    String[] lines = out1.trim().split("\n");
    int nonEmptyCount = 0;
    for (var line : lines) {
        if (!line.trim().isEmpty()) {
            nonEmptyCount++;
        }
    }
    if (nonEmptyCount == 1) {
        IO.println("  PASS: output has exactly one line");
        passed++;
    } else {
        IO.println("  FAIL: expected exactly one line of output, got " + nonEmptyCount);
    }

    // Test 4: output line matches the date exactly
    total++;
    if (out1.trim().equals("21.3.2026")) {
        IO.println("  PASS: output is exactly '21.3.2026'");
        passed++;
    } else {
        IO.println("  FAIL: expected exactly '21.3.2026', got '" + out1.trim() + "'");
    }

    IO.println("Exercise 04: " + passed + "/" + total + " passed");
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
