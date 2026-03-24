import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    // Test 1: Mammal is abstract
    total++;
    String source = Files.readString(Path.of("Mammal.java"));
    if (source.contains("abstract class Mammal")) {
        IO.println("  PASS: Mammal is abstract");
        passed++;
    } else {
        IO.println("  FAIL: expected abstract Mammal");
    }

    // Test 2: Dog inherits giveBirth()
    total++;
    String output = run();
    if (output.contains("gives birth to a child.")) {
        IO.println("  PASS: Dog can call giveBirth()");
        passed++;
    } else {
        IO.println("  FAIL: expected giveBirth() output");
    }

    IO.println("Exercise 08: " + passed + "/" + total + " passed");
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
