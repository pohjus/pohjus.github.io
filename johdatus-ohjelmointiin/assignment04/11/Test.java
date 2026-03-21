import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    // Test 1: sum until negative
    total++;
    String out1 = run(null, new String[]{"3", "4", "5", "-1", "10"});
    if (out1.trim().equals("12")) {
        IO.println("  PASS: sum with negative stop is 12");
        passed++;
    } else {
        IO.println("  FAIL: expected '12', got '" + out1.trim() + "'");
    }

    // Test 2: no negative, sum all
    total++;
    String out2 = run(null, new String[]{"1", "2", "3"});
    if (out2.trim().equals("6")) {
        IO.println("  PASS: sum of all args is 6");
        passed++;
    } else {
        IO.println("  FAIL: expected '6', got '" + out2.trim() + "'");
    }

    // Test 3: single number
    total++;
    String out3 = run(null, new String[]{"10"});
    if (out3.trim().equals("10")) {
        IO.println("  PASS: single number returns 10");
        passed++;
    } else {
        IO.println("  FAIL: expected '10', got '" + out3.trim() + "'");
    }

    // Test 4: first arg is negative
    total++;
    String out4 = run(null, new String[]{"-5", "3", "4"});
    if (out4.trim().equals("0")) {
        IO.println("  PASS: first arg negative returns 0");
        passed++;
    } else {
        IO.println("  FAIL: expected '0', got '" + out4.trim() + "'");
    }

    // Test 5: zero args
    total++;
    String out5 = run(null, new String[]{});
    if (out5.trim().equals("0")) {
        IO.println("  PASS: zero args returns 0");
        passed++;
    } else {
        IO.println("  FAIL: expected '0', got '" + out5.trim() + "'");
    }

    // Test 6: zero in args is non-negative, should be summed
    total++;
    String out6 = run(null, new String[]{"0", "5", "3"});
    if (out6.trim().equals("8")) {
        IO.println("  PASS: zero in args sums to 8");
        passed++;
    } else {
        IO.println("  FAIL: expected '8', got '" + out6.trim() + "'");
    }

    IO.println("Exercise 11: " + passed + "/" + total + " passed");
}

String run(String input, String[] args) throws Exception {
    var cmd = new java.util.ArrayList<String>();
    cmd.add("java");
    cmd.add("Main.java");
    for (var a : args) cmd.add(a);
    var pb = new ProcessBuilder(cmd);
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
