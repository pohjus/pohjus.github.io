import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("Tiina\nHeli\nlopeta\n");
    var lines = output.lines()
        .map(String::trim)
        .filter(line -> !line.isEmpty())
        .toList();
    boolean hasTiinaAlone = lines.stream().anyMatch(line -> line.equals("Tiina"));
    boolean hasTiinaHeli = lines.stream().anyMatch(line -> line.equals("TiinaHeli"));
    if (hasTiinaAlone && hasTiinaHeli) {
        IO.println("  PASS: accumulates names correctly (Tiina alone, then TiinaHeli)");
        passed++;
    } else {
        IO.println("  FAIL: expected 'Tiina' as own line and 'TiinaHeli' as own line, got: " + lines);
    }

    total++;
    output = run("lopeta\n");
    lines = output.lines()
        .map(String::trim)
        .filter(line -> !line.isEmpty())
        .filter(line -> !line.contains("Enter") && !line.contains("name"))
        .toList();
    if (lines.isEmpty()) {
        IO.println("  PASS: no names printed when 'lopeta' entered immediately");
        passed++;
    } else {
        IO.println("  FAIL: expected no names, got: " + lines);
    }

    total++;
    output = run("Tiina\nHeli\nKalle\nlopeta\n");
    lines = output.lines()
        .map(String::trim)
        .filter(line -> !line.isEmpty())
        .toList();
    boolean hasTiinaHeliKalle = lines.stream().anyMatch(line -> line.equals("TiinaHeliKalle"));
    if (hasTiinaHeliKalle) {
        IO.println("  PASS: accumulates 3 names correctly (TiinaHeliKalle)");
        passed++;
    } else {
        IO.println("  FAIL: expected 'TiinaHeliKalle' as own line, got: " + lines);
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
