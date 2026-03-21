import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("saippuakauppias\n");
    if (output.contains("alindrome")) {
        IO.println("  PASS: 'saippuakauppias' is a palindrome");
        passed++;
    } else {
        IO.println("  FAIL: expected palindrome result, got: " + output.trim());
    }

    total++;
    output = run("hello\n");
    if (output.contains("ot a palindrome") || output.contains("ot a Palindrome")) {
        IO.println("  PASS: 'hello' is not a palindrome");
        passed++;
    } else {
        IO.println("  FAIL: expected not a palindrome, got: " + output.trim());
    }

    total++;
    output = run("abba\n");
    if (output.contains("alindrome")) {
        IO.println("  PASS: 'abba' is a palindrome");
        passed++;
    } else {
        IO.println("  FAIL: expected palindrome result, got: " + output.trim());
    }

    IO.println("Exercise 08: " + passed + "/" + total + " passed");
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
    if (!exited) {
        process.destroyForcibly();
        return "";
    }
    return output;
}
