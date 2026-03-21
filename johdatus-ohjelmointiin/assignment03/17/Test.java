import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    var letters = "abcdefghijklmnopqrstuvwxyz";
    var sb = new StringBuilder();
    for (int i = 0; i < letters.length(); i++) {
        sb.append(letters.charAt(i));
        sb.append('\n');
    }
    var output = run(sb.toString());

    total++;
    if (output.contains("Correct!")) {
        IO.println("  PASS: game ends with 'Correct!' when all letters guessed");
        passed++;
    } else {
        IO.println("  FAIL: expected 'Correct!' in output");
    }

    total++;
    if (output.contains("Guess the word")) {
        IO.println("  PASS: displays 'Guess the word' prompt");
        passed++;
    } else {
        IO.println("  FAIL: expected 'Guess the word' prompt");
    }

    total++;
    var lines = output.lines().toList();
    boolean hasDashOnly = false;
    for (var line : lines) {
        if (line.trim().matches("^-+$")) {
            hasDashOnly = true;
            break;
        }
    }
    if (hasDashOnly) {
        IO.println("  PASS: initial state shows dashes");
        passed++;
    } else {
        IO.println("  FAIL: expected a line of only dashes for initial state");
    }

    total++;
    boolean hasPartialReveal = false;
    for (var line : lines) {
        var trimmed = line.trim();
        if (trimmed.matches("^[a-zA-Z]+-+$") || trimmed.matches("^-+[a-zA-Z]+.*-+.*$") || trimmed.matches("^[a-zA-Z]+-+[a-zA-Z]+.*$")) {
            hasPartialReveal = true;
            break;
        }
    }
    if (hasPartialReveal) {
        IO.println("  PASS: shows partially revealed word during game");
        passed++;
    } else {
        IO.println("  FAIL: expected partially revealed word (mix of letters and dashes)");
    }

    total++;
    boolean hasFullWord = false;
    var lastCorrectIdx = -1;
    for (int i = 0; i < lines.size(); i++) {
        if (lines.get(i).contains("Correct!")) {
            lastCorrectIdx = i;
        }
    }
    if (lastCorrectIdx > 0) {
        for (int i = lastCorrectIdx - 1; i >= 0; i--) {
            var trimmed = lines.get(i).trim();
            if (!trimmed.isEmpty() && trimmed.matches("^[a-zA-Z]+$") && !trimmed.equals("Correct") && !trimmed.contains("Guess") && !trimmed.contains("word")) {
                hasFullWord = true;
                break;
            }
        }
    }
    if (hasFullWord) {
        IO.println("  PASS: fully revealed word shown before 'Correct!'");
        passed++;
    } else {
        IO.println("  FAIL: expected fully revealed word (no dashes) before 'Correct!'");
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
