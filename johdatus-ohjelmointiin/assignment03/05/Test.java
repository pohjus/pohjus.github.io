import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("Otto\n");
    if (output.contains("o") && output.contains("t")) {
        IO.println("  PASS: 'Otto' reversed every other contains o and t");
        passed++;
    } else {
        IO.println("  FAIL: expected o and t in output, got: " + output.trim());
    }

    total++;
    output = run("ABCDE\n");
    if (output.contains("E") && output.contains("C") && output.contains("A")) {
        IO.println("  PASS: 'ABCDE' reversed every other contains E, C, A");
        passed++;
    } else {
        IO.println("  FAIL: expected E, C, A in output, got: " + output.trim());
    }

    IO.println("Exercise 05: " + passed + "/" + total + " passed");
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
