import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n");
    if (output.contains("Sum of entered numbers: 10")) {
        IO.println("  PASS: sum of ten 1s is 10");
        passed++;
    } else {
        IO.println("  FAIL: expected 'Sum of entered numbers: 10', got: " + output.trim());
    }

    total++;
    output = run("1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n");
    if (output.contains("Sum of entered numbers: 55")) {
        IO.println("  PASS: sum of 1-10 is 55");
        passed++;
    } else {
        IO.println("  FAIL: expected 'Sum of entered numbers: 55', got: " + output.trim());
    }

    total++;
    output = run("1\n-1\n2\n-2\n3\n-3\n4\n-4\n5\n-5\n");
    if (output.contains("Sum of entered numbers: 0")) {
        IO.println("  PASS: sum with negatives is 0");
        passed++;
    } else {
        IO.println("  FAIL: expected 'Sum of entered numbers: 0', got: " + output.trim());
    }

    total++;
    output = run("10\n20\n30\n40\n50\n60\n70\n80\n90\n100\n");
    if (output.contains("Sum of entered numbers: 550")) {
        IO.println("  PASS: sum of 10-100 by 10s is 550");
        passed++;
    } else {
        IO.println("  FAIL: expected 'Sum of entered numbers: 550', got: " + output.trim());
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
