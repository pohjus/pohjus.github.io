import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    String out = run(null);
    String[] lines = out.strip().split("\n");

    total++;
    if (out.contains("*******")) {
        IO.println("  PASS: output contains a 7-star line");
        passed++;
    } else {
        IO.println("  FAIL: output contains a 7-star line");
    }

    total++;
    int count = 0;
    for (String line : lines) {
        if (line.contains("*******")) count++;
    }
    if (count == 3) {
        IO.println("  PASS: exactly 3 lines with 7 stars");
        passed++;
    } else {
        IO.println("  FAIL: exactly 3 lines with 7 stars");
    }

    total++;
    boolean hasEight = false;
    for (String line : lines) {
        if (line.contains("********")) hasEight = true;
    }
    if (!hasEight) {
        IO.println("  PASS: no line exceeds 7 stars");
        passed++;
    } else {
        IO.println("  FAIL: no line exceeds 7 stars");
    }

    IO.println("Exercise 09: " + passed + "/" + total + " passed");
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
