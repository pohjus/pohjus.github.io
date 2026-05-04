import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("3\n7\n");
    var lastLine = getLastNonPromptLine(output);
    if (lastLine.equals("7")) {
        IO.println("  PASS: prints 7 as larger of 3 and 7");
        passed++;
    } else {
        IO.println("  FAIL: expected '7' as larger of 3 and 7, got: " + lastLine);
    }

    total++;
    output = run("9\n2\n");
    lastLine = getLastNonPromptLine(output);
    if (lastLine.equals("9")) {
        IO.println("  PASS: prints 9 as larger of 9 and 2");
        passed++;
    } else {
        IO.println("  FAIL: expected '9' as larger of 9 and 2, got: " + lastLine);
    }

    total++;
    output = run("100\n200\n");
    lastLine = getLastNonPromptLine(output);
    if (lastLine.equals("200")) {
        IO.println("  PASS: prints 200 as larger of 100 and 200");
        passed++;
    } else {
        IO.println("  FAIL: expected '200' as larger of 100 and 200, got: " + lastLine);
    }

    total++;
    output = run("5\n5\n");
    lastLine = getLastNonPromptLine(output);
    if (lastLine.equals("5")) {
        IO.println("  PASS: prints 5 for equal inputs 5 and 5");
        passed++;
    } else {
        IO.println("  FAIL: expected '5' for equal inputs 5 and 5, got: " + lastLine);
    }

    IO.println("Exercise 06: " + passed + "/" + total + " passed");
}

String getLastNonPromptLine(String output) {
    var cleaned = output.replaceAll("Enter[^:]*:\\s*", "");
    var lines = cleaned.lines()
        .map(String::trim)
        .filter(line -> !line.isEmpty())
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
