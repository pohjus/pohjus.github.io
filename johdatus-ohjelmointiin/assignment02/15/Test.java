import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("4\n");
    var lines = output.lines()
        .filter(line -> line.contains("X"))
        .toList();
    if (lines.size() == 4 && lines.stream().allMatch(line -> line.trim().equals("XXXX"))) {
        IO.println("  PASS: height 4 prints a 4x4 square");
        passed++;
    } else {
        IO.println("  FAIL: expected 4x4 square, got: " + output.trim());
    }

    total++;
    output = run("3\n");
    lines = output.lines()
        .filter(line -> line.contains("X"))
        .toList();
    if (lines.size() == 3 && lines.stream().allMatch(line -> line.trim().equals("XXX"))) {
        IO.println("  PASS: height 3 prints a 3x3 square");
        passed++;
    } else {
        IO.println("  FAIL: expected 3x3 square, got: " + output.trim());
    }

    IO.println("Exercise 15: " + passed + "/" + total + " passed");
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
