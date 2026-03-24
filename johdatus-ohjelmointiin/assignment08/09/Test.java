import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    String output = run();

    // Test 1: party message prints
    total++;
    if (output.contains("Jaska - programmer attends the cyber goth dance party!")) {
        IO.println("  PASS: party message prints");
        passed++;
    } else {
        IO.println("  FAIL: expected party message");
    }

    // Test 2: party also triggers reproduce
    total++;
    if (output.contains("Jaska - programmer reproduces")) {
        IO.println("  PASS: party triggers reproduce()");
        passed++;
    } else {
        IO.println("  FAIL: expected reproduce() after party");
    }

    IO.println("Exercise 09: " + passed + "/" + total + " passed");
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
