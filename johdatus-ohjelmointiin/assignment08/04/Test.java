import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    // Test 1: Human(String) exists
    total++;
    String humanSource = Files.readString(Path.of("Human.java"));
    if (humanSource.contains("public Human(String n)")) {
        IO.println("  PASS: Human has a constructor");
        passed++;
    } else {
        IO.println("  FAIL: expected Human(String n)");
    }

    // Test 2: Programmer(String) uses super(n)
    total++;
    String programmerSource = Files.readString(Path.of("Programmer.java"));
    if (programmerSource.contains("public Programmer(String n)")
        && programmerSource.contains("super(n)")) {
        IO.println("  PASS: Programmer constructor uses super(n)");
        passed++;
    } else {
        IO.println("  FAIL: expected Programmer(String n) with super(n)");
    }

    // Test 3: named constructor objects work in Main
    total++;
    String output = run();
    if (output.contains("Tiina drinks") && output.contains("Hanna codes")) {
        IO.println("  PASS: constructor-created objects work");
        passed++;
    } else {
        IO.println("  FAIL: expected constructor-based output");
    }

    IO.println("Exercise 04: " + passed + "/" + total + " passed");
}

String run() throws Exception {
    var pb = new ProcessBuilder("java", "Main.java");
    pb.redirectErrorStream(true);
    var process = pb.start();
    process.getOutputStream().close();
    var output = new String(process.getInputStream().readAllBytes());
    process.waitFor(10, TimeUnit.SECONDS);
    return output;
}
