import java.util.concurrent.TimeUnit;
import java.nio.file.Files;
import java.nio.file.Path;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    // Test 1: Rectangle.java contains printMe method
    total++;
    String rectSource = Files.readString(Path.of("Rectangle.java"));
    if (rectSource.matches("(?s).*void\\s+printMe\\s*\\(\\s*\\).*")) {
        IO.println("  PASS: Rectangle.java contains printMe() method");
        passed++;
    } else {
        IO.println("  FAIL: expected 'void printMe()' method in Rectangle.java");
    }

    // Test 2: output contains width: 10, height: 5
    total++;
    var output = run(null);
    if (output.contains("width: 10") && output.contains("height: 5")) {
        IO.println("  PASS: output contains 'width: 10, height: 5'");
        passed++;
    } else {
        IO.println("  FAIL: expected 'width: 10, height: 5', got: " + output.trim());
    }

    // Test 3: printMe works with different values
    total++;
    String testCode = """
        class TestTemp {
            public static void main(String[] args) {
                Rectangle r = new Rectangle();
                r.width = 3;
                r.height = 7;
                r.printMe();
            }
        }
        """;
    String tempOutput = compileAndRun(testCode);
    if (tempOutput.contains("width: 3") && tempOutput.contains("height: 7")) {
        IO.println("  PASS: printMe() works with width=3, height=7");
        passed++;
    } else {
        IO.println("  FAIL: expected 'width: 3, height: 7', got: " + tempOutput.trim());
    }

    IO.println("Exercise 03: " + passed + "/" + total + " passed");
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

String compileAndRun(String code) throws Exception {
    Files.writeString(Path.of("TestTemp.java"), code);
    var pb = new ProcessBuilder("javac", "Rectangle.java", "TestTemp.java");
    pb.redirectErrorStream(true);
    var process = pb.start();
    var output = new String(process.getInputStream().readAllBytes());
    process.waitFor(10, TimeUnit.SECONDS);
    if (process.exitValue() != 0) {
        return "COMPILE_ERROR: " + output;
    }
    var pb2 = new ProcessBuilder("java", "TestTemp");
    pb2.redirectErrorStream(true);
    var process2 = pb2.start();
    process2.getOutputStream().close();
    var result = new String(process2.getInputStream().readAllBytes());
    boolean exited = process2.waitFor(10, TimeUnit.SECONDS);
    if (!exited) {
        process2.destroyForcibly();
        return "";
    }
    Files.deleteIfExists(Path.of("TestTemp.java"));
    Files.deleteIfExists(Path.of("TestTemp.class"));
    return result;
}
