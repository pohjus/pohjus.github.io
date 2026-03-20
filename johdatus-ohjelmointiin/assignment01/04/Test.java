import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("7\n2\n");
    if (output.contains("hellurei")) {
        IO.println("  PASS: prints 'hellurei' when first > second (7 > 2)");
        passed++;
    } else {
        IO.println("  FAIL: expected 'hellurei' when first > second (7 > 2), got: " + output.trim());
    }

    total++;
    output = run("2\n7\n");
    if (!output.contains("hellurei")) {
        IO.println("  PASS: does not print 'hellurei' when first < second (2 < 7)");
        passed++;
    } else {
        IO.println("  FAIL: should not print 'hellurei' when first < second (2 < 7), got: " + output.trim());
    }

    total++;
    output = run("5\n5\n");
    if (!output.contains("hellurei")) {
        IO.println("  PASS: does not print 'hellurei' when numbers are equal (5 = 5)");
        passed++;
    } else {
        IO.println("  FAIL: should not print 'hellurei' when numbers are equal (5 = 5), got: " + output.trim());
    }

    IO.println("Exercise 04: " + passed + "/" + total + " passed");
}

String run(String input) throws Exception {
    var pb = new ProcessBuilder("java", "Main.java");
    pb.redirectErrorStream(true);
    var process = pb.start();
    if (input != null) {
        process.getOutputStream().write(input.getBytes());
        process.getOutputStream().close();
    } else {
        process.getOutputStream().close();
    }
    var output = new String(process.getInputStream().readAllBytes());
    boolean exited = process.waitFor(10, TimeUnit.SECONDS);
    if (!exited) {
        process.destroyForcibly();
        return "";
    }
    return output;
}
