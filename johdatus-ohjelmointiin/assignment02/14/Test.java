import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("4\n");
    if (output.contains("XXXX")) {
        IO.println("  PASS: width 4 prints 'XXXX'");
        passed++;
    } else {
        IO.println("  FAIL: expected 'XXXX' for width 4, got: " + output.trim());
    }

    total++;
    output = run("6\n");
    if (output.contains("XXXXXX")) {
        IO.println("  PASS: width 6 prints 'XXXXXX'");
        passed++;
    } else {
        IO.println("  FAIL: expected 'XXXXXX' for width 6, got: " + output.trim());
    }

    IO.println("Exercise 14: " + passed + "/" + total + " passed");
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
