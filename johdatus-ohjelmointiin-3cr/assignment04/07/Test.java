import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run(null, "2", "1", "2", "3", "2", "2");
    if (output.trim().equals("3")) {
        IO.println("  PASS: count of 2 in [1,2,3,2,2] is 3");
        passed++;
    } else {
        IO.println("  FAIL: expected 3, got: " + output.trim());
    }

    total++;
    output = run(null, "5", "1", "2", "3");
    if (output.trim().equals("0")) {
        IO.println("  PASS: count of 5 in [1,2,3] is 0");
        passed++;
    } else {
        IO.println("  FAIL: expected 0, got: " + output.trim());
    }

    total++;
    output = run(null, "3", "1", "3", "5");
    if (output.trim().equals("1")) {
        IO.println("  PASS: count of 3 in [1,3,5] is 1");
        passed++;
    } else {
        IO.println("  FAIL: expected 1, got: " + output.trim());
    }

    total++;
    output = run(null, "3", "3", "3", "3");
    if (output.trim().equals("3")) {
        IO.println("  PASS: count of 3 in [3,3,3] is 3");
        passed++;
    } else {
        IO.println("  FAIL: expected 3, got: " + output.trim());
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
