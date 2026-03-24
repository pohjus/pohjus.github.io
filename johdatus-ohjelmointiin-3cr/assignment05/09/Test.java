import java.util.concurrent.TimeUnit;
import java.nio.file.Files;
import java.nio.file.Path;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    String source = Files.readString(Path.of("Main.java"));

    // Test 1: source contains isEven method
    total++;
    if (source.matches("(?s).*boolean\\s+isEven\\s*\\(\\s*int\\s+\\w+\\s*\\).*")) {
        IO.println("  PASS: source contains isEven(int) method");
        passed++;
    } else {
        IO.println("  FAIL: expected a 'boolean isEven(int)' method in Main.java");
    }

    // Test 2: input 4 outputs "even"
    total++;
    var out1 = run("4\n");
    if (out1.toLowerCase().contains("even") && !out1.toLowerCase().contains("odd")) {
        IO.println("  PASS: input 4 outputs 'even'");
        passed++;
    } else {
        IO.println("  FAIL: expected 'even' for input 4, got: " + out1.trim());
    }

    // Test 3: input 7 outputs "odd"
    total++;
    var out2 = run("7\n");
    if (out2.toLowerCase().contains("odd")) {
        IO.println("  PASS: input 7 outputs 'odd'");
        passed++;
    } else {
        IO.println("  FAIL: expected 'odd' for input 7, got: " + out2.trim());
    }

    IO.println("Exercise 09: " + passed + "/" + total + " passed");
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
