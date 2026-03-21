import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("5\n");
    var count = output.lines()
        .filter(line -> line.trim().equals("Batman"))
        .count();
    if (count == 5) {
        IO.println("  PASS: 'Batman' printed 5 times for input 5");
        passed++;
    } else {
        IO.println("  FAIL: expected 'Batman' 5 times for input 5, found " + count);
    }

    total++;
    output = run("1\n");
    count = output.lines()
        .filter(line -> line.trim().equals("Batman"))
        .count();
    if (count == 1) {
        IO.println("  PASS: 'Batman' printed 1 time for input 1");
        passed++;
    } else {
        IO.println("  FAIL: expected 'Batman' 1 time for input 1, found " + count);
    }

    total++;
    output = run("0\n");
    count = output.lines()
        .filter(line -> line.trim().equals("Batman"))
        .count();
    if (count == 0) {
        IO.println("  PASS: 'Batman' printed 0 times for input 0");
        passed++;
    } else {
        IO.println("  FAIL: expected 'Batman' 0 times for input 0, found " + count);
    }

    IO.println("Exercise 09: " + passed + "/" + total + " passed");
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
