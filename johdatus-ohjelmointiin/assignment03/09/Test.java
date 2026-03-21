import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("race car\n");
    if (output.contains("alindrome") && !output.contains("ot a")) {
        IO.println("  PASS: 'race car' is a palindrome (ignoring spaces)");
        passed++;
    } else {
        IO.println("  FAIL: expected palindrome, got: " + output.trim());
    }

    total++;
    output = run("hello world\n");
    if (output.contains("ot a palindrome") || output.contains("ot a Palindrome")) {
        IO.println("  PASS: 'hello world' is not a palindrome");
        passed++;
    } else {
        IO.println("  FAIL: expected not a palindrome, got: " + output.trim());
    }

    total++;
    output = run("Was it a car or a cat I saw\n");
    if (output.contains("alindrome") && !output.contains("ot a")) {
        IO.println("  PASS: 'Was it a car or a cat I saw' is a palindrome (ignoring case and spaces)");
        passed++;
    } else {
        IO.println("  FAIL: expected palindrome, got: " + output.trim());
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
    var output = new String(process.getInputStream().readAllBytes());
    boolean exited = process.waitFor(10, TimeUnit.SECONDS);
    if (!exited) {
        process.destroyForcibly();
        return "";
    }
    return output;
}
