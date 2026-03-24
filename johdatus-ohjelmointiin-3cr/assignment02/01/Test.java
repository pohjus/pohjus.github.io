import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("24\n12\n");
    if (output.contains("Merry Christmas!")) {
        IO.println("  PASS: prints 'Merry Christmas!' for day 24, month 12");
        passed++;
    } else {
        IO.println("  FAIL: expected 'Merry Christmas!' for day 24, month 12, got: " + output.trim());
    }

    total++;
    output = run("3\n3\n");
    if (!output.contains("Merry Christmas!")) {
        IO.println("  PASS: prints nothing for day 3, month 3");
        passed++;
    } else {
        IO.println("  FAIL: should not print 'Merry Christmas!' for day 3, month 3, got: " + output.trim());
    }

    total++;
    output = run("24\n6\n");
    if (!output.contains("Merry Christmas!")) {
        IO.println("  PASS: prints nothing for day 24, month 6");
        passed++;
    } else {
        IO.println("  FAIL: should not print 'Merry Christmas!' for day 24, month 6, got: " + output.trim());
    }

    total++;
    output = run("25\n12\n");
    if (!output.contains("Merry Christmas!")) {
        IO.println("  PASS: prints nothing for day 25, month 12");
        passed++;
    } else {
        IO.println("  FAIL: should not print 'Merry Christmas!' for day 25, month 12, got: " + output.trim());
    }

    IO.println("Exercise 01: " + passed + "/" + total + " passed");
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
