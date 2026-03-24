import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    String output = run();

    // Test 1: method accepts Dog and Human
    total++;
    if (output.lines().filter(line -> line.contains("gives birth")).count()
        == 2) {
        IO.println("  PASS: method accepts Dog and Human as Mammal");
        passed++;
    } else {
        IO.println("  FAIL: expected giveBirth() twice");
    }

    // Test 2: Mammal reference can use Mammal methods
    total++;
    if (output.contains("Dog barks") && output.contains("Human says hello")) {
        IO.println("  PASS: Mammal reference can call Mammal methods");
        passed++;
    } else {
        IO.println("  FAIL: expected makeSound() output");
    }

    IO.println("Exercise 14: " + passed + "/" + total + " passed");
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
