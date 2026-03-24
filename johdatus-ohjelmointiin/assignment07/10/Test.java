import java.util.concurrent.TimeUnit;
import java.nio.file.Files;
import java.nio.file.Path;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    // Test 1: output shows rectangles are different objects
    total++;
    String output = run(null).trim();
    if (output.equals("different")) {
        IO.println("  PASS: Main shows r1 and r2 are different");
        passed++;
    } else {
        IO.println("  FAIL: expected 'different', got: " + output);
    }

    // Test 2: source uses ==
    total++;
    String testSource = Files.readString(Path.of("Main.java"));
    if (testSource.contains("==")) {
        IO.println("  PASS: Main.java uses ==");
        passed++;
    } else {
        IO.println("  FAIL: expected '==' in Main.java");
    }

    // Test 3: source contains an explanatory comment
    total++;
    if (testSource.contains("//") || testSource.contains("/*")) {
        IO.println("  PASS: Main.java contains a comment");
        passed++;
    } else {
        IO.println("  FAIL: expected a comment explaining ==");
    }

    IO.println("Exercise 10: " + passed + "/" + total + " passed");
}

String compile() throws Exception {
    var pb = new ProcessBuilder(
        "javac",
        "Rectangle.java",
        "Main.java"
    );
    pb.redirectErrorStream(true);
    var process = pb.start();
    var output = new String(process.getInputStream().readAllBytes());
    process.waitFor(10, TimeUnit.SECONDS);
    if (process.exitValue() != 0) {
        return output;
    }
    return null;
}

String run(String input) throws Exception {
    compile();
    var pb = new ProcessBuilder("java", "Main");
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
