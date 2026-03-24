import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    String output = run();

    // Test 1: getName() works for Human and Programmer
    total++;
    if (output.contains("Tiina") && output.contains("Hanna")) {
        IO.println("  PASS: setName/getName work");
        passed++;
    } else {
        IO.println("  FAIL: expected both names in output");
    }

    // Test 2: Human methods print the name
    total++;
    if (output.contains("Tiina drinks")) {
        IO.println("  PASS: Human methods print the person's name");
        passed++;
    } else {
        IO.println("  FAIL: expected 'Tiina drinks'");
    }

    // Test 3: Programmer inherits and uses the name
    total++;
    if (output.contains("Hanna codes")) {
        IO.println("  PASS: Programmer methods use getName()");
        passed++;
    } else {
        IO.println("  FAIL: expected 'Hanna codes'");
    }

    IO.println("Exercise 03: " + passed + "/" + total + " passed");
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
