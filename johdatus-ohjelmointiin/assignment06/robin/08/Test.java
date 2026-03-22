import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    total++;
    String out1 = run(null);
    if (!out1.trim().isEmpty()) passed++;

    total++;
    boolean different = false;
    for (int i = 0; i < 10; i++) {
        String out = run(null);
        if (!out.trim().equals("1 2 3 4 5")) {
            different = true;
        }
    }
    if (different) passed++;

    total++;
    boolean allPresent = true;
    for (int i = 0; i < 5; i++) {
        String out = run(null);
        var numbers = new java.util.HashSet<Integer>();
        for (String part : out.trim().split("\\s+")) {
            try {
                numbers.add(Integer.parseInt(part));
            } catch (NumberFormatException e) {}
        }
        if (!numbers.containsAll(java.util.Set.of(1, 2, 3, 4, 5))) {
            allPresent = false;
        }
    }
    if (allPresent) passed++;

    IO.println("Exercise 08: " + passed + "/" + total + " passed");
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
    if (!exited) { process.destroyForcibly(); return ""; }
    return output;
}
