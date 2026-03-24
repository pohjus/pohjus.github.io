import java.util.concurrent.TimeUnit;
import java.nio.file.Files;
import java.nio.file.Path;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    // Test 1: Rectangle.java contains whoAmI method
    total++;
    String rectSource = Files.readString(Path.of("Rectangle.java"));
    if (rectSource.matches("(?s).*void\\s+whoAmI\\s*\\(\\s*\\).*")) {
        IO.println("  PASS: Rectangle.java contains whoAmI() method");
        passed++;
    } else {
        IO.println("  FAIL: expected 'void whoAmI()' method in Rectangle.java");
    }

    // Test 2: whoAmI prints Rectangle@ (the this reference)
    total++;
    var output = run(null);
    if (output.contains("Rectangle@")) {
        IO.println("  PASS: whoAmI() prints 'Rectangle@' (this reference)");
        passed++;
    } else {
        IO.println("  FAIL: expected 'Rectangle@' in output, got: " + output.trim());
    }

    // Test 3: source contains a comment about this
    total++;
    String testSource = Files.readString(Path.of("Main.java"));
    if (testSource.contains("//") || testSource.contains("/*")) {
        IO.println("  PASS: Main.java contains a comment");
        passed++;
    } else {
        IO.println("  FAIL: expected a comment explaining what 'this' refers to");
    }

    IO.println("Exercise 04: " + passed + "/" + total + " passed");
}

String compile() throws Exception {
    var pb = new ProcessBuilder("javac", "Rectangle.java", "Main.java");
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
