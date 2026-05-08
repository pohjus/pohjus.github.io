import java.util.concurrent.TimeUnit;

void main() throws Exception {
    String out1 = run("3\n7\n");
    if (out1.contains("it was ten") && !out1.contains("not")) IO.println("PASS: 3+7=10 recognized as ten");
    else IO.println("FAIL: 3+7=10 recognized as ten");

    String out2 = run("1\n2\n");
    if (out2.contains("it was not ten")) IO.println("PASS: 1+2=3 recognized as not ten");
    else IO.println("FAIL: 1+2=3 recognized as not ten");

    String out3 = run("5\n5\n");
    if (out3.contains("it was ten") && !out3.contains("not")) IO.println("PASS: 5+5=10 recognized as ten");
    else IO.println("FAIL: 5+5=10 recognized as ten");
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
