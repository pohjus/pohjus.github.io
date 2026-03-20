import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("3\n7\n");
    if (output.contains("7")) {
        IO.println("  PASS: prints 7 as larger of 3 and 7");
        passed++;
    } else {
        IO.println("  FAIL: expected '7' as larger of 3 and 7, got: " + output.trim());
    }

    total++;
    output = run("9\n2\n");
    if (output.contains("9")) {
        IO.println("  PASS: prints 9 as larger of 9 and 2");
        passed++;
    } else {
        IO.println("  FAIL: expected '9' as larger of 9 and 2, got: " + output.trim());
    }

    total++;
    output = run("100\n200\n");
    if (output.contains("200")) {
        IO.println("  PASS: prints 200 as larger of 100 and 200");
        passed++;
    } else {
        IO.println("  FAIL: expected '200' as larger of 100 and 200, got: " + output.trim());
    }

    IO.println("Exercise 06: " + passed + "/" + total + " passed");
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
