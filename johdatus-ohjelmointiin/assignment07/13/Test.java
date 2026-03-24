import java.util.concurrent.TimeUnit;
import java.nio.file.Files;
import java.nio.file.Path;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    // Test 1: Rectangle.java contains countDiagonal()
    total++;
    String rectSource = Files.readString(Path.of("Rectangle.java"));
    if (rectSource.contains("countDiagonal()")
        && rectSource.contains("Math.sqrt")) {
        IO.println("  PASS: Rectangle.java contains countDiagonal()");
        passed++;
    } else {
        IO.println("  FAIL: expected countDiagonal() using Math.sqrt");
    }

    // Test 2: 3x4 diagonal is 5.0
    total++;
    String output = run(null).trim();
    if (output.equals("5.0")) {
        IO.println("  PASS: 3x4 diagonal is 5.0");
        passed++;
    } else {
        IO.println("  FAIL: expected '5.0', got: " + output);
    }

    // Test 3: 5x12 diagonal is 13.0
    total++;
    String testCode3 = """
        class TestTemp {
            public static void main(String[] args) {
                Rectangle r = new Rectangle(5, 12);
                System.out.println(r.countDiagonal());
            }
        }
        """;
    String out3 = compileAndRun(testCode3);
    if (out3.trim().equals("13.0")) {
        IO.println("  PASS: 5x12 diagonal is 13.0");
        passed++;
    } else {
        IO.println("  FAIL: expected '13.0', got: " + out3.trim());
    }

    IO.println("Exercise 13: " + passed + "/" + total + " passed");
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
