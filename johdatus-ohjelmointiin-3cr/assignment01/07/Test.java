import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("20\n");
    if (output.contains("you're young")) {
        IO.println("  PASS: age 20 outputs \"you're young\"");
        passed++;
    } else {
        IO.println("  FAIL: age 20 should output \"you're young\", got: " + output.trim());
    }

    total++;
    output = run("30\n");
    if (output.contains("you're old")) {
        IO.println("  PASS: age 30 outputs \"you're old\"");
        passed++;
    } else {
        IO.println("  FAIL: age 30 should output \"you're old\", got: " + output.trim());
    }

    total++;
    output = run("25\n");
    if (output.contains("you're old")) {
        IO.println("  PASS: age 25 outputs \"you're old\" (boundary)");
        passed++;
    } else {
        IO.println("  FAIL: age 25 should output \"you're old\" (boundary), got: " + output.trim());
    }

    total++;
    output = run("1\n");
    if (output.contains("you're young")) {
        IO.println("  PASS: age 1 outputs \"you're young\"");
        passed++;
    } else {
        IO.println("  FAIL: age 1 should output \"you're young\", got: " + output.trim());
    }

    IO.println("Exercise 07: " + passed + "/" + total + " passed");
}

String run(String input) throws Exception {
    var pb = new ProcessBuilder("java", "Main.java");
    pb.redirectErrorStream(true);
    var process = pb.start();
    if (input != null) {
        process.getOutputStream().write(input.getBytes());
        process.getOutputStream().close();
    } else {
        process.getOutputStream().close();
    }
    var output = new String(process.getInputStream().readAllBytes());
    boolean exited = process.waitFor(10, TimeUnit.SECONDS);
    if (!exited) {
        process.destroyForcibly();
        return "";
    }
    return output;
}
