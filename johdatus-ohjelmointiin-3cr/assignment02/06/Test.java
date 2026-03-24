import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("3\n");
    if (output.contains("You entered: 3")) {
        IO.println("  PASS: accepts valid input 3");
        passed++;
    } else {
        IO.println("  FAIL: expected 'You entered: 3' for input 3, got: " + output.trim());
    }

    total++;
    output = run("0\n9\n5\n");
    if (output.contains("You entered: 5")) {
        IO.println("  PASS: rejects 0 and 9, accepts 5");
        passed++;
    } else {
        IO.println("  FAIL: expected 'You entered: 5' after rejecting 0 and 9, got: " + output.trim());
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
