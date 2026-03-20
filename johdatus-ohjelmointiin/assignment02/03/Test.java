import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("10\n");
    if (output.contains("Working hours are in progress!")) {
        IO.println("  PASS: hour 10 prints 'Working hours are in progress!'");
        passed++;
    } else {
        IO.println("  FAIL: expected 'Working hours are in progress!' for hour 10, got: " + output.trim());
    }

    total++;
    output = run("20\n");
    if (!output.contains("Working hours are in progress!")) {
        IO.println("  PASS: hour 20 prints nothing");
        passed++;
    } else {
        IO.println("  FAIL: should not print for hour 20, got: " + output.trim());
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
