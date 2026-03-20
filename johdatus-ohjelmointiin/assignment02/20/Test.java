import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    var output = run("rock\npaper\nscissors\n");

    total++;
    long roundCount = output.lines()
        .filter(line -> line.contains("Round"))
        .count();
    if (roundCount >= 3) {
        IO.println("  PASS: game plays three rounds");
        passed++;
    } else {
        IO.println("  FAIL: expected 3 rounds, found " + roundCount);
    }

    total++;
    if (output.contains("win the game") || output.contains("wins the game") || output.contains("game is a tie")) {
        IO.println("  PASS: final winner is announced");
        passed++;
    } else {
        IO.println("  FAIL: expected final winner announcement, got: " + output.trim());
    }

    IO.println("Exercise 20: " + passed + "/" + total + " passed");
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
