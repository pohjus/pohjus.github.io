import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run(null);
    if (output != null && !output.isEmpty() && !output.contains("Error") && !output.contains("Exception")) {
        IO.println("  PASS: program compiles and runs without error");
        passed++;
    } else {
        IO.println("  FAIL: program did not run successfully, got: " + output.trim());
    }

    total++;
    boolean foundDigit = false;
    for (int i = 0; i < 20; i++) {
        output = run(null);
        for (var line : output.split("\n")) {
            var trimmed = line.trim();
            if (trimmed.matches("[0-9]")) {
                foundDigit = true;
                break;
            }
        }
        if (foundDigit) break;
    }
    if (foundDigit) {
        IO.println("  PASS: output contains a digit 0-9");
        passed++;
    } else {
        IO.println("  FAIL: expected a digit 0-9 in output");
    }

    total++;
    boolean foundRPS = false;
    for (int i = 0; i < 20; i++) {
        output = run(null);
        if (output.contains("rock") || output.contains("paper") || output.contains("scissors")) {
            foundRPS = true;
            break;
        }
    }
    if (foundRPS) {
        IO.println("  PASS: output contains rock, paper, or scissors");
        passed++;
    } else {
        IO.println("  FAIL: expected rock, paper, or scissors in output");
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
