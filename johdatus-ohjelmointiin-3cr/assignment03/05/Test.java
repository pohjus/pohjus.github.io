import java.util.concurrent.TimeUnit;
import java.util.List;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("5\n10\n");
    var numLines = output.lines()
        .map(String::trim)
        .filter(line -> line.matches("-?\\d+"))
        .toList();
    if (numLines.equals(List.of("5", "6", "7", "8", "9", "10"))) {
        IO.println("  PASS: 5 to 10 prints all numbers");
        passed++;
    } else {
        IO.println("  FAIL: expected [5, 6, 7, 8, 9, 10], got: " + numLines);
    }

    total++;
    output = run("2\n-3\n");
    numLines = output.lines()
        .map(String::trim)
        .filter(line -> line.matches("-?\\d+"))
        .toList();
    if (numLines.equals(List.of("-3", "-2", "-1", "0", "1", "2"))) {
        IO.println("  PASS: 2 and -3 prints -3 to 2");
        passed++;
    } else {
        IO.println("  FAIL: expected [-3, -2, -1, 0, 1, 2], got: " + numLines);
    }

    total++;
    output = run("3\n3\n");
    numLines = output.lines()
        .map(String::trim)
        .filter(line -> line.matches("-?\\d+"))
        .toList();
    if (numLines.equals(List.of("3"))) {
        IO.println("  PASS: equal inputs prints the number");
        passed++;
    } else {
        IO.println("  FAIL: expected [3], got: " + numLines);
    }

    IO.println("Exercise 05: " + passed + "/" + total + " passed");
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
