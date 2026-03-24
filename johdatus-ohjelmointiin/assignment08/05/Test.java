import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    // Test 1: valid salary is stored
    total++;
    String output = run();
    if (output.lines().anyMatch(line -> line.trim().equals("3000"))) {
        IO.println("  PASS: valid salary is stored");
        passed++;
    } else {
        IO.println("  FAIL: expected salary output 3000");
    }

    // Test 2: too small salary throws
    total++;
    String out2 = compileAndRun("""
        class TestTemp {
            public static void main(String[] args) {
                Programmer p = new Programmer("A");
                try {
                    p.setSalary(999);
                    System.out.println("NO_EXCEPTION");
                } catch (IllegalArgumentException e) {
                    System.out.println("CAUGHT");
                }
            }
        }
        """);
    if (out2.trim().equals("CAUGHT")) {
        IO.println("  PASS: salary below range throws");
        passed++;
    } else {
        IO.println("  FAIL: expected exception for salary 999");
    }

    // Test 3: too large salary throws
    total++;
    String out3 = compileAndRun("""
        class TestTemp {
            public static void main(String[] args) {
                Programmer p = new Programmer("A");
                try {
                    p.setSalary(10001);
                    System.out.println("NO_EXCEPTION");
                } catch (IllegalArgumentException e) {
                    System.out.println("CAUGHT");
                }
            }
        }
        """);
    if (out3.trim().equals("CAUGHT")) {
        IO.println("  PASS: salary above range throws");
        passed++;
    } else {
        IO.println("  FAIL: expected exception for salary 10001");
    }

    IO.println("Exercise 05: " + passed + "/" + total + " passed");
}

String run() throws Exception {
    var pb = new ProcessBuilder("java", "Main.java");
    pb.redirectErrorStream(true);
    var process = pb.start();
    process.getOutputStream().close();
    var output = new String(process.getInputStream().readAllBytes());
    process.waitFor(10, TimeUnit.SECONDS);
    return output;
}

String compileAndRun(String code) throws Exception {
    java.nio.file.Files.writeString(java.nio.file.Path.of("TestTemp.java"), code);
    var pb = new ProcessBuilder(
        "javac",
        "Human.java",
        "Programmer.java",
        "TestTemp.java"
    );
    pb.redirectErrorStream(true);
    var process = pb.start();
    process.waitFor(10, TimeUnit.SECONDS);
    if (process.exitValue() != 0) {
        return "COMPILE_ERROR";
    }
    var pb2 = new ProcessBuilder("java", "TestTemp");
    pb2.redirectErrorStream(true);
    var process2 = pb2.start();
    process2.getOutputStream().close();
    var output = new String(process2.getInputStream().readAllBytes());
    process2.waitFor(10, TimeUnit.SECONDS);
    java.nio.file.Files.deleteIfExists(java.nio.file.Path.of("TestTemp.java"));
    java.nio.file.Files.deleteIfExists(java.nio.file.Path.of("TestTemp.class"));
    return output;
}
