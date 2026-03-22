import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    String out1 = run("3\n7\n");
    if (out1.contains("it was ten") && !out1.contains("not")) passed++;

    total++;
    String out2 = run("1\n2\n");
    if (out2.contains("it was not ten")) passed++;

    total++;
    String out3 = run("5\n5\n");
    if (out3.contains("it was ten") && !out3.contains("not")) passed++;

    IO.println("Exercise 01: " + passed + "/" + total + " passed");
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
