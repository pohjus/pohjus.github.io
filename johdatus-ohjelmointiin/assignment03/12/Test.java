import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run(null);
    var lines = output.lines()
        .map(String::trim)
        .filter(line -> !line.isEmpty())
        .toList();
    if (lines.size() == 5) {
        IO.println("  PASS: prints exactly 5 lines");
        passed++;
    } else {
        IO.println("  FAIL: expected 5 lines, got " + lines.size());
    }

    total++;
    boolean allValid = true;
    for (var line : lines) {
        try {
            double val = Double.parseDouble(line);
            if (val < 0 || val >= 1) {
                allValid = false;
                break;
            }
        } catch (NumberFormatException e) {
            allValid = false;
            break;
        }
    }
    if (allValid && lines.size() == 5) {
        IO.println("  PASS: all values are doubles in [0, 1[");
        passed++;
    } else {
        IO.println("  FAIL: expected doubles in [0, 1[, got: " + lines);
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
