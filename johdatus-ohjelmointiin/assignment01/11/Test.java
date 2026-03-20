import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    var output = run(null);
    var lines = output.lines()
        .map(String::trim)
        .filter(line -> !line.isEmpty())
        .toList();

    total++;
    if (lines.size() == 10) {
        IO.println("  PASS: exactly 10 lines of output");
        passed++;
    } else {
        IO.println("  FAIL: expected 10 lines, got " + lines.size());
    }

    total++;
    if (lines.size() >= 2) {
        boolean descending = true;
        for (int i = 0; i < lines.size() - 1; i++) {
            if (Integer.parseInt(lines.get(i)) <= Integer.parseInt(lines.get(i + 1))) {
                descending = false;
                break;
            }
        }
        if (descending) {
            IO.println("  PASS: numbers are in descending order");
            passed++;
        } else {
            IO.println("  FAIL: numbers should be in descending order");
        }
    } else {
        IO.println("  FAIL: not enough lines to check order, got " + lines.size() + " lines");
    }

    total++;
    if (!lines.isEmpty() && lines.get(0).equals("10")) {
        IO.println("  PASS: first number is 10");
        passed++;
    } else {
        var actual = lines.isEmpty() ? "(empty)" : lines.get(0);
        IO.println("  FAIL: first number should be 10, got: " + actual);
    }

    total++;
    if (!lines.isEmpty() && lines.get(lines.size() - 1).equals("1")) {
        IO.println("  PASS: last number is 1");
        passed++;
    } else {
        var actual = lines.isEmpty() ? "(empty)" : lines.get(lines.size() - 1);
        IO.println("  FAIL: last number should be 1, got: " + actual);
    }

    IO.println("Exercise 11: " + passed + "/" + total + " passed");
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
