import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    String out = run(null);

    total++;
    if (out.contains("sum = 10")) {
        IO.println("  PASS: contains sum = 10");
        passed++;
    } else {
        IO.println("  FAIL: contains sum = 10");
    }

    total++;
    if (out.contains("sum = 26")) {
        IO.println("  PASS: contains sum = 26");
        passed++;
    } else {
        IO.println("  FAIL: contains sum = 26");
    }

    total++;
    if (out.contains("1 2 3 4")) {
        IO.println("  PASS: contains 1 2 3 4");
        passed++;
    } else {
        IO.println("  FAIL: contains 1 2 3 4");
    }

    IO.println("Exercise 10: " + passed + "/" + total + " passed");
}

String run(String input) throws Exception {
    var pb = new ProcessBuilder("java", "Main.java");
    pb.redirectErrorStream(true);
    var process = pb.start();
    if (input != null) {
        process.getOutputStream().write(input.getBytes());
    }
    process.getOutputStream().close();
    boolean exited = process.waitFor(10, TimeUnit.SECONDS);
    if (!exited) { process.destroyForcibly(); return ""; }
    var output = new String(process.getInputStream().readAllBytes());
    return output;
}
