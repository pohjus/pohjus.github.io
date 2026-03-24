import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("5\n2\n");
    if (output.contains("2.5")) {
        IO.println("  PASS: inputs 5 and 2 produce output 2.5");
        passed++;
    } else {
        IO.println("  FAIL: expected '2.5' for inputs 5 and 2, got: " + output.trim());
    }

    total++;
    output = run("7\n2\n");
    if (output.contains("3.5")) {
        IO.println("  PASS: inputs 7 and 2 produce output 3.5");
        passed++;
    } else {
        IO.println("  FAIL: expected '3.5' for inputs 7 and 2, got: " + output.trim());
    }

    IO.println("Exercise 04: " + passed + "/" + total + " passed");
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
