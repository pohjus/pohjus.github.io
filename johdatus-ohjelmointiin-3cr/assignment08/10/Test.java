import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    // Test 1: Mammal declares abstract makeSound()
    total++;
    String source = Files.readString(Path.of("Mammal.java"));
    if (source.contains("abstract void makeSound();")) {
        IO.println("  PASS: Mammal declares abstract makeSound()");
        passed++;
    } else {
        IO.println("  FAIL: expected abstract makeSound()");
    }

    // Test 2: Human and Dog implement makeSound()
    total++;
    String output = run();
    if (output.contains("Human says hello") && output.contains("Dog barks")) {
        IO.println("  PASS: subclasses implement makeSound()");
        passed++;
    } else {
        IO.println("  FAIL: expected Human and Dog sound output");
    }

    IO.println("Exercise 10: " + passed + "/" + total + " passed");
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
