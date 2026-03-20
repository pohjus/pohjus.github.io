import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("3\n4\n");
    if (output.contains("7")) {
        IO.println("  PASS: prints sum 7 for inputs 3 and 4");
        passed++;
    } else {
        IO.println("  FAIL: expected sum '7' for inputs 3 and 4, got: " + output.trim());
    }

    total++;
    output = run("10\n20\n");
    if (output.contains("30")) {
        IO.println("  PASS: prints sum 30 for inputs 10 and 20");
        passed++;
    } else {
        IO.println("  FAIL: expected sum '30' for inputs 10 and 20, got: " + output.trim());
    }

    total++;
    output = run("7\n2\n");
    if (output.contains("hellurei")) {
        IO.println("  PASS: prints 'hellurei' when first > second (7 > 2)");
        passed++;
    } else {
        IO.println("  FAIL: expected 'hellurei' when first > second (7 > 2), got: " + output.trim());
    }

    IO.println("Exercise 05: " + passed + "/" + total + " passed");
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
