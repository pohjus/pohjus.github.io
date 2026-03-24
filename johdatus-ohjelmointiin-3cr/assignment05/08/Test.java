import java.util.concurrent.TimeUnit;
import java.nio.file.Files;
import java.nio.file.Path;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    String source = Files.readString(Path.of("Main.java"));
    String out = run(null);

    // Test 1: output contains "Hello!" on its own line
    total++;
    boolean hasHello = false;
    for (var line : out.split("\n")) {
        if (line.trim().equals("Hello!")) {
            hasHello = true;
            break;
        }
    }
    if (hasHello) {
        IO.println("  PASS: output contains 'Hello!' on its own line");
        passed++;
    } else {
        IO.println("  FAIL: expected 'Hello!' on its own line");
    }

    // Test 2: output contains "Hello, Matti!"
    total++;
    if (out.contains("Hello, Matti!")) {
        IO.println("  PASS: output contains 'Hello, Matti!'");
        passed++;
    } else {
        IO.println("  FAIL: expected 'Hello, Matti!' in output");
    }

    // Test 3: "Hello, Anna!" appears at least 3 times
    total++;
    int count = 0;
    for (var line : out.split("\n")) {
        if (line.trim().equals("Hello, Anna!")) {
            count++;
        }
    }
    if (count >= 3) {
        IO.println("  PASS: 'Hello, Anna!' appears at least 3 times");
        passed++;
    } else {
        IO.println("  FAIL: expected 'Hello, Anna!' at least 3 times, found " + count);
    }

    IO.println("Exercise 08: " + passed + "/" + total + " passed");
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
