import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run(null, "1", "+", "2");
    if (resultLine(output).equals("result = 3")) {
        IO.println("  PASS: 1 + 2 = 3");
        passed++;
    } else {
        IO.println("  FAIL: expected result = 3, got: " + output.trim());
    }

    total++;
    output = run(null, "10", "-", "3");
    if (resultLine(output).equals("result = 7")) {
        IO.println("  PASS: 10 - 3 = 7");
        passed++;
    } else {
        IO.println("  FAIL: expected result = 7, got: " + output.trim());
    }

    total++;
    output = run(null, "4", "x", "5");
    if (resultLine(output).equals("result = 20")) {
        IO.println("  PASS: 4 x 5 = 20");
        passed++;
    } else {
        IO.println("  FAIL: expected result = 20, got: " + output.trim());
    }

    total++;
    output = run(null, "10", "/", "2");
    if (resultLine(output).equals("result = 5")) {
        IO.println("  PASS: 10 / 2 = 5");
        passed++;
    } else {
        IO.println("  FAIL: expected result = 5, got: " + output.trim());
    }

    total++;
    output = run(null, "5", "-", "10");
    if (resultLine(output).equals("result = -5")) {
        IO.println("  PASS: 5 - 10 = -5");
        passed++;
    } else {
        IO.println("  FAIL: expected result = -5, got: " + output.trim());
    }

    total++;
    output = run(null, "7", "/", "2");
    if (resultLine(output).equals("result = 3")) {
        IO.println("  PASS: 7 / 2 = 3 (integer division)");
        passed++;
    } else {
        IO.println("  FAIL: expected result = 3, got: " + output.trim());
    }

    total++;
    output = run(null);
    if (output != null && !output.trim().isEmpty()) {
        IO.println("  PASS: no args prints error message");
        passed++;
    } else {
        IO.println("  FAIL: expected error message with no args");
    }

    IO.println("Exercise 07: " + passed + "/" + total + " passed");
}

String resultLine(String output) {
    for (String line : output.split("\n")) {
        String trimmed = line.trim();
        if (trimmed.startsWith("result")) {
            return trimmed;
        }
    }
    return "";
}

String run(String input, String... args) throws Exception {
    var cmd = new java.util.ArrayList<String>();
    cmd.add("java");
    cmd.add("Main.java");
    for (var a : args) cmd.add(a);
    var pb = new ProcessBuilder(cmd);
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
