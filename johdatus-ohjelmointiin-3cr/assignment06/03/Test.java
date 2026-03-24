import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    var output = run(null);

    // Test 1: output contains "1 3 9"
    total++;
    if (output.contains("1 3 9")) {
        IO.println("  PASS: output contains 1 3 9");
        passed++;
    } else {
        IO.println("  FAIL: expected output to contain '1 3 9', got: " + output.trim());
    }

    // Test 2: output contains "2 7 3"
    total++;
    if (output.contains("2 7 3")) {
        IO.println("  PASS: output contains 2 7 3");
        passed++;
    } else {
        IO.println("  FAIL: expected output to contain '2 7 3', got: " + output.trim());
    }

    // Test 3: output has 2 non-empty lines
    total++;
    String[] lines = output.trim().split("\n");
    int nonEmpty = 0;
    for (var line : lines) {
        if (!line.trim().isEmpty()) {
            nonEmpty++;
        }
    }
    if (nonEmpty == 2) {
        IO.println("  PASS: output has 2 non-empty lines");
        passed++;
    } else {
        IO.println("  FAIL: expected 2 non-empty lines, got " + nonEmpty);
    }

    // Test 4: "1 3 9" appears before "2 7 3"
    total++;
    int idx1 = output.indexOf("1 3 9");
    int idx2 = output.indexOf("2 7 3");
    if (idx1 >= 0 && idx2 >= 0 && idx1 < idx2) {
        IO.println("  PASS: '1 3 9' appears before '2 7 3'");
        passed++;
    } else {
        IO.println("  FAIL: expected '1 3 9' to appear before '2 7 3', got: " + output.trim());
    }

    IO.println("Exercise 03: " + passed + "/" + total + " passed");
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
