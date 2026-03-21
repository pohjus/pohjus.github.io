import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run();
    if (output.contains("Matti") && output.contains("Pekka")) {
        IO.println("  PASS: contains Matti and Pekka");
        passed++;
    } else {
        IO.println("  FAIL: expected Matti and Pekka, got: " + output.trim());
    }

    total++;
    if (!output.contains("Liisa") && !output.contains("Anna")) {
        IO.println("  PASS: does not contain Liisa or Anna");
        passed++;
    } else {
        IO.println("  FAIL: should not contain Liisa or Anna, got: " + output.trim());
    }

    IO.println("Exercise 03: " + passed + "/" + total + " passed");
}

String run() throws Exception {
    var pb = new ProcessBuilder("java", "Main.java");
    pb.redirectErrorStream(true);
    var process = pb.start();
    process.getOutputStream().close();
    var output = new String(process.getInputStream().readAllBytes());
    boolean exited = process.waitFor(10, TimeUnit.SECONDS);
    if (!exited) {
        process.destroyForcibly();
        return "";
    }
    return output;
}
