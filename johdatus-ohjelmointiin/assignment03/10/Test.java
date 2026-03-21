import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("5\n10\n");
    if (output.contains("5") && output.contains("6") && output.contains("7")
            && output.contains("8") && output.contains("9") && output.contains("10")) {
        IO.println("  PASS: 5 to 10 prints all numbers");
        passed++;
    } else {
        IO.println("  FAIL: expected 5 to 10, got: " + output.trim());
    }

    total++;
    output = run("2\n-3\n");
    if (output.contains("-3") && output.contains("-2") && output.contains("-1")
            && output.contains("0") && output.contains("1") && output.contains("2")) {
        IO.println("  PASS: 2 and -3 prints -3 to 2");
        passed++;
    } else {
        IO.println("  FAIL: expected -3 to 2, got: " + output.trim());
    }

    total++;
    output = run("3\n3\n");
    if (output.contains("3")) {
        IO.println("  PASS: equal inputs prints the number");
        passed++;
    } else {
        IO.println("  FAIL: expected 3 in output, got: " + output.trim());
    }

    IO.println("Exercise 10: " + passed + "/" + total + " passed");
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
