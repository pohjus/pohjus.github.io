import java.util.concurrent.TimeUnit;

void main() throws Exception {
    String out1 = run("5\n");
    if (out1.contains("15")) IO.println("PASS: sum 1..5 = 15");
    else IO.println("FAIL: sum 1..5 = 15");

    String out2 = run("1\n");
    if (out2.contains("1")) IO.println("PASS: sum 1..1 = 1");
    else IO.println("FAIL: sum 1..1 = 1");

    String out3 = run("10\n");
    if (out3.contains("55")) IO.println("PASS: sum 1..10 = 55");
    else IO.println("FAIL: sum 1..10 = 55");
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
