import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("5\n");
    if (output.contains("improbatur")) {
        IO.println("  PASS: score 5 outputs 'improbatur'");
        passed++;
    } else {
        IO.println("  FAIL: expected 'improbatur' for score 5, got: " + output.trim());
    }

    total++;
    output = run("8\n");
    if (output.contains("improbatur")) {
        IO.println("  PASS: score 8 outputs 'improbatur'");
        passed++;
    } else {
        IO.println("  FAIL: expected 'improbatur' for score 8, got: " + output.trim());
    }

    total++;
    output = run("9\n");
    if (output.contains("approbatur")) {
        IO.println("  PASS: score 9 outputs 'approbatur'");
        passed++;
    } else {
        IO.println("  FAIL: expected 'approbatur' for score 9, got: " + output.trim());
    }

    total++;
    output = run("20\n");
    if (output.contains("lubenter")) {
        IO.println("  PASS: score 20 outputs 'lubenter'");
        passed++;
    } else {
        IO.println("  FAIL: expected 'lubenter' for score 20, got: " + output.trim());
    }

    total++;
    output = run("36\n");
    if (output.contains("magna")) {
        IO.println("  PASS: score 36 outputs 'magna'");
        passed++;
    } else {
        IO.println("  FAIL: expected 'magna' for score 36, got: " + output.trim());
    }

    total++;
    output = run("45\n");
    if (output.contains("eximia")) {
        IO.println("  PASS: score 45 outputs 'eximia'");
        passed++;
    } else {
        IO.println("  FAIL: expected 'eximia' for score 45, got: " + output.trim());
    }

    total++;
    output = run("55\n");
    if (output.contains("laudatur")) {
        IO.println("  PASS: score 55 outputs 'laudatur'");
        passed++;
    } else {
        IO.println("  FAIL: expected 'laudatur' for score 55, got: " + output.trim());
    }

    IO.println("Exercise 13: " + passed + "/" + total + " passed");
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
