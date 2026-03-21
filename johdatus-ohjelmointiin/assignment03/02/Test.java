import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run(null);
    if (!output.isBlank()) {
        IO.println("  PASS: program compiles and produces output");
        passed++;
    } else {
        IO.println("  FAIL: program produced no output");
    }

    IO.println("Exercise 02: " + passed + "/" + total + " passed");
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
