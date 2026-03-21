import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("k\ni\ns\na\n");
    if (output.contains("Correct!")) {
        IO.println("  PASS: game ends with 'Correct!' when all letters guessed");
        passed++;
    } else {
        IO.println("  FAIL: expected 'Correct!', got: " + output.trim());
    }

    total++;
    if (output.contains("-----")) {
        IO.println("  PASS: initial state shows dashes");
        passed++;
    } else {
        IO.println("  FAIL: expected '-----' in initial output");
    }

    total++;
    if (output.contains("k----")) {
        IO.println("  PASS: after guessing 'k', shows 'k----'");
        passed++;
    } else {
        IO.println("  FAIL: expected 'k----' after first guess");
    }

    IO.println("Exercise 17: " + passed + "/" + total + " passed");
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
