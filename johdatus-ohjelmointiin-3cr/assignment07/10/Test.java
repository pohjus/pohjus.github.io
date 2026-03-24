import java.util.concurrent.TimeUnit;
import java.nio.file.Files;
import java.nio.file.Path;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    // Test 1: source creates an array of 10 rectangles
    total++;
    String testSource = Files.readString(Path.of("Main.java"));
    if (testSource.contains("new Rectangle[10]")) {
        IO.println("  PASS: Main.java creates Rectangle[10]");
        passed++;
    } else {
        IO.println("  FAIL: expected Rectangle[10] in Main.java");
    }

    // Test 2: valid input produces correct total area
    total++;
    String input1 = """
        1
        1
        1
        1
        1
        1
        1
        1
        1
        1
        1
        1
        1
        1
        1
        1
        1
        1
        1
        1
        """;
    String out1 = run(input1);
    if (out1.contains("Total area: 10")) {
        IO.println("  PASS: valid input produces total area 10");
        passed++;
    } else {
        IO.println("  FAIL: expected 'Total area: 10', got: " + out1.trim());
    }

    // Test 3: invalid values cause repeated prompts
    total++;
    String input2 = """
        -1
        2
        0
        3
        1
        1
        1
        1
        1
        1
        1
        1
        1
        1
        1
        1
        1
        1
        1
        1
        1
        1
        """;
    String out2 = run(input2);
    int widthPromptCount = out2.split(
        "Rectangle 1 - Enter width:",
        -1
    ).length - 1;
    int heightPromptCount = out2.split(
        "Rectangle 1 - Enter height:",
        -1
    ).length - 1;
    if (widthPromptCount >= 2 && heightPromptCount >= 2) {
        IO.println("  PASS: invalid values cause the prompt to repeat");
        passed++;
    } else {
        IO.println("  FAIL: expected repeated prompts for rectangle 1");
    }

    // Test 4: invalid input still leads to correct total area
    total++;
    if (out2.contains("Total area: 15")) {
        IO.println("  PASS: corrected input produces total area 15");
        passed++;
    } else {
        IO.println("  FAIL: expected 'Total area: 15', got: " + out2.trim());
    }

    IO.println("Exercise 10: " + passed + "/" + total + " passed");
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
