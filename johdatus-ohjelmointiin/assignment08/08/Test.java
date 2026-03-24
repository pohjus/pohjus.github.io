import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    String output = run();

    // Test 1: low-salary programmer attempts
    total++;
    if (output.contains("Tapani - programmer attempts to reproduce")) {
        IO.println("  PASS: low salary uses attempt message");
        passed++;
    } else {
        IO.println("  FAIL: expected attempt message for Tapani");
    }

    // Test 2: high-salary programmer reproduces
    total++;
    if (output.contains("Tiina - programmer reproduces")) {
        IO.println("  PASS: high salary uses reproduce message");
        passed++;
    } else {
        IO.println("  FAIL: expected reproduce message for Tiina");
    }

    IO.println("Exercise 08: " + passed + "/" + total + " passed");
}

String run() throws Exception {
    var pb = new ProcessBuilder("java", "Main.java");
    pb.redirectErrorStream(true);
    var process = pb.start();
    process.getOutputStream().close();
    var output = new String(process.getInputStream().readAllBytes());
    process.waitFor(10, TimeUnit.SECONDS);
    return output;
}
