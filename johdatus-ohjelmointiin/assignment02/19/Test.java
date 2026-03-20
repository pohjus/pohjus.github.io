import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("rock\n");
    if (output.contains("Computer chose")) {
        IO.println("  PASS: program runs and accepts user input");
        passed++;
    } else {
        IO.println("  FAIL: expected program to show computer's choice, got: " + output.trim());
    }

    total++;
    if (output.contains("win") || output.contains("tie")) {
        IO.println("  PASS: program announces winner correctly");
        passed++;
    } else {
        IO.println("  FAIL: expected win/tie announcement, got: " + output.trim());
    }

    IO.println("Exercise 19: " + passed + "/" + total + " passed");
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
