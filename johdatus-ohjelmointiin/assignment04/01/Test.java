import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run();
    var lines = output.lines().filter(l -> !l.isBlank()).toList();
    if (lines.size() == 6
            && lines.get(0).trim().equals("12")
            && lines.get(1).trim().equals("32")
            && lines.get(2).trim().equals("3")
            && lines.get(3).trim().equals("12")
            && lines.get(4).trim().equals("99")
            && lines.get(5).trim().equals("32")) {
        IO.println("  PASS: output matches expected");
        passed++;
    } else {
        IO.println("  FAIL: expected 12,32,3,12,99,32 on six lines, got: " + output.trim());
    }

    total++;
    if (lines.size() == 6) {
        IO.println("  PASS: exactly 6 non-empty lines");
        passed++;
    } else {
        IO.println("  FAIL: expected 6 non-empty lines, got: " + lines.size());
    }

    IO.println("Exercise 01: " + passed + "/" + total + " passed");
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
