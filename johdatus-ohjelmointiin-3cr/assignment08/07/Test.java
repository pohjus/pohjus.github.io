import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    String output = run();

    // Test 1: Human printInfo prints the name
    total++;
    if (output.contains("Tiina")) {
        IO.println("  PASS: Human.printInfo() prints the name");
        passed++;
    } else {
        IO.println("  FAIL: expected Tiina in output");
    }

    // Test 2: Programmer printInfo includes the salary
    total++;
    if (output.contains("Hanna") && output.contains("salary: 3000")) {
        IO.println("  PASS: Programmer.printInfo() prints name and salary");
        passed++;
    } else {
        IO.println("  FAIL: expected programmer name and salary");
    }

    IO.println("Exercise 07: " + passed + "/" + total + " passed");
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
