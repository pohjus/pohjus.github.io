import java.util.concurrent.TimeUnit;
import java.nio.file.Files;
import java.nio.file.Path;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    // Test 1: Rectangle.java contains constructor
    total++;
    String rectSource = Files.readString(Path.of("Rectangle.java"));
    if (rectSource.matches(
        "(?s).*Rectangle\\s*\\(\\s*int\\s+width\\s*,\\s*int\\s+height\\s*\\).*"
    )) {
        IO.println("  PASS: Rectangle.java contains Rectangle(int, int)");
        passed++;
    } else {
        IO.println("  FAIL: expected constructor Rectangle(int, int)");
    }

    // Test 2: constructor stores valid values
    total++;
    String testCode2 = """
        class TestTemp {
            public static void main(String[] args) {
                Rectangle r = new Rectangle(7, 9);
                System.out.println(r.getWidth());
                System.out.println(r.getHeight());
            }
        }
        """;
    String out2 = compileAndRun(testCode2);
    if (out2.trim().equals("7\n9")) {
        IO.println("  PASS: constructor stores width and height");
        passed++;
    } else {
        IO.println("  FAIL: expected '7' and '9', got: " + out2.trim());
    }

    // Test 3: invalid width throws IllegalArgumentException
    total++;
    String testCode3 = """
        class TestTemp {
            public static void main(String[] args) {
                try {
                    new Rectangle(-1, 5);
                    System.out.println("NO_EXCEPTION");
                } catch (IllegalArgumentException e) {
                    System.out.println("CAUGHT");
                }
            }
        }
        """;
    String out3 = compileAndRun(testCode3);
    if (out3.trim().equals("CAUGHT")) {
        IO.println("  PASS: invalid width throws IllegalArgumentException");
        passed++;
    } else {
        IO.println("  FAIL: expected exception for invalid width");
    }

    // Test 4: invalid height throws IllegalArgumentException
    total++;
    String testCode4 = """
        class TestTemp {
            public static void main(String[] args) {
                try {
                    new Rectangle(5, 0);
                    System.out.println("NO_EXCEPTION");
                } catch (IllegalArgumentException e) {
                    System.out.println("CAUGHT");
                }
            }
        }
        """;
    String out4 = compileAndRun(testCode4);
    if (out4.trim().equals("CAUGHT")) {
        IO.println("  PASS: invalid height throws IllegalArgumentException");
        passed++;
    } else {
        IO.println("  FAIL: expected exception for invalid height");
    }

    IO.println("Exercise 07: " + passed + "/" + total + " passed");
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
