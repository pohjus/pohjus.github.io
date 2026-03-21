import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("rock\nscissors\n");
    if (output.contains("Player 1 wins")) {
        IO.println("  PASS: rock beats scissors");
        passed++;
    } else {
        IO.println("  FAIL: expected 'Player 1 wins' for rock vs scissors, got: " + output.trim());
    }

    total++;
    output = run("paper\nrock\n");
    if (output.contains("Player 1 wins")) {
        IO.println("  PASS: paper beats rock");
        passed++;
    } else {
        IO.println("  FAIL: expected 'Player 1 wins' for paper vs rock, got: " + output.trim());
    }

    total++;
    output = run("scissors\npaper\n");
    if (output.contains("Player 1 wins")) {
        IO.println("  PASS: scissors beats paper");
        passed++;
    } else {
        IO.println("  FAIL: expected 'Player 1 wins' for scissors vs paper, got: " + output.trim());
    }

    total++;
    output = run("rock\nrock\n");
    if (output.toLowerCase().contains("tie")) {
        IO.println("  PASS: rock vs rock is a tie");
        passed++;
    } else {
        IO.println("  FAIL: expected 'tie' for rock vs rock, got: " + output.trim());
    }

    total++;
    output = run("scissors\nrock\n");
    if (output.contains("Player 2 wins")) {
        IO.println("  PASS: rock beats scissors (Player 2 wins)");
        passed++;
    } else {
        IO.println("  FAIL: expected 'Player 2 wins' for scissors vs rock, got: " + output.trim());
    }

    IO.println("Exercise 18: " + passed + "/" + total + " passed");
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
