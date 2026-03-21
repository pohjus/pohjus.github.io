import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("Otto\n");
    var lines = output.lines()
        .map(String::trim)
        .filter(line -> !line.isEmpty())
        .toList();
    boolean hasUpperO = false;
    int singleCharLines = 0;
    for (var line : lines) {
        if (line.length() == 1) { singleCharLines++; }
        if (line.equals("O")) { hasUpperO = true; }
    }
    if (singleCharLines >= 3 && hasUpperO && lines.get(lines.size() - 1).equals("O")) {
        IO.println("  PASS: 'Otto' reversed prints characters ending with O");
        passed++;
    } else {
        IO.println("  FAIL: expected reversed characters ending with O, got: " + lines);
    }

    total++;
    output = run("ABC\n");
    lines = output.lines()
        .map(String::trim)
        .filter(line -> !line.isEmpty())
        .toList();
    if (lines.size() >= 3
            && lines.stream().anyMatch(line -> line.equals("C") || line.endsWith("C"))
            && lines.stream().anyMatch(line -> line.equals("B"))
            && lines.stream().anyMatch(line -> line.equals("A"))) {
        IO.println("  PASS: 'ABC' reversed prints C, B, A");
        passed++;
    } else {
        IO.println("  FAIL: expected C, B, A, got: " + lines);
    }

    IO.println("Exercise 04: " + passed + "/" + total + " passed");
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
