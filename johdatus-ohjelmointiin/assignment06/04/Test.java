import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    // Test 1: input "1\n4\n5\n1\n2\n3\n" produces "1 4 5" and "1 2 3"
    total++;
    var output1 = run("1\n4\n5\n1\n2\n3\n");
    if (output1.contains("1 4 5") && output1.contains("1 2 3")) {
        IO.println("  PASS: input 1,4,5,1,2,3 produces correct output");
        passed++;
    } else {
        IO.println("  FAIL: expected '1 4 5' and '1 2 3', got: " + output1.trim());
    }

    // Test 2: input "9\n8\n7\n6\n5\n4\n" produces "9 8 7" and "6 5 4"
    total++;
    var output2 = run("9\n8\n7\n6\n5\n4\n");
    if (output2.contains("9 8 7") && output2.contains("6 5 4")) {
        IO.println("  PASS: input 9,8,7,6,5,4 produces correct output");
        passed++;
    } else {
        IO.println("  FAIL: expected '9 8 7' and '6 5 4', got: " + output2.trim());
    }

    // Test 3: output contains "2D array is:"
    total++;
    if (output1.contains("2D array is:")) {
        IO.println("  PASS: output contains '2D array is:'");
        passed++;
    } else {
        IO.println("  FAIL: expected output to contain '2D array is:', got: " + output1.trim());
    }

    // Test 4: output contains "Enter values:"
    total++;
    if (output1.contains("Enter values:")) {
        IO.println("  PASS: output contains 'Enter values:'");
        passed++;
    } else {
        IO.println("  FAIL: expected output to contain 'Enter values:', got: " + output1.trim());
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
