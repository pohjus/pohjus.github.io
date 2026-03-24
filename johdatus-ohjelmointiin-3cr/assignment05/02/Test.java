import java.util.concurrent.TimeUnit;
import java.nio.file.Files;
import java.nio.file.Path;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    String source = Files.readString(Path.of("Main.java"));

    // Test 1: source contains printGreeting method
    total++;
    if (source.matches("(?s).*void\\s+printGreeting\\s*\\(\\s*\\).*")) {
        IO.println("  PASS: source contains printGreeting() method");
        passed++;
    } else {
        IO.println("  FAIL: expected a 'void printGreeting()' method in Main.java");
    }

    // Test 2: source contains printName method
    total++;
    if (source.matches("(?s).*void\\s+printName\\s*\\(\\s*\\).*")) {
        IO.println("  PASS: source contains printName() method");
        passed++;
    } else {
        IO.println("  FAIL: expected a 'void printName()' method in Main.java");
    }

    String out1 = run(null);

    // Test 3: output contains "Hello"
    total++;
    if (out1.contains("Hello")) {
        IO.println("  PASS: output contains Hello");
        passed++;
    } else {
        IO.println("  FAIL: expected 'Hello' in output, got '" + out1.trim() + "'");
    }

    // Test 4: a line contains both "Hello" and a name
    total++;
    String[] lines = out1.split("\n");
    boolean found = false;
    for (var line : lines) {
        if (line.matches(".*Hello \\w+.*")) {
            found = true;
            break;
        }
    }
    if (found) {
        IO.println("  PASS: output contains Hello followed by a name");
        passed++;
    } else {
        IO.println("  FAIL: no line matches 'Hello <name>', got '" + out1.trim() + "'");
    }

    // Test 5: greeting and name appear on a single line
    total++;
    int helloLineCount = 0;
    for (var line : lines) {
        if (line.contains("Hello") && line.trim().length() > 5) {
            helloLineCount++;
        }
    }
    if (helloLineCount == 1) {
        IO.println("  PASS: greeting and name on a single line");
        passed++;
    } else {
        IO.println("  FAIL: expected greeting and name on one line");
    }

    IO.println("Exercise 02: " + passed + "/" + total + " passed");
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
