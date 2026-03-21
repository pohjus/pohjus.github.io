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
    if (singleChars.equals(List.of("o", "t", "t", "O"))) {
        IO.println("  PASS: 'Otto' reversed prints o, t, t, O");
        passed++;
    } else {
        IO.println("  FAIL: expected [o, t, t, O], got: " + singleChars);
    }

    total++;
    output = run("ABC\n");
    singleChars = output.lines()
        .map(String::trim)
        .filter(line -> line.length() == 1)
        .toList();
    if (singleChars.equals(List.of("C", "B", "A"))) {
        IO.println("  PASS: 'ABC' reversed prints C, B, A");
        passed++;
    } else {
        IO.println("  FAIL: expected [C, B, A], got: " + singleChars);
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
