import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run(null, "50");
    if (output.contains("Found!") || output.contains("Not found!")) {
        IO.println("  PASS: program outputs Found! or Not found!");
        passed++;
    } else {
        IO.println("  FAIL: expected 'Found!' or 'Not found!', got: " + output.trim());
    }

    total++;
    if (!output.contains("Error") && !output.contains("Exception")) {
        IO.println("  PASS: program runs without error");
        passed++;
    } else {
        IO.println("  FAIL: program produced an error: " + output.trim());
    }

    total++;
    output = run(null, "0");
    if (output.contains("Not found!")) {
        IO.println("  PASS: 0 is outside range 1-100, Not found!");
        passed++;
    } else {
        IO.println("  FAIL: expected Not found! for 0, got: " + output.trim());
    }

    total++;
    output = run(null, "101");
    if (output.contains("Not found!")) {
        IO.println("  PASS: 101 is outside range 1-100, Not found!");
        passed++;
    } else {
        IO.println("  FAIL: expected Not found! for 101, got: " + output.trim());
    }

    IO.println("Exercise 08: " + passed + "/" + total + " passed");
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
