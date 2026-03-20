import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    var output = run(null);
    var lines = output.lines()
        .filter(line -> line.trim().equals("Batman"))
        .toList();

    total++;
    if (lines.size() == 3) {
        IO.println("  PASS: 'Batman' printed exactly 3 times");
        passed++;
    } else {
        IO.println("  FAIL: expected 'Batman' 3 times, found " + lines.size() + " times, got: " + output.trim());
    }

    IO.println("Exercise 08: " + passed + "/" + total + " passed");
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
