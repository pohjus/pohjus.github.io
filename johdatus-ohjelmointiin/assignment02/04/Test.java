import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var result = runWithExitCode(null);
    if (result.exitCode == 0 && !result.output.isEmpty()) {
        IO.println("  PASS: program compiles and runs with initialized variables");
        passed++;
    } else {
        IO.println("  FAIL: program did not compile or run successfully, got: " + result.output.trim());
    }

    IO.println("Exercise 04: " + passed + "/" + total + " passed");
}

record Result(String output, int exitCode) {}

Result runWithExitCode(String input) throws Exception {
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
        return new Result("", -1);
    }
    return new Result(output, process.exitValue());
}
