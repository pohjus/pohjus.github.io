import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    var output = run("Matti\n");
    if (output.contains("Hello Matti!")) {
        IO.println("  PASS: prints 'Hello Matti!' for input 'Matti'");
        passed++;
    } else {
        IO.println("  FAIL: expected 'Hello Matti!', got: " + output.trim());
    }

    total++;
    output = run("Ville\n");
    if (!output.contains("Hello")) {
        IO.println("  PASS: prints nothing for input 'Ville'");
        passed++;
    } else {
        IO.println("  FAIL: expected no greeting for 'Ville', got: " + output.trim());
    }

    total++;
    output = run("matti\n");
    var lines = output.lines()
        .map(String::trim)
        .filter(line -> !line.isEmpty())
        .filter(line -> !line.toLowerCase().contains("enter") && !line.toLowerCase().contains("name"))
        .toList();
    if (lines.isEmpty()) {
        IO.println("  PASS: prints nothing for input 'matti' (case sensitive)");
        passed++;
    } else {
        IO.println("  FAIL: expected no output for 'matti', got: " + lines);
    }

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
    if (!exited) {
        process.destroyForcibly();
        return "";
    }
    return output;
}
