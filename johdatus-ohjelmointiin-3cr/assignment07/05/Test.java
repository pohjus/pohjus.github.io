import java.util.concurrent.TimeUnit;
import java.nio.file.Files;
import java.nio.file.Path;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    // Test 1: width and height are private
    total++;
    String rectSource = Files.readString(Path.of("Rectangle.java"));
    if (rectSource.contains("private int width") && rectSource.contains("private int height")) {
        IO.println("  PASS: width and height are private");
        passed++;
    } else {
        IO.println("  FAIL: expected 'private int width' and 'private int height'");
    }

    // Test 2: setWidth(30) then getWidth() returns 30
    total++;
    String testCode1 = """
        class TestTemp {
            public static void main(String[] args) {
                Rectangle r = new Rectangle();
                r.setWidth(30);
                System.out.println(r.getWidth());
            }
        }
        """;
    String out1 = compileAndRun(testCode1);
    if (out1.trim().equals("30")) {
        IO.println("  PASS: setWidth(30) then getWidth() returns 30");
        passed++;
    } else {
        IO.println("  FAIL: expected '30', got: " + out1.trim());
    }

    // Test 3: setWidth(-30) is ignored
    total++;
    String testCode2 = """
        class TestTemp {
            public static void main(String[] args) {
                Rectangle r = new Rectangle();
                r.setWidth(30);
                r.setWidth(-30);
                System.out.println(r.getWidth());
            }
        }
        """;
    String out2 = compileAndRun(testCode2);
    if (out2.trim().equals("30")) {
        IO.println("  PASS: setWidth(-30) is ignored, value stays 30");
        passed++;
    } else {
        IO.println("  FAIL: expected '30' after setWidth(-30), got: " + out2.trim());
    }

    // Test 4: setHeight(20) then getHeight() returns 20
    total++;
    String testCode3 = """
        class TestTemp {
            public static void main(String[] args) {
                Rectangle r = new Rectangle();
                r.setHeight(20);
                System.out.println(r.getHeight());
            }
        }
        """;
    String out3 = compileAndRun(testCode3);
    if (out3.trim().equals("20")) {
        IO.println("  PASS: setHeight(20) then getHeight() returns 20");
        passed++;
    } else {
        IO.println("  FAIL: expected '20', got: " + out3.trim());
    }

    // Test 5: setHeight(-5) is ignored
    total++;
    String testCode4 = """
        class TestTemp {
            public static void main(String[] args) {
                Rectangle r = new Rectangle();
                r.setHeight(20);
                r.setHeight(-5);
                System.out.println(r.getHeight());
            }
        }
        """;
    String out4 = compileAndRun(testCode4);
    if (out4.trim().equals("20")) {
        IO.println("  PASS: setHeight(-5) is ignored, value stays 20");
        passed++;
    } else {
        IO.println("  FAIL: expected '20' after setHeight(-5), got: " + out4.trim());
    }

    // Test 6: countSurfaceArea works with getters/setters
    total++;
    String testCode5 = """
        class TestTemp {
            public static void main(String[] args) {
                Rectangle r = new Rectangle();
                r.setWidth(10);
                r.setHeight(5);
                System.out.println(r.countSurfaceArea());
            }
        }
        """;
    String out5 = compileAndRun(testCode5);
    if (out5.trim().equals("50")) {
        IO.println("  PASS: countSurfaceArea() returns 50 for 10x5");
        passed++;
    } else {
        IO.println("  FAIL: expected '50', got: " + out5.trim());
    }

    IO.println("Exercise 05: " + passed + "/" + total + " passed");
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
