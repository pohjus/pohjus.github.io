import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("Abcdefg1\n");
    if (output.contains("accepted")) {
        IO.println("  PASS: 'Abcdefg1' is accepted");
        passed++;
    } else {
        IO.println("  FAIL: expected 'accepted' for valid password, got: " + output.trim());
    }

    total++;
    output = run("short\n");
    if (!output.contains("accepted")) {
        IO.println("  PASS: 'short' is rejected (too short)");
        passed++;
    } else {
        IO.println("  FAIL: expected rejection for 'short'");
    }

    total++;
    output = run("abcdefgh\n");
    if (!output.contains("accepted")) {
        IO.println("  PASS: 'abcdefgh' is rejected (no uppercase or digit)");
        passed++;
    } else {
        IO.println("  FAIL: expected rejection for 'abcdefgh'");
    }

    total++;
    output = run("ABCDEFG1\n");
    if (!output.contains("accepted")) {
        IO.println("  PASS: 'ABCDEFG1' is rejected (no lowercase)");
        passed++;
    } else {
        IO.println("  FAIL: expected rejection for 'ABCDEFG1'");
    }

    total++;
    output = run("Abcdefgh\n");
    if (!output.contains("accepted")) {
        IO.println("  PASS: 'Abcdefgh' is rejected (no digit)");
        passed++;
    } else {
        IO.println("  FAIL: expected rejection for 'Abcdefgh'");
    }

    total++;
    output = run("12345678A\n");
    if (!output.contains("accepted")) {
        IO.println("  PASS: '12345678A' is rejected (no lowercase)");
        passed++;
    } else {
        IO.println("  FAIL: expected rejection for '12345678A'");
    }

    IO.println("Exercise 08: " + passed + "/" + total + " passed");
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
