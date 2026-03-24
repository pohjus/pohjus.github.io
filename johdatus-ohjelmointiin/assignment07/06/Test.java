import java.util.concurrent.TimeUnit;
import java.nio.file.Files;
import java.nio.file.Path;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    // Test 1: Rectangle.java contains countSurfaceArea method
    total++;
    String rectSource = Files.readString(Path.of("Rectangle.java"));
    if (rectSource.matches("(?s).*int\\s+countSurfaceArea\\s*\\(\\s*\\).*")) {
        IO.println("  PASS: Rectangle.java contains countSurfaceArea() method");
        passed++;
    } else {
        IO.println("  FAIL: expected 'int countSurfaceArea()' in Rectangle.java");
    }

    // Test 2: output contains 50 (10 * 5)
    total++;
    var output = run(null);
    if (output.trim().contains("50")) {
        IO.println("  PASS: output contains '50' (10 * 5)");
        passed++;
    } else {
        IO.println("  FAIL: expected '50', got: " + output.trim());
    }

    // Test 3: countSurfaceArea works with 3 * 4 = 12
    total++;
    String testCode = """
        class TestTemp {
            public static void main(String[] args) {
                Rectangle r = new Rectangle();
                r.width = 3;
                r.height = 4;
                System.out.println(r.countSurfaceArea());
            }
        }
        """;
    String tempOutput = compileAndRun(testCode);
    if (tempOutput.trim().contains("12")) {
        IO.println("  PASS: countSurfaceArea() returns 12 for 3x4");
        passed++;
    } else {
        IO.println("  FAIL: expected '12' for 3x4, got: " + tempOutput.trim());
    }

    // Test 4: countSurfaceArea works with 7 * 8 = 56
    total++;
    String testCode2 = """
        class TestTemp {
            public static void main(String[] args) {
                Rectangle r = new Rectangle();
                r.width = 7;
                r.height = 8;
                System.out.println(r.countSurfaceArea());
            }
        }
        """;
    String tempOutput2 = compileAndRun(testCode2);
    if (tempOutput2.trim().contains("56")) {
        IO.println("  PASS: countSurfaceArea() returns 56 for 7x8");
        passed++;
    } else {
        IO.println("  FAIL: expected '56' for 7x8, got: " + tempOutput2.trim());
    }

    IO.println("Exercise 06: " + passed + "/" + total + " passed");
}

String compile() throws Exception {
    var pb = new ProcessBuilder("javac", "-Xlint:-deprecation", "Rectangle.java", "Main.java");
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
    var pb = new ProcessBuilder("javac", "-Xlint:-deprecation", "Rectangle.java", "TestTemp.java");
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
