import java.nio.file.Files;
import java.nio.file.Path;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    String listenerSource = Files.readString(Path.of("Listener.java"));
    String mainSource = Files.readString(Path.of("Main.java"));

    // Test 1: Listener implements ActionListener
    total++;
    if (listenerSource.contains("implements ActionListener")) {
        IO.println("  PASS: Listener implements ActionListener");
        passed++;
    } else {
        IO.println("  FAIL: expected ActionListener implementation");
    }

    // Test 2: actionPerformed prints click
    total++;
    if (listenerSource.contains("System.out.println(\"click\")")) {
        IO.println("  PASS: actionPerformed prints click");
        passed++;
    } else {
        IO.println("  FAIL: expected click output in actionPerformed");
    }

    // Test 3: Main adds the listener to the button
    total++;
    if (mainSource.contains("ok.addActionListener(obj)")) {
        IO.println("  PASS: Main attaches the listener");
        passed++;
    } else {
        IO.println("  FAIL: expected addActionListener call");
    }

    // Test 4: clicking changes the window title
    total++;
    if (mainSource.contains("setTitle(\"click \" + clicks)")) {
        IO.println("  PASS: click changes the window title");
        passed++;
    } else {
        IO.println("  FAIL: expected setTitle update");
    }

    IO.println("Exercise 17: " + passed + "/" + total + " passed");
}
