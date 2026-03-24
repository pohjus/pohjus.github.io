import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    String output = run();

    // Test 1: Human can create art
    total++;
    if (output.contains("creates art")) {
        IO.println("  PASS: Human.createArt() works");
        passed++;
    } else {
        IO.println("  FAIL: expected createArt() output");
    }

    // Test 2: Dog can sniffButt
    total++;
    if (output.contains("sniffs another dog's butt")) {
        IO.println("  PASS: Dog.sniffButt() works");
        passed++;
    } else {
        IO.println("  FAIL: expected sniffButt() output");
    }

    IO.println("Exercise 11: " + passed + "/" + total + " passed");
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
