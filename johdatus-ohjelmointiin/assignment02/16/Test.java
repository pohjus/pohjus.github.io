import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("5\n");
    var lines = output.lines()
        .filter(line -> line.contains("X"))
        .toList();
    boolean correct = lines.size() == 5;
    if (correct) {
        for (int i = 0; i < 5; i++) {
            var expected = " ".repeat(i) + "X";
            if (!lines.get(i).equals(expected)) { correct = false; break; }
        }
    }
    if (correct) {
        IO.println("  PASS: height 5 prints correct diagonal");
        passed++;
    } else {
        IO.println("  FAIL: height 5 diagonal incorrect, got:\n" + output.trim());
    }

    total++;
    output = run("3\n");
    lines = output.lines()
        .filter(line -> line.contains("X"))
        .toList();
    correct = lines.size() == 3;
    if (correct) {
        for (int i = 0; i < 3; i++) {
            var expected = " ".repeat(i) + "X";
            if (!lines.get(i).equals(expected)) { correct = false; break; }
        }
    }
    if (correct) {
        IO.println("  PASS: height 3 prints correct diagonal");
        passed++;
    } else {
        IO.println("  FAIL: height 3 diagonal incorrect, got:\n" + output.trim());
    }

    IO.println("Exercise 16: " + passed + "/" + total + " passed");
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
