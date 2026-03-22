import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    String out = run(null);

    total++;
    if (out.contains("*******")) passed++;

    total++;
    String[] lines = out.strip().split("\n");
    int count = 0;
    for (String line : lines) {
        if (line.contains("*******")) count++;
    }
    if (count == 3) passed++;

    total++;
    boolean hasEight = false;
    for (String line : lines) {
        if (line.contains("********")) hasEight = true;
    }
    if (!hasEight) passed++;

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
    if (!exited) { process.destroyForcibly(); return ""; }
    return output;
}
