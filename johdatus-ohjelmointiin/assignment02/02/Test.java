import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("2\n");
    if (output.contains("The dog is of exceptional age.")) {
        IO.println("  PASS: age 2 prints 'The dog is of exceptional age.'");
        passed++;
    } else {
        IO.println("  FAIL: expected 'The dog is of exceptional age.' for age 2, got: " + output.trim());
    }

    total++;
    output = run("5\n");
    if (!output.contains("The dog is of exceptional age.")) {
        IO.println("  PASS: age 5 prints nothing");
        passed++;
    } else {
        IO.println("  FAIL: should not print for age 5, got: " + output.trim());
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
