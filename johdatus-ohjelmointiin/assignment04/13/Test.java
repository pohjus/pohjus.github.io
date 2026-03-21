import java.util.concurrent.TimeUnit;
import java.nio.file.Files;
import java.nio.file.Path;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    // Test 1: no arguments, should print error
    total++;
    String out1 = run(null, new String[]{});
    if (!out1.trim().isEmpty()
            && (out1.toLowerCase().contains("error") || out1.toLowerCase().contains("no")
                || out1.toLowerCase().contains("usage") || out1.toLowerCase().contains("provide"))) {
        IO.println("  PASS: error message for no arguments");
        passed++;
    } else {
        IO.println("  FAIL: expected error message, got '" + out1.trim() + "'");
    }

    // Test 2: nonexistent file, no header printed
    total++;
    String out2 = run(null, new String[]{"nonexistent_file_xyz.txt"});
    if (out2.toLowerCase().contains("not found") && out2.contains("nonexistent_file_xyz.txt")) {
        IO.println("  PASS: not found message for missing file");
        passed++;
    } else {
        IO.println("  FAIL: expected 'not found' with filename, got '" + out2.trim() + "'");
    }

    // Test 3: file with invalid number, prints bars before error then stops
    total++;
    try {
        Files.writeString(Path.of("test_invalid.txt"), "3\nabc\n2\n");
        String out3 = run(null, new String[]{"test_invalid.txt"});
        boolean hasBarsBeforeError = out3.contains("*** (3)");
        boolean hasErrorMsg = out3.toLowerCase().contains("invalid")
            || out3.toLowerCase().contains("error")
            || out3.toLowerCase().contains("not a number");
        boolean stoppedBeforeLast = !out3.contains("** (2)");
        if (hasBarsBeforeError && hasErrorMsg && stoppedBeforeLast) {
            IO.println("  PASS: prints bars then stops on invalid number");
            passed++;
        } else {
            IO.println("  FAIL: expected bars for 3, error for abc, no bars for 2, got: " + out3.trim());
        }
    } finally {
        Files.deleteIfExists(Path.of("test_invalid.txt"));
    }

    // Test 4: valid file works correctly
    total++;
    try {
        Files.writeString(Path.of("test_valid.txt"), "3\n1\n4\n");
        String out4 = run(null, new String[]{"test_valid.txt"});
        if (out4.contains("*** (3)") && out4.contains("* (1)") && out4.contains("**** (4)")) {
            IO.println("  PASS: valid file works correctly");
            passed++;
        } else {
            IO.println("  FAIL: expected bar output, got: " + out4.trim());
        }
    } finally {
        Files.deleteIfExists(Path.of("test_valid.txt"));
    }

    // Test 5: nonexistent file does not print header before error
    total++;
    String out5 = run(null, new String[]{"missing_xyz.txt"});
    if (!out5.contains("===")) {
        IO.println("  PASS: no header printed for missing file");
        passed++;
    } else {
        IO.println("  FAIL: expected no header for missing file, got: " + out5.trim());
    }

    IO.println("Exercise 13: " + passed + "/" + total + " passed");
}

String run(String input, String[] args) throws Exception {
    var cmd = new java.util.ArrayList<String>();
    cmd.add("java");
    cmd.add("Main.java");
    for (var a : args) cmd.add(a);
    var pb = new ProcessBuilder(cmd);
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
