import java.util.concurrent.TimeUnit;

void main() throws Exception {
    String out = run(null);

    if (out.contains("sum = 10")) IO.println("PASS: contains sum = 10");
    else IO.println("FAIL: contains sum = 10");

    if (out.contains("sum = 26")) IO.println("PASS: contains sum = 26");
    else IO.println("FAIL: contains sum = 26");

    if (out.contains("1 2 3 4")) IO.println("PASS: contains 1 2 3 4");
    else IO.println("FAIL: contains 1 2 3 4");
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
