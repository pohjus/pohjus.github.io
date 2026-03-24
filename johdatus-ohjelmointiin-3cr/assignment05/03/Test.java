import java.util.concurrent.TimeUnit;
import java.nio.file.Files;
import java.nio.file.Path;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    String source = Files.readString(Path.of("Main.java"));

    // Test 1: source contains printGivenName method with String parameter
    total++;
    if (source.matches("(?s).*void\\s+printGivenName\\s*\\(\\s*String\\s+\\w+\\s*\\).*")) {
        IO.println("  PASS: source contains printGivenName(String) method");
        passed++;
    } else {
        IO.println("  FAIL: expected a 'void printGivenName(String)' method in Main.java");
    }

    // Test 2: output contains the input name "Jeppe"
    total++;
    String out1 = run("Jeppe\n");
    if (out1.contains("Jeppe")) {
        IO.println("  PASS: output contains input name Jeppe");
        passed++;
    } else {
        IO.println("  FAIL: expected output to contain 'Jeppe'");
    }

    // Test 3: output contains the input name "Anna"
    total++;
    String out2 = run("Anna\n");
    if (out2.contains("Anna")) {
        IO.println("  PASS: output contains input name Anna");
        passed++;
    } else {
        IO.println("  FAIL: expected output to contain 'Anna'");
    }

    // Test 4: output contains a prompt for the name
    total++;
    if (out1.toLowerCase().contains("name")) {
        IO.println("  PASS: output contains a prompt for name");
        passed++;
    } else {
        IO.println("  FAIL: expected a prompt containing 'name'");
    }

    // Test 5: different names produce different output
    total++;
    if (!out1.equals(out2)) {
        IO.println("  PASS: different input names produce different output");
        passed++;
    } else {
        IO.println("  FAIL: output is the same for different names (hardcoded?)");
    }

    IO.println("Exercise 03: " + passed + "/" + total + " passed");
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
