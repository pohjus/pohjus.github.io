import java.util.concurrent.TimeUnit;
import java.io.File;
import java.nio.file.Files;
import java.nio.charset.Charset;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    var output = run(null);
    var lines = output.lines().toList();

    total++;
    if (lines.size() == 5) {
        IO.println("  PASS: output has 5 lines (one per input value)");
        passed++;
    } else {
        IO.println("  FAIL: expected 5 lines, got " + lines.size());
    }

    total++;
    if (lines.size() >= 1 && lines.get(0).equals("   |+++")) {
        IO.println("  PASS: value 3 produces '   |+++'");
        passed++;
    } else {
        IO.println("  FAIL: expected '   |+++' for value 3, got: " + (lines.size() >= 1 ? lines.get(0) : "(no output)"));
    }

    total++;
    if (lines.size() >= 2 && lines.get(1).equals("---|")) {
        IO.println("  PASS: value -3 produces '---|'");
        passed++;
    } else {
        IO.println("  FAIL: expected '---|' for value -3, got: " + (lines.size() >= 2 ? lines.get(1) : "(no output)"));
    }

    total++;
    if (lines.size() >= 3 && lines.get(2).equals("  -|")) {
        IO.println("  PASS: value -1 produces '  -|'");
        passed++;
    } else {
        IO.println("  FAIL: expected '  -|' for value -1, got: " + (lines.size() >= 3 ? lines.get(2) : "(no output)"));
    }

    total++;
    if (lines.size() >= 4 && lines.get(3).equals("   |++++")) {
        IO.println("  PASS: value 4 produces '   |++++'");
        passed++;
    } else {
        IO.println("  FAIL: expected '   |++++' for value 4, got: " + (lines.size() >= 4 ? lines.get(3) : "(no output)"));
    }

    total++;
    if (lines.size() >= 5 && lines.get(4).equals("   |")) {
        IO.println("  PASS: value 0 produces '   |'");
        passed++;
    } else {
        IO.println("  FAIL: expected '   |' for value 0, got: " + (lines.size() >= 5 ? lines.get(4) : "(no output)"));
    }

    IO.println("Exercise 15: " + passed + "/" + total + " passed");
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
