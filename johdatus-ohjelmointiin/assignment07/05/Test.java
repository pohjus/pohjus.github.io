import java.util.concurrent.TimeUnit;
import java.nio.file.Files;
import java.nio.file.Path;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    // Test 1: Rectangle.java contains finalize method
    total++;
    String rectSource = Files.readString(Path.of("Rectangle.java"));
    if (rectSource.contains("finalize")) {
        IO.println("  PASS: Rectangle.java contains finalize method");
        passed++;
    } else {
        IO.println("  FAIL: expected finalize method in Rectangle.java");
    }

    // Test 2: Main.java contains runGC or System.gc()
    total++;
    String testSource = Files.readString(Path.of("Main.java"));
    if (testSource.contains("runGC") || testSource.contains("System.gc()")) {
        IO.println("  PASS: Main.java contains GC trigger");
        passed++;
    } else {
        IO.println("  FAIL: expected runGC() or System.gc() in Main.java");
    }

    // Test 3: Main.java sets a reference to null
    total++;
    if (testSource.contains("= null")) {
        IO.println("  PASS: Main.java sets a reference to null");
        passed++;
    } else {
        IO.println("  FAIL: expected '= null' in Main.java");
    }

    // Test 4: source contains a comment about GC behavior
    total++;
    if (testSource.contains("//") || testSource.contains("/*")) {
        IO.println("  PASS: Main.java contains a comment");
        passed++;
    } else {
        IO.println("  FAIL: expected a comment explaining GC behavior");
    }

    IO.println("Exercise 05: " + passed + "/" + total + " passed");
}

String compile() throws Exception {
    var pb = new ProcessBuilder("javac", "-Xlint:-deprecation", "Rectangle.java", "Main.java");
    pb.redirectErrorStream(true);
    var process = pb.start();
    var output = new String(process.getInputStream().readAllBytes());
    process.waitFor(10, TimeUnit.SECONDS);
    if (process.exitValue() != 0) {
        return output;
    }
    return null;
}
