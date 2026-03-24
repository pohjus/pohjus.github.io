import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run(null);
    if (output.contains("Hello World!")) {
        IO.println("  PASS: output contains 'Hello World!'");
        passed++;
    } else {
        IO.println("  FAIL: expected output to contain 'Hello World!', got: " + output.trim());
    }

    IO.println("Exercise 02: " + passed + "/" + total + " passed");
}

String run(String input) throws Exception {
    var pb = new ProcessBuilder("java", "Main.java");
    pb.redirectErrorStream(true);
    var process = pb.start();
    if (input != null) {
        process.getOutputStream().write(input.getBytes());
        process.getOutputStream().close();
    } else {
        process.getOutputStream().close();
    }
    var output = new String(process.getInputStream().readAllBytes());
    boolean exited = process.waitFor(10, TimeUnit.SECONDS);
    if (!exited) {
        process.destroyForcibly();
        return "";
    }
    return output;
}
