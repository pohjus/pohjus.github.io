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
            int val = Integer.parseInt(line);
            if (val < 0 || val > 4) {
                allValid = false;
                break;
            }
        } catch (NumberFormatException e) {
            allValid = false;
            break;
        }
    }
    if (allValid && lines.size() == 5) {
        IO.println("  PASS: all values are integers between 0 and 4");
        passed++;
    } else {
        IO.println("  FAIL: expected integers 0-4, got: " + lines);
    }

    total++;
    var output2 = run(null);
    var lines2 = output2.lines()
        .map(String::trim)
        .filter(line -> !line.isEmpty())
        .toList();
    boolean differs = false;
    if (lines.size() == lines2.size()) {
        for (int i = 0; i < lines.size(); i++) {
            if (!lines.get(i).equals(lines2.get(i))) {
                differs = true;
                break;
            }
        }
    } else {
        differs = true;
    }
    if (differs) {
        IO.println("  PASS: two runs produce different output (not hardcoded)");
        passed++;
    } else {
        IO.println("  FAIL: two runs produced identical output, may be hardcoded");
    }

    IO.println("Exercise 07: " + passed + "/" + total + " passed");
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
