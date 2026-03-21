import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("k\ni\ns\na\no\nr\nt\nl\nu\np\ne\n");
    if (output.contains("Correct!")) {
        IO.println("  PASS: game ends with 'Correct!'");
        passed++;
    } else {
        IO.println("  FAIL: expected 'Correct!', got: " + output.trim());
    }

    total++;
    if (output.contains("Guess the word")) {
        IO.println("  PASS: displays 'Guess the word' prompt");
        passed++;
    } else {
        IO.println("  FAIL: expected 'Guess the word' prompt");
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
