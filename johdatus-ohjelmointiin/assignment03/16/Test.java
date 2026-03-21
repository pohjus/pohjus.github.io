import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("seppo\n");
    var lines = output.lines()
        .map(String::trim)
        .filter(line -> !line.isEmpty())
        .filter(line -> !line.contains("Enter") && !line.contains("name"))
        .toList();
    if (!lines.isEmpty() && lines.get(lines.size() - 1).length() == 5) {
        IO.println("  PASS: output has same length as input (5 chars)");
        passed++;
    } else {
        IO.println("  FAIL: expected 5-char output, got: " + lines);
    }

    total++;
    var lastLine = lines.isEmpty() ? "" : lines.get(lines.size() - 1);
    char[] sorted = lastLine.toCharArray();
    java.util.Arrays.sort(sorted);
    if (new String(sorted).equals("eopps")) {
        IO.println("  PASS: shuffled output contains same characters as 'seppo'");
        passed++;
    } else {
        IO.println("  FAIL: expected same characters as 'seppo', got: " + lastLine);
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
