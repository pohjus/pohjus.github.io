import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("2\n3\n");
    var lastLine = getLastLine(output);
    if (lastLine.equals("6")) {
        IO.println("  PASS: inputs 2 and 3 produce '6'");
        passed++;
    } else {
        IO.println("  FAIL: expected '6' for inputs 2 and 3, got: " + lastLine);
    }

    total++;
    output = run("5\n5\n");
    lastLine = getLastLine(output);
    if (lastLine.equals("25")) {
        IO.println("  PASS: inputs 5 and 5 produce '25'");
        passed++;
    } else {
        IO.println("  FAIL: expected '25' for inputs 5 and 5, got: " + lastLine);
    }

    IO.println("Exercise 10: " + passed + "/" + total + " passed");
}

String getLastLine(String output) {
    var lines = output.lines()
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
