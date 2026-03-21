import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run(null);
    if (output.contains("|+++") && output.contains("|++++")) {
        IO.println("  PASS: positive values show + signs after |");
        passed++;
    } else {
        IO.println("  FAIL: expected + signs for positive values, got: " + output.trim());
    }

    total++;
    if (output.contains("---|") && output.contains("-|")) {
        IO.println("  PASS: negative values show - signs before |");
        passed++;
    } else {
        IO.println("  FAIL: expected - signs for negative values, got: " + output.trim());
    }

    total++;
    var lines = output.lines().toList();
    boolean hasZeroLine = false;
    for (var line : lines) {
        if (line.trim().equals("|")) {
            hasZeroLine = true;
            break;
        }
    }
    if (hasZeroLine) {
        IO.println("  PASS: zero shows only |");
        passed++;
    } else {
        IO.println("  FAIL: expected '|' for zero value");
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
