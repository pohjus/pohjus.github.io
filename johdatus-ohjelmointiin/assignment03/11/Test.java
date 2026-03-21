import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("5\n/\n2\n");
    if (output.contains("2.5")) {
        IO.println("  PASS: 5 / 2 = 2.5");
        passed++;
    } else {
        IO.println("  FAIL: expected '2.5' in output, got: " + output.trim());
    }

    total++;
    output = run("10\n+\n2\n");
    if (output.contains("12")) {
        IO.println("  PASS: 10 + 2 = 12");
        passed++;
    } else {
        IO.println("  FAIL: expected '12' in output, got: " + output.trim());
    }

    total++;
    output = run("7\n*\n3\n");
    if (output.contains("21")) {
        IO.println("  PASS: 7 * 3 = 21");
        passed++;
    } else {
        IO.println("  FAIL: expected '21' in output, got: " + output.trim());
    }

    total++;
    output = run("10\n-\n3\n");
    if (output.contains("7")) {
        IO.println("  PASS: 10 - 3 = 7");
        passed++;
    } else {
        IO.println("  FAIL: expected '7' in output, got: " + output.trim());
    }

    IO.println("Exercise 11: " + passed + "/" + total + " passed");
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
