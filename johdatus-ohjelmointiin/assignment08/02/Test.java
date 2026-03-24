import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    String output = run();

    // Test 1: Programmer can use inherited methods
    total++;
    if (output.contains("Human sleeps")
        && output.contains("Human eats")
        && output.contains("Human drinks")) {
        IO.println("  PASS: Programmer uses inherited Human methods");
        passed++;
    } else {
        IO.println("  FAIL: expected inherited Human method output");
    }

    // Test 2: code() output exists
    total++;
    if (output.contains("Programmer codes")) {
        IO.println("  PASS: Programmer.code() prints correctly");
        passed++;
    } else {
        IO.println("  FAIL: expected 'Programmer codes'");
    }

    // Test 3: attendCyberGothDanceParty() output exists
    total++;
    if (output.contains("Programmer attends the cyber goth dance party")) {
        IO.println("  PASS: party method prints correctly");
        passed++;
    } else {
        IO.println("  FAIL: expected party output");
    }

    IO.println("Exercise 02: " + passed + "/" + total + " passed");
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
