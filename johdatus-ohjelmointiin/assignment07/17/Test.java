import java.util.concurrent.TimeUnit;
import java.nio.file.Files;
import java.nio.file.Path;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    // Test 1: collection uses an array, not ArrayList
    total++;
    String collectionSource = Files.readString(
        Path.of("RectangleCollection.java")
    );
    if (collectionSource.contains("Rectangle[]")
        && !collectionSource.contains("ArrayList")) {
        IO.println("  PASS: RectangleCollection uses Rectangle[]");
        passed++;
    } else {
        IO.println("  FAIL: expected Rectangle[] and no ArrayList");
    }

    // Test 2: total surface area is computed correctly
    total++;
    String testCode2 = """
        class TestTemp {
            public static void main(String[] args) {
                RectangleCollection collection = new RectangleCollection(3);
                collection.addRectangle(new Rectangle(10, 5));
                collection.addRectangle(new Rectangle(3, 4));
                collection.addRectangle(new Rectangle(7, 8));
                System.out.println(collection.countTotalSurfaceArea());
            }
        }
        """;
    String out2 = compileAndRun(testCode2);
    if (out2.trim().equals("118")) {
        IO.println("  PASS: total surface area is 118");
        passed++;
    } else {
        IO.println("  FAIL: expected '118', got: " + out2.trim());
    }

    // Test 3: largest rectangle is found correctly
    total++;
    String testCode3 = """
        class TestTemp {
            public static void main(String[] args) {
                RectangleCollection collection = new RectangleCollection(3);
                collection.addRectangle(new Rectangle(10, 5));
                collection.addRectangle(new Rectangle(3, 4));
                collection.addRectangle(new Rectangle(7, 8));
                System.out.println(collection.findLargestRectangle());
            }
        }
        """;
    String out3 = compileAndRun(testCode3);
    if (out3.trim().equals("width = 7, height = 8")) {
        IO.println("  PASS: largest rectangle is width 7, height 8");
        passed++;
    } else {
        IO.println("  FAIL: expected largest rectangle output, got: " + out3);
    }

    // Test 4: adding past capacity throws IllegalStateException
    total++;
    String testCode4 = """
        class TestTemp {
            public static void main(String[] args) {
                try {
                    RectangleCollection collection = new RectangleCollection(1);
                    collection.addRectangle(new Rectangle(1, 1));
                    collection.addRectangle(new Rectangle(2, 2));
                    System.out.println("NO_EXCEPTION");
                } catch (IllegalStateException e) {
                    System.out.println("CAUGHT");
                }
            }
        }
        """;
    String out4 = compileAndRun(testCode4);
    if (out4.trim().equals("CAUGHT")) {
        IO.println("  PASS: adding past capacity throws exception");
        passed++;
    } else {
        IO.println("  FAIL: expected IllegalStateException, got: " + out4);
    }

    // Test 5: Main prints readable demo output
    total++;
    String output = run(null);
    if (output.contains("Total surface area: 118")
        && output.contains("Largest rectangle: width = 7, height = 8")
        && output.contains("Rectangles:")) {
        IO.println("  PASS: Main prints demo output");
        passed++;
    } else {
        IO.println("  FAIL: expected readable demo output, got: " + output);
    }

    IO.println("Exercise 17: " + passed + "/" + total + " passed");
}

String compile() throws Exception {
    var pb = new ProcessBuilder(
        "javac",
        "Rectangle.java",
        "RectangleCollection.java",
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
    var pb = new ProcessBuilder(
        "javac",
        "Rectangle.java",
        "RectangleCollection.java",
        "TestTemp.java"
    );
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
