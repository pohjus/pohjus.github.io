import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    // Test 1: 2x3 array with values 1-6
    total++;
    var output1 = run("2\n3\n1\n2\n3\n4\n5\n6\n");
    if (output1.contains("1 2 3") && output1.contains("4 5 6")) {
        IO.println("  PASS: 2x3 array produces correct output");
        passed++;
    } else {
        IO.println("  FAIL: expected '1 2 3' and '4 5 6', got: " + output1.trim());
    }

    // Test 2: 3x2 array with values 1-6
    total++;
    var output2 = run("3\n2\n1\n2\n3\n4\n5\n6\n");
    if (output2.contains("1 2") && output2.contains("3 4") && output2.contains("5 6")) {
        IO.println("  PASS: 3x2 array produces correct output");
        passed++;
    } else {
        IO.println("  FAIL: expected '1 2', '3 4', '5 6', got: " + output2.trim());
    }

    // Test 3: output contains "Number of rows:"
    total++;
    if (output1.contains("Number of rows:")) {
        IO.println("  PASS: output contains 'Number of rows:'");
        passed++;
    } else {
        IO.println("  FAIL: expected output to contain 'Number of rows:', got: " + output1.trim());
    }

    // Test 4: output contains "Number of columns:"
    total++;
    if (output1.contains("Number of columns:")) {
        IO.println("  PASS: output contains 'Number of columns:'");
        passed++;
    } else {
        IO.println("  FAIL: expected output to contain 'Number of columns:', got: " + output1.trim());
    }

    // Test 5: output contains "Enter values:"
    total++;
    if (output1.contains("Enter values:")) {
        IO.println("  PASS: output contains 'Enter values:'");
        passed++;
    } else {
        IO.println("  FAIL: expected output to contain 'Enter values:', got: " + output1.trim());
    }

    // Test 6: output contains "2D array is:"
    total++;
    if (output1.contains("2D array is:")) {
        IO.println("  PASS: output contains '2D array is:'");
        passed++;
    } else {
        IO.println("  FAIL: expected output to contain '2D array is:', got: " + output1.trim());
    }

    IO.println("Exercise 06: " + passed + "/" + total + " passed");
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
