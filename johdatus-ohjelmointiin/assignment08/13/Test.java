import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    String output = run();

    // Test 1: method1 accepts Dog
    total++;
    if (output.contains("method1 dog")) {
        IO.println("  PASS: method1 accepts Dog");
        passed++;
    } else {
        IO.println("  FAIL: expected method1 dog output");
    }

    // Test 2: method2 and method3 accept Human/Dog as expected
    total++;
    if (output.contains("method2 human")
        && output.lines().filter(line -> line.contains("method3 mammal"))
            .count() == 2) {
        IO.println("  PASS: method2 and method3 accept valid objects");
        passed++;
    } else {
        IO.println("  FAIL: expected method2 and method3 output");
    }

    // Test 3: method4 accepts extra Object types
    total++;
    if (output.lines().filter(line -> line.contains("method4 object"))
        .count() == 3) {
        IO.println("  PASS: method4 accepts multiple Object types");
        passed++;
    } else {
        IO.println("  FAIL: expected three method4 calls");
    }

    IO.println("Exercise 13: " + passed + "/" + total + " passed");
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
