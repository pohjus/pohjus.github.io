import java.util.concurrent.TimeUnit;
import java.util.List;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("Otto\n");
    var singleChars = output.lines()
        .map(String::trim)
        .filter(line -> line.length() == 1)
        .toList();
    if (singleChars.equals(List.of("O", "t", "t", "o"))) {
        IO.println("  PASS: 'Otto' prints O, t, t, o on separate lines");
        passed++;
    } else {
        IO.println("  FAIL: expected [O, t, t, o], got: " + singleChars);
    }

    total++;
    output = run("AB\n");
    singleChars = output.lines()
        .map(String::trim)
        .filter(line -> line.length() == 1)
        .toList();
    if (singleChars.equals(List.of("A", "B"))) {
        IO.println("  PASS: 'AB' prints A, B on separate lines");
        passed++;
    } else {
        IO.println("  FAIL: expected [A, B], got: " + singleChars);
    }

    IO.println("Exercise 02: " + passed + "/" + total + " passed");
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
