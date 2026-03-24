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

    // Test 2: output does NOT contain "2 7 3"
    total++;
    if (!output.contains("2 7 3")) {
        IO.println("  PASS: output does not contain 2 7 3");
        passed++;
    } else {
        IO.println("  FAIL: expected output to not contain '2 7 3', got: " + output.trim());
    }

    IO.println("Exercise 02: " + passed + "/" + total + " passed");
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
