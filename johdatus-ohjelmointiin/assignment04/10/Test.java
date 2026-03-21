import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run(null, "1", "2", "3");
    if (output.trim().equals("3, 2, 1")) {
        IO.println("  PASS: reverse of [1,2,3] is 3, 2, 1");
        passed++;
    } else {
        IO.println("  FAIL: expected 3, 2, 1, got: " + output.trim());
    }

    total++;
    output = run(null, "5");
    if (output.trim().equals("5")) {
        IO.println("  PASS: reverse of [5] is 5");
        passed++;
    } else {
        IO.println("  FAIL: expected 5, got: " + output.trim());
    }

    total++;
    output = run(null, "1", "2", "3", "4");
    if (output.trim().equals("4, 3, 2, 1")) {
        IO.println("  PASS: reverse of [1,2,3,4] is 4, 3, 2, 1");
        passed++;
    } else {
        IO.println("  FAIL: expected 4, 3, 2, 1, got: " + output.trim());
    }

    total++;
    output = run(null, "8", "3");
    if (output.trim().equals("3, 8")) {
        IO.println("  PASS: reverse of [8,3] is 3, 8");
        passed++;
    } else {
        IO.println("  FAIL: expected 3, 8, got: " + output.trim());
    }

    total++;
    output = run(null);
    if (output != null && !output.trim().isEmpty()) {
        IO.println("  PASS: no args prints error message");
        passed++;
    } else {
        IO.println("  FAIL: expected error message with no args");
    }

    IO.println("Exercise 10: " + passed + "/" + total + " passed");
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
