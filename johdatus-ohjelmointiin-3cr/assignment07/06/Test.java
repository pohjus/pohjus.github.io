import java.util.concurrent.TimeUnit;
import java.nio.file.Files;
import java.nio.file.Path;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    // Test 1: setWidth(10) works
    total++;
    String testCode1 = """
        class TestTemp {
            public static void main(String[] args) {
                Rectangle r = new Rectangle();
                r.setWidth(10);
                System.out.println(r.getWidth());
            }
        }
        """;
    String out1 = compileAndRun(testCode1);
    if (out1.trim().equals("10")) {
        IO.println("  PASS: setWidth(10) works, getWidth() returns 10");
        passed++;
    } else {
        IO.println("  FAIL: expected '10', got: " + out1.trim());
    }

    // Test 2: setWidth(-5) throws IllegalArgumentException
    total++;
    String testCode2 = """
        class TestTemp {
            public static void main(String[] args) {
                Rectangle r = new Rectangle();
                try {
                    r.setWidth(-5);
                    System.out.println("NO_EXCEPTION");
                } catch (IllegalArgumentException e) {
                    System.out.println("CAUGHT");
                }
            }
        }
        """;
    String out2 = compileAndRun(testCode2);
    if (out2.trim().equals("CAUGHT")) {
        IO.println("  PASS: setWidth(-5) throws IllegalArgumentException");
        passed++;
    } else {
        IO.println("  FAIL: expected IllegalArgumentException for setWidth(-5), got: " + out2.trim());
    }

    // Test 3: setHeight(-1) throws IllegalArgumentException
    total++;
    String testCode3 = """
        class TestTemp {
            public static void main(String[] args) {
                Rectangle r = new Rectangle();
                try {
                    r.setHeight(-1);
                    System.out.println("NO_EXCEPTION");
                } catch (IllegalArgumentException e) {
                    System.out.println("CAUGHT");
                }
            }
        }
        """;
    String out3 = compileAndRun(testCode3);
    if (out3.trim().equals("CAUGHT")) {
        IO.println("  PASS: setHeight(-1) throws IllegalArgumentException");
        passed++;
    } else {
        IO.println("  FAIL: expected IllegalArgumentException for setHeight(-1), got: " + out3.trim());
    }

    // Test 4: setWidth(0) throws IllegalArgumentException
    total++;
    String testCode4 = """
        class TestTemp {
            public static void main(String[] args) {
                Rectangle r = new Rectangle();
                try {
                    r.setWidth(0);
                    System.out.println("NO_EXCEPTION");
                } catch (IllegalArgumentException e) {
                    System.out.println("CAUGHT");
                }
            }
        }
        """;
    String out4 = compileAndRun(testCode4);
    if (out4.trim().equals("CAUGHT")) {
        IO.println("  PASS: setWidth(0) throws IllegalArgumentException");
        passed++;
    } else {
        IO.println("  FAIL: expected IllegalArgumentException for setWidth(0), got: " + out4.trim());
    }

    // Test 5: Main.java uses try-catch
    total++;
    String testSource = Files.readString(Path.of("Main.java"));
    if (testSource.contains("try") && testSource.contains("catch")) {
        IO.println("  PASS: Main.java uses try-catch");
        passed++;
    } else {
        IO.println("  FAIL: expected try-catch in Main.java");
    }

    IO.println("Exercise 06: " + passed + "/" + total + " passed");
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
