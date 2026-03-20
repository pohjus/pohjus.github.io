import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("1\n");
    if (output.contains("Monday")) {
        IO.println("  PASS: input 1 prints 'Monday'");
        passed++;
    } else {
        IO.println("  FAIL: expected 'Monday' for input 1, got: " + output.trim());
    }

    total++;
    output = run("5\n");
    if (output.contains("Friday")) {
        IO.println("  PASS: input 5 prints 'Friday'");
        passed++;
    } else {
        IO.println("  FAIL: expected 'Friday' for input 5, got: " + output.trim());
    }

    IO.println("Exercise 12: " + passed + "/" + total + " passed");
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
