import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run();
    var lines = output.lines().filter(l -> !l.isBlank()).toList();
    if (lines.size() == 3
            && lines.get(0).trim().equals("32")
            && lines.get(1).trim().equals("99")
            && lines.get(2).trim().equals("12")) {
        IO.println("  PASS: reverse order correct");
        passed++;
    } else {
        IO.println("  FAIL: expected 32,99,12, got: " + output.trim());
    }

    total++;
    if (lines.size() == 3) {
        IO.println("  PASS: exactly 3 non-empty lines");
        passed++;
    } else {
        IO.println("  FAIL: expected 3 non-empty lines, got: " + lines.size());
    }

    IO.println("Exercise 02: " + passed + "/" + total + " passed");
}

String run() throws Exception {
    var pb = new ProcessBuilder("java", "Main.java");
    pb.redirectErrorStream(true);
    var process = pb.start();
    process.getOutputStream().close();
    var output = new String(process.getInputStream().readAllBytes());
    boolean exited = process.waitFor(10, TimeUnit.SECONDS);
    if (!exited) {
        process.destroyForcibly();
        return "";
    }
    return output;
}
