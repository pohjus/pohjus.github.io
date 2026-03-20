import java.util.concurrent.TimeUnit;
import java.util.List;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    var output = run(null);
    var lines = output.lines()
        .map(String::trim)
        .filter(line -> !line.isEmpty())
        .filter(line -> line.matches("-?\\d+"))
        .map(Integer::parseInt)
        .toList();

    // Part a: 1 to 10 (10 numbers)
    total++;
    if (lines.size() >= 10) {
        var partA = lines.subList(0, 10);
        boolean correct = true;
        for (int i = 0; i < 10; i++) {
            if (partA.get(i) != i + 1) { correct = false; break; }
        }
        if (correct) {
            IO.println("  PASS: part a: prints 1 to 10");
            passed++;
        } else {
            IO.println("  FAIL: part a: expected 1 to 10, got: " + partA);
        }
    } else {
        IO.println("  FAIL: part a: not enough output lines, got " + lines.size());
    }

    // Part b: 5 to 15 (11 numbers)
    total++;
    if (lines.size() >= 21) {
        var partB = lines.subList(10, 21);
        boolean correct = true;
        for (int i = 0; i < 11; i++) {
            if (partB.get(i) != i + 5) { correct = false; break; }
        }
        if (correct) {
            IO.println("  PASS: part b: prints 5 to 15");
            passed++;
        } else {
            IO.println("  FAIL: part b: expected 5 to 15, got: " + partB);
        }
    } else {
        IO.println("  FAIL: part b: not enough output lines");
    }

    // Part c: 10 to 0 (11 numbers)
    total++;
    if (lines.size() >= 32) {
        var partC = lines.subList(21, 32);
        boolean correct = true;
        for (int i = 0; i < 11; i++) {
            if (partC.get(i) != 10 - i) { correct = false; break; }
        }
        if (correct) {
            IO.println("  PASS: part c: prints 10 to 0");
            passed++;
        } else {
            IO.println("  FAIL: part c: expected 10 to 0, got: " + partC);
        }
    } else {
        IO.println("  FAIL: part c: not enough output lines");
    }

    // Part d: every second number from 10 to 0 (6 numbers: 10,8,6,4,2,0)
    total++;
    if (lines.size() >= 38) {
        var partD = lines.subList(32, 38);
        var expected = List.of(10, 8, 6, 4, 2, 0);
        if (partD.equals(expected)) {
            IO.println("  PASS: part d: prints every second number from 10 to 0");
            passed++;
        } else {
            IO.println("  FAIL: part d: expected " + expected + ", got: " + partD);
        }
    } else {
        IO.println("  FAIL: part d: not enough output lines");
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
