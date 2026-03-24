import java.util.concurrent.TimeUnit;
import java.nio.file.Files;
import java.nio.file.Path;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    // Test 1: Rectangle.java contains equals(Rectangle)
    total++;
    String rectSource = Files.readString(Path.of("Rectangle.java"));
    if (rectSource.matches(
        "(?s).*boolean\\s+equals\\s*\\(\\s*Rectangle\\s+\\w+\\s*\\).*"
    )) {
        IO.println("  PASS: Rectangle.java contains equals(Rectangle)");
        passed++;
    } else {
        IO.println("  FAIL: expected equals(Rectangle) in Rectangle.java");
    }

    // Test 2: equal rectangles return true
    total++;
    String testCode2 = """
        class TestTemp {
            public static void main(String[] args) {
                Rectangle r1 = new Rectangle(50, 50);
                Rectangle r2 = new Rectangle(50, 50);
                System.out.println(r1.equals(r2));
            }
        }
        """;
    String out2 = compileAndRun(testCode2);
    if (out2.trim().equals("true")) {
        IO.println("  PASS: equal rectangles return true");
        passed++;
    } else {
        IO.println("  FAIL: expected 'true', got: " + out2.trim());
    }

    // Test 3: different rectangles return false
    total++;
    String testCode3 = """
        class TestTemp {
            public static void main(String[] args) {
                Rectangle r1 = new Rectangle(50, 50);
                Rectangle r2 = new Rectangle(50, 20);
                System.out.println(r1.equals(r2));
            }
        }
        """;
    String out3 = compileAndRun(testCode3);
    if (out3.trim().equals("false")) {
        IO.println("  PASS: different rectangles return false");
        passed++;
    } else {
        IO.println("  FAIL: expected 'false', got: " + out3.trim());
    }

    IO.println("Exercise 11: " + passed + "/" + total + " passed");
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
