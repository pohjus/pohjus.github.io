import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    String output = run();

    // Test 1: EnergyDrink implements sell()
    total++;
    if (output.contains("energy drink sold")) {
        IO.println("  PASS: EnergyDrink.sell() works");
        passed++;
    } else {
        IO.println("  FAIL: expected energy drink sold");
    }

    // Test 2: Dog implements sell()
    total++;
    if (output.contains("dog sold")) {
        IO.println("  PASS: Dog.sell() works");
        passed++;
    } else {
        IO.println("  FAIL: expected dog sold");
    }

    IO.println("Exercise 15: " + passed + "/" + total + " passed");
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
