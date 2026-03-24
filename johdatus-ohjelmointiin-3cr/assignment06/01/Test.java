import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    // Test 1: output contains "7"
    total++;
    var output = run(null);
    if (output.contains("7")) {
        IO.println("  PASS: output contains 7");
        passed++;
    } else {
        IO.println("  FAIL: expected output to contain 7, got: " + output.trim());
    }

    // Test 2: output trimmed equals "7"
    total++;
    if (output.trim().equals("7")) {
        IO.println("  PASS: output trimmed equals 7");
        passed++;
    } else {
        IO.println("  FAIL: expected trimmed output to equal 7, got: " + output.trim());
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
