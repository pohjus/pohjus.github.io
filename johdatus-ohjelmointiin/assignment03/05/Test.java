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
    if (singleChars.equals(List.of("o", "t"))) {
        IO.println("  PASS: 'Otto' reversed every other prints o, t");
        passed++;
    } else {
        IO.println("  FAIL: expected [o, t], got: " + singleChars);
    }

    total++;
    output = run("ABCDE\n");
    singleChars = output.lines()
        .map(String::trim)
        .filter(line -> line.length() == 1)
        .toList();
    if (singleChars.equals(List.of("E", "C", "A"))) {
        IO.println("  PASS: 'ABCDE' reversed every other prints E, C, A");
        passed++;
    } else {
        IO.println("  FAIL: expected [E, C, A], got: " + singleChars);
    }

    total++;
    if (singleChars.size() == 3) {
        IO.println("  PASS: 'ABCDE' produces exactly 3 character lines");
        passed++;
    } else {
        IO.println("  FAIL: expected 3 character lines, got " + singleChars.size());
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
