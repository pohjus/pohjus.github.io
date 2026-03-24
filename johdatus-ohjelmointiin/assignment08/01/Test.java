import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    String output = run();

    // Test 1: sleep output exists
    total++;
    if (output.contains("Human sleeps")) {
        IO.println("  PASS: Human.sleep() prints correctly");
        passed++;
    } else {
        IO.println("  FAIL: expected 'Human sleeps'");
    }

    // Test 2: eat output exists
    total++;
    if (output.contains("Human eats")) {
        IO.println("  PASS: Human.eat() prints correctly");
        passed++;
    } else {
        IO.println("  FAIL: expected 'Human eats'");
    }

    // Test 3: drink and reproduce outputs exist
    total++;
    if (output.contains("Human drinks")
        && output.contains("Human reproduces")) {
        IO.println("  PASS: Human.drink() and reproduce() print");
        passed++;
    } else {
        IO.println("  FAIL: expected drink and reproduce output");
    }

    IO.println("Exercise 01: " + passed + "/" + total + " passed");
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
