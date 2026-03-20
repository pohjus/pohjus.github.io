import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("5\n");
    if (output.contains("improbatur")) {
        IO.println("  PASS: score 5 outputs 'improbatur'");
        passed++;
    } else {
        IO.println("  FAIL: expected 'improbatur' for score 5, got: " + output.trim());
    }

    total++;
    output = run("20\n");
    if (output.contains("lubenter")) {
        IO.println("  PASS: score 20 outputs 'lubenter'");
        passed++;
    } else {
        IO.println("  FAIL: expected 'lubenter' for score 20, got: " + output.trim());
    }

    total++;
    output = run("55\n");
    if (output.contains("laudatur")) {
        IO.println("  PASS: score 55 outputs 'laudatur'");
        passed++;
    } else {
        IO.println("  FAIL: expected 'laudatur' for score 55, got: " + output.trim());
    }

    IO.println("Exercise 13: " + passed + "/" + total + " passed");
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
