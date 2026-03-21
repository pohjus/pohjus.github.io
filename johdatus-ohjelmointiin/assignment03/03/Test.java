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
    boolean hasO = false;
    boolean hasT = false;
    boolean hasSmallO = false;
    int singleCharLines = 0;
    for (var line : lines) {
        if (line.equals("O")) { hasO = true; singleCharLines++; }
        if (line.equals("t")) { hasT = true; singleCharLines++; }
        if (line.equals("o")) { hasSmallO = true; singleCharLines++; }
    }
    if (singleCharLines >= 3 && hasT && hasSmallO) {
        IO.println("  PASS: 'Otto' prints characters on separate lines");
        passed++;
    } else {
        IO.println("  FAIL: expected O, t, t, o on separate lines, got: " + lines);
    }

    total++;
    output = run("AB\n");
    if (output.contains("\nB") || output.lines().anyMatch(line -> line.trim().equals("B"))) {
        IO.println("  PASS: 'AB' prints characters on separate lines");
        passed++;
    } else {
        IO.println("  FAIL: expected characters on separate lines, got: " + output.trim());
    }

    IO.println("Exercise 03: " + passed + "/" + total + " passed");
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
