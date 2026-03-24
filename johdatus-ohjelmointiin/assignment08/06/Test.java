import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    // Test 1: Programmer(String, int) exists
    total++;
    String source = Files.readString(Path.of("Programmer.java"));
    if (source.contains("public Programmer(String n, int s)")) {
        IO.println("  PASS: Programmer has a name+salary constructor");
        passed++;
    } else {
        IO.println("  FAIL: expected Programmer(String n, int s)");
    }

    // Test 2: constructor stores name and salary
    total++;
    String output = run();
    if (output.contains("Tapani") && output.contains("3000")) {
        IO.println("  PASS: constructor stores name and salary");
        passed++;
    } else {
        IO.println("  FAIL: expected name and salary output");
    }

    IO.println("Exercise 06: " + passed + "/" + total + " passed");
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
