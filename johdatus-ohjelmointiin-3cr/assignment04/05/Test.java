import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("3\nAda\nMarianne\nLi\n");
    if (output.contains("Marianne")) {
        IO.println("  PASS: longest name is Marianne");
        passed++;
    } else {
        IO.println("  FAIL: expected Marianne, got: " + output.trim());
    }

    total++;
    output = run("2\nAB\nCD\n");
    if (output.contains("AB")) {
        IO.println("  PASS: first wins on tie (AB)");
        passed++;
    } else {
        IO.println("  FAIL: expected AB on tie, got: " + output.trim());
    }

    total++;
    output = run("1\nAda\n");
    if (output.contains("Ada")) {
        IO.println("  PASS: single name Ada");
        passed++;
    } else {
        IO.println("  FAIL: expected Ada, got: " + output.trim());
    }

    total++;
    output = run("3\nAl\nBo\nSam\n");
    if (output.contains("Sam")) {
        IO.println("  PASS: longest name last (Sam)");
        passed++;
    } else {
        IO.println("  FAIL: expected Sam, got: " + output.trim());
    }

    IO.println("Exercise 05: " + passed + "/" + total + " passed");
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
