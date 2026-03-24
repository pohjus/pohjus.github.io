import java.util.concurrent.TimeUnit;
import java.nio.file.Files;
import java.nio.file.Path;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    // Test 1: Main extends JFrame
    total++;
    String testSource = Files.readString(Path.of("Main.java"));
    if (testSource.contains("extends JFrame")) {
        IO.println("  PASS: Main extends JFrame");
        passed++;
    } else {
        IO.println("  FAIL: expected 'extends JFrame' in Main.java");
    }

    // Test 2: source contains required Swing components
    total++;
    boolean hasButton = testSource.contains("new JButton(\"Clear\")");
    boolean hasTextArea = testSource.contains("new JTextArea()");
    boolean hasMenu = testSource.contains("new JMenu(\"File\")")
        && testSource.contains("new JMenuItem(\"Exit\")");
    if (hasButton && hasTextArea && hasMenu) {
        IO.println("  PASS: source contains button, text area and menu");
        passed++;
    } else {
        IO.println("  FAIL: missing one of the required Swing components");
    }

    // Test 3: source uses BorderLayout and visibility setup
    total++;
    boolean hasLayout = testSource.contains("new BorderLayout()")
        || testSource.contains("BorderLayout.NORTH");
    boolean hasVisible = testSource.contains("setVisible(true)");
    boolean hasSize = testSource.contains("setSize(");
    if (hasLayout && hasVisible && hasSize) {
        IO.println("  PASS: source uses layout, size and visibility");
        passed++;
    } else {
        IO.println("  FAIL: missing BorderLayout, setSize or setVisible");
    }

    // Test 4: source sets the title in constructor
    total++;
    if (testSource.contains("super(\"Rectangle GUI\")")) {
        IO.println("  PASS: constructor sets the window title");
        passed++;
    } else {
        IO.println("  FAIL: expected constructor title setup");
    }

    // Test 5: screenshot file exists
    total++;
    if (Files.exists(Path.of("screenshot.png"))) {
        IO.println("  PASS: screenshot.png exists");
        passed++;
    } else {
        IO.println("  FAIL: expected screenshot.png in exercise folder");
    }

    IO.println("Exercise 16: " + passed + "/" + total + " passed");
}

String compile() throws Exception {
    var pb = new ProcessBuilder(
        "javac",
        "Rectangle.java",
        "Main.java"
    );
    pb.redirectErrorStream(true);
    var process = pb.start();
    var output = new String(process.getInputStream().readAllBytes());
    process.waitFor(10, TimeUnit.SECONDS);
    if (process.exitValue() != 0) {
        return output;
    }
    return null;
}

String compileAndRun(String code) throws Exception {
    Files.writeString(Path.of("TestTemp.java"), code);
    var pb = new ProcessBuilder("javac", "Rectangle.java", "TestTemp.java");
    pb.redirectErrorStream(true);
    var process = pb.start();
    var output = new String(process.getInputStream().readAllBytes());
    process.waitFor(10, TimeUnit.SECONDS);
    if (process.exitValue() != 0) {
        return "COMPILE_ERROR: " + output;
    }
    var pb2 = new ProcessBuilder("java", "TestTemp");
    pb2.redirectErrorStream(true);
    var process2 = pb2.start();
    process2.getOutputStream().close();
    var result = new String(process2.getInputStream().readAllBytes());
    boolean exited = process2.waitFor(10, TimeUnit.SECONDS);
    if (!exited) {
        process2.destroyForcibly();
        return "";
    }
    Files.deleteIfExists(Path.of("TestTemp.java"));
    Files.deleteIfExists(Path.of("TestTemp.class"));
    return result;
}
