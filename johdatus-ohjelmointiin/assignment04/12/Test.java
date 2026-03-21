import java.util.concurrent.TimeUnit;
import java.nio.file.Files;
import java.nio.file.Path;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    // Test 1: basic file with positive numbers
    total++;
    try {
        Files.writeString(Path.of("test_numbers1.txt"), "3\n1\n4\n0\n");
        String out1 = run(null, new String[]{"test_numbers1.txt"});
        if (out1.contains("*** (3)") && out1.contains("* (1)")
                && out1.contains("**** (4)") && out1.contains("(0)")
                && out1.contains("=== test_numbers1.txt ===")) {
            IO.println("  PASS: bar chart with positive numbers");
            passed++;
        } else {
            IO.println("  FAIL: output was '" + out1 + "'");
        }
    } finally {
        Files.deleteIfExists(Path.of("test_numbers1.txt"));
    }

    // Test 2: file with negative number
    total++;
    try {
        Files.writeString(Path.of("test_numbers2.txt"), "5\n-3\n2\n");
        String out2 = run(null, new String[]{"test_numbers2.txt"});
        if (out2.contains("(0)") && out2.contains("***** (5)")) {
            IO.println("  PASS: bar chart with negative number");
            passed++;
        } else {
            IO.println("  FAIL: output was '" + out2 + "'");
        }
    } finally {
        Files.deleteIfExists(Path.of("test_numbers2.txt"));
    }

    // Test 3: multiple files in one run
    total++;
    try {
        Files.writeString(Path.of("test_a.txt"), "2\n3\n");
        Files.writeString(Path.of("test_b.txt"), "1\n4\n");
        String out3 = run(null, new String[]{"test_a.txt", "test_b.txt"});
        if (out3.contains("=== test_a.txt ===") && out3.contains("=== test_b.txt ===")
                && out3.contains("** (2)") && out3.contains("* (1)")) {
            IO.println("  PASS: multiple files processed");
            passed++;
        } else {
            IO.println("  FAIL: expected both file headers and bars, got: " + out3.trim());
        }
    } finally {
        Files.deleteIfExists(Path.of("test_a.txt"));
        Files.deleteIfExists(Path.of("test_b.txt"));
    }

    // Test 4: empty lines are ignored
    total++;
    try {
        Files.writeString(Path.of("test_empty.txt"), "2\n\n3\n");
        String out4 = run(null, new String[]{"test_empty.txt"});
        var lines = out4.lines()
            .filter(l -> l.contains("("))
            .toList();
        if (lines.size() == 2 && out4.contains("** (2)") && out4.contains("*** (3)")) {
            IO.println("  PASS: empty lines ignored");
            passed++;
        } else {
            IO.println("  FAIL: expected 2 bar lines, got: " + out4.trim());
        }
    } finally {
        Files.deleteIfExists(Path.of("test_empty.txt"));
    }

    // Test 5: zero value prints no stars
    total++;
    try {
        Files.writeString(Path.of("test_zero.txt"), "0\n");
        String out5 = run(null, new String[]{"test_zero.txt"});
        if (out5.contains("(0)") && !out5.contains("* (0)")) {
            IO.println("  PASS: zero prints (0) with no stars");
            passed++;
        } else {
            IO.println("  FAIL: expected '(0)' without stars, got: " + out5.trim());
        }
    } finally {
        Files.deleteIfExists(Path.of("test_zero.txt"));
    }

    // Test 6: blank line separator between files
    total++;
    try {
        Files.writeString(Path.of("test_sep1.txt"), "1\n");
        Files.writeString(Path.of("test_sep2.txt"), "2\n");
        String out6 = run(null, new String[]{"test_sep1.txt", "test_sep2.txt"});
        int idx1 = out6.indexOf("=== test_sep1.txt ===");
        int idx2 = out6.indexOf("=== test_sep2.txt ===");
        String between = (idx1 >= 0 && idx2 > idx1) ? out6.substring(idx1, idx2) : "";
        if (idx1 >= 0 && idx2 > idx1 && between.contains("\n\n")) {
            IO.println("  PASS: blank line separator between files");
            passed++;
        } else {
            IO.println("  FAIL: expected blank line between file sections, got: " + out6.trim());
        }
    } finally {
        Files.deleteIfExists(Path.of("test_sep1.txt"));
        Files.deleteIfExists(Path.of("test_sep2.txt"));
    }

    IO.println("Exercise 12: " + passed + "/" + total + " passed");
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
