import java.util.concurrent.TimeUnit;
import java.nio.file.Files;
import java.nio.file.Path;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    String source = Files.readString(Path.of("Main.java"));

    // Test 1: inputs 3 and 7 produce min: 3
    total++;
    var out1 = run("3\n7\n");
    if (out1.contains("min: 3")) {
        IO.println("  PASS: inputs 3, 7 produce 'min: 3'");
        passed++;
    } else {
        IO.println("  FAIL: expected 'min: 3' for inputs 3 and 7, got: " + out1.trim());
    }

    // Test 2: inputs 3 and 7 produce max: 7
    total++;
    if (out1.contains("max: 7")) {
        IO.println("  PASS: inputs 3, 7 produce 'max: 7'");
        passed++;
    } else {
        IO.println("  FAIL: expected 'max: 7' for inputs 3 and 7, got: " + out1.trim());
    }

    // Test 3: inputs 3 and 7 produce range: 4
    total++;
    if (out1.contains("range: 4")) {
        IO.println("  PASS: inputs 3, 7 produce 'range: 4'");
        passed++;
    } else {
        IO.println("  FAIL: expected 'range: 4' for inputs 3 and 7, got: " + out1.trim());
    }

    // Test 4: inputs 10 and 2 produce correct values
    total++;
    var out2 = run("10\n2\n");
    if (out2.contains("min: 2") && out2.contains("max: 10") && out2.contains("range: 8")) {
        IO.println("  PASS: inputs 10, 2 produce min: 2, max: 10, range: 8");
        passed++;
    } else {
        IO.println("  FAIL: expected min: 2, max: 10, range: 8 for inputs 10 and 2, got: " + out2.trim());
    }

    IO.println("Exercise 10: " + passed + "/" + total + " passed");
}

String run(String input) throws Exception {
    var pb = new ProcessBuilder("java", "Main.java");
    pb.redirectErrorStream(true);
    var process = pb.start();
    if (input != null) {
        process.getOutputStream().write(input.getBytes());
    }
    process.getOutputStream().close();
    var output = new String(process.getInputStream().readAllBytes());
    boolean exited = process.waitFor(10, TimeUnit.SECONDS);
    if (!exited) {
        process.destroyForcibly();
        return "";
    }
    return output;
}
