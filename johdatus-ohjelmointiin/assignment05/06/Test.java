import java.util.concurrent.TimeUnit;
import java.nio.file.Files;
import java.nio.file.Path;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    String source = Files.readString(Path.of("Main.java"));

    // Test 1: source contains printManyTimes method with char and int parameters
    total++;
    if (source.matches("(?s).*void\\s+printManyTimes\\s*\\(\\s*char\\s+\\w+\\s*,\\s*int\\s+\\w+\\s*\\).*")) {
        IO.println("  PASS: source contains printManyTimes(char, int) method");
        passed++;
    } else {
        IO.println("  FAIL: expected a 'void printManyTimes(char, int)' method in Main.java");
    }

    // Test 2: source contains a for loop
    total++;
    if (source.matches("(?s).*for\\s*\\(.*")) {
        IO.println("  PASS: source contains a for loop");
        passed++;
    } else {
        IO.println("  FAIL: expected a for loop in Main.java");
    }

    String out1 = run(null);

    // Test 3: output contains "XXX"
    total++;
    if (out1.contains("XXX")) {
        IO.println("  PASS: output contains XXX");
        passed++;
    } else {
        IO.println("  FAIL: expected output to contain 'XXX'");
    }

    // Test 4: output contains "OOOOO"
    total++;
    if (out1.contains("OOOOO")) {
        IO.println("  PASS: output contains OOOOO");
        passed++;
    } else {
        IO.println("  FAIL: expected output to contain 'OOOOO'");
    }

    // Test 5: "XXX" appears on its own line
    total++;
    boolean xxxOnOwnLine = false;
    for (var line : out1.split("\n")) {
        if (line.trim().equals("XXX")) {
            xxxOnOwnLine = true;
            break;
        }
    }
    if (xxxOnOwnLine) {
        IO.println("  PASS: XXX appears on its own line");
        passed++;
    } else {
        IO.println("  FAIL: expected 'XXX' on its own line");
    }

    // Test 6: "OOOOO" appears on its own line
    total++;
    boolean oooooOnOwnLine = false;
    for (var line : out1.split("\n")) {
        if (line.trim().equals("OOOOO")) {
            oooooOnOwnLine = true;
            break;
        }
    }
    if (oooooOnOwnLine) {
        IO.println("  PASS: OOOOO appears on its own line");
        passed++;
    } else {
        IO.println("  FAIL: expected 'OOOOO' on its own line");
    }

    IO.println("Exercise 06: " + passed + "/" + total + " passed");
}

String run(String input) throws Exception {
    var pb = new ProcessBuilder("java", "Main.java");
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
