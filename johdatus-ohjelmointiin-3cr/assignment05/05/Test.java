import java.util.concurrent.TimeUnit;
import java.nio.file.Files;
import java.nio.file.Path;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    String source = Files.readString(Path.of("Main.java"));

    // Test 1: source contains calculate method with two int parameters
    total++;
    if (source.matches("(?s).*int\\s+calculate\\s*\\(\\s*int\\s+\\w+\\s*,\\s*int\\s+\\w+\\s*\\).*")) {
        IO.println("  PASS: source contains calculate(int, int) method");
        passed++;
    } else {
        IO.println("  FAIL: expected an 'int calculate(int, int)' method in Main.java");
    }

    // Test 2: output contains prompt for first number
    total++;
    String out1 = run("4\n6\n");
    if (out1.toLowerCase().contains("first")) {
        IO.println("  PASS: output contains prompt for first number");
        passed++;
    } else {
        IO.println("  FAIL: expected a prompt containing 'first'");
    }

    // Test 3: output contains prompt for second number
    total++;
    if (out1.toLowerCase().contains("second")) {
        IO.println("  PASS: output contains prompt for second number");
        passed++;
    } else {
        IO.println("  FAIL: expected a prompt containing 'second'");
    }

    // Test 4: 4 + 6 = 10
    total++;
    if (out1.contains("10")) {
        IO.println("  PASS: 4 + 6 = 10");
        passed++;
    } else {
        IO.println("  FAIL: expected output to contain '10' for input 4 and 6");
    }

    // Test 5: 100 + 200 = 300
    total++;
    if (run("100\n200\n").contains("300")) {
        IO.println("  PASS: 100 + 200 = 300");
        passed++;
    } else {
        IO.println("  FAIL: expected output to contain '300' for input 100 and 200");
    }

    // Test 6: -5 + 3 = -2
    total++;
    if (run("-5\n3\n").contains("-2")) {
        IO.println("  PASS: -5 + 3 = -2");
        passed++;
    } else {
        IO.println("  FAIL: expected output to contain '-2' for input -5 and 3");
    }

    // Test 7: 7 + 7 = 14
    total++;
    if (run("7\n7\n").contains("14")) {
        IO.println("  PASS: 7 + 7 = 14");
        passed++;
    } else {
        IO.println("  FAIL: expected output to contain '14' for input 7 and 7");
    }

    IO.println("Exercise 05: " + passed + "/" + total + " passed");
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
