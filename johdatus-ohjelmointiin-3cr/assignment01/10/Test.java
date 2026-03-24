import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("5\n3\n8\n2\n0\n");
    var lastLine = getLastNonPromptLine(output);
    if (lastLine.equals("8")) {
        IO.println("  PASS: largest is 8 for input [5, 3, 8, 2, 0]");
        passed++;
    } else {
        IO.println("  FAIL: expected '8' as largest for input [5, 3, 8, 2, 0], got: " + lastLine);
    }

    total++;
    output = run("1\n0\n");
    lastLine = getLastNonPromptLine(output);
    if (lastLine.equals("1")) {
        IO.println("  PASS: largest is 1 for input [1, 0]");
        passed++;
    } else {
        IO.println("  FAIL: expected '1' as largest for input [1, 0], got: " + lastLine);
    }

    total++;
    output = run("10\n20\n5\n-1\n");
    lastLine = getLastNonPromptLine(output);
    if (lastLine.equals("20")) {
        IO.println("  PASS: largest is 20 for input [10, 20, 5, -1]");
        passed++;
    } else {
        IO.println("  FAIL: expected '20' as largest for input [10, 20, 5, -1], got: " + lastLine);
    }

    total++;
    output = run("100\n0\n");
    lastLine = getLastNonPromptLine(output);
    if (lastLine.equals("100")) {
        IO.println("  PASS: largest is 100 for input [100, 0]");
        passed++;
    } else {
        IO.println("  FAIL: expected '100' as largest for input [100, 0], got: " + lastLine);
    }

    IO.println("Exercise 10: " + passed + "/" + total + " passed");
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
