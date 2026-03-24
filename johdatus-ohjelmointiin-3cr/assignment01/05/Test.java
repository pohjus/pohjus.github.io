import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("3\n4\n");
    var lastLine = getLastNonPromptLine(output);
    if (lastLine.equals("7")) {
        IO.println("  PASS: last line is '7' for inputs 3 and 4");
        passed++;
    } else {
        IO.println("  FAIL: expected last line '7' for inputs 3 and 4, got: " + lastLine);
    }

    total++;
    if (!output.contains("hellurei")) {
        IO.println("  PASS: does not print 'hellurei' when first < second (3 < 4)");
        passed++;
    } else {
        IO.println("  FAIL: should not print 'hellurei' when first < second (3 < 4)");
    }

    total++;
    output = run("10\n20\n");
    lastLine = getLastNonPromptLine(output);
    if (lastLine.equals("30")) {
        IO.println("  PASS: last line is '30' for inputs 10 and 20");
        passed++;
    } else {
        IO.println("  FAIL: expected last line '30' for inputs 10 and 20, got: " + lastLine);
    }

    total++;
    output = run("7\n2\n");
    if (output.contains("hellurei")) {
        IO.println("  PASS: prints 'hellurei' when first > second (7 > 2)");
        passed++;
    } else {
        IO.println("  FAIL: expected 'hellurei' when first > second (7 > 2), got: " + output.trim());
    }

    total++;
    lastLine = getLastNonPromptLine(output);
    if (lastLine.equals("9")) {
        IO.println("  PASS: last line is '9' (sum) for inputs 7 and 2");
        passed++;
    } else {
        IO.println("  FAIL: expected last line '9' (sum) for inputs 7 and 2, got: " + lastLine);
    }

    IO.println("Exercise 05: " + passed + "/" + total + " passed");
}

String getLastNonPromptLine(String output) {
    var lines = output.lines()
        .map(String::trim)
        .filter(line -> !line.isEmpty())
        .filter(line -> !line.startsWith("Enter"))
        .toList();
    return lines.isEmpty() ? "(empty)" : lines.get(lines.size() - 1);
}

String run(String input) throws Exception {
    var pb = new ProcessBuilder("java", "Main.java");
    pb.redirectErrorStream(true);
    var process = pb.start();
    if (input != null) {
        process.getOutputStream().write(input.getBytes());
        process.getOutputStream().close();
    } else {
        process.getOutputStream().close();
    }
    var output = new String(process.getInputStream().readAllBytes());
    boolean exited = process.waitFor(10, TimeUnit.SECONDS);
    if (!exited) {
        process.destroyForcibly();
        return "";
    }
    return output;
}
