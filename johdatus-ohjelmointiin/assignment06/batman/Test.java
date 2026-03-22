import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

void main() throws Exception {
    int passed = 0;
    int total = 0;

    // Compile all sources first
    total++;
    var compile = new ProcessBuilder("javac",
        "fi/tuni/tamk/tiko/student/util/Math.java",
        "fi/tuni/tamk/tiko/student/util/Arrays.java",
        "fi/tuni/tamk/tiko/student/util/MyConsole.java",
        "fi/tuni/tamk/tiko/student/Main.java");
    compile.redirectErrorStream(true);
    var cp = compile.start();
    var co = new String(cp.getInputStream().readAllBytes());
    cp.waitFor();
    if (cp.exitValue() != 0) {
        IO.println("  FAIL: compilation failed");
        IO.println(co);
        IO.println("Exercise batman: 0/0 passed");
        return;
    }
    IO.println("  PASS: compilation successful");
    passed++;

    // Test 2: Math.getRandom range 1-10
    total++;
    var result2 = compileAndRun("""
        import fi.tuni.tamk.tiko.student.util.Math;
        public class TempTest {
            public static void main(String[] args) {
                boolean allInRange = true;
                for (int i = 0; i < 1000; i++) {
                    int r = Math.getRandom(1, 10);
                    if (r < 1 || r > 10) allInRange = false;
                }
                System.out.println(allInRange);
            }
        }
        """);
    if (result2.trim().equals("true")) {
        IO.println("  PASS: Math.getRandom(1,10) stays in range over 1000 calls");
        passed++;
    } else {
        IO.println("  FAIL: Math.getRandom(1,10) out of range, got: " + result2.trim());
    }

    // Test 3: Math.getRandom(1,1) always returns 1
    total++;
    var result3 = compileAndRun("""
        import fi.tuni.tamk.tiko.student.util.Math;
        public class TempTest {
            public static void main(String[] args) {
                boolean allOne = true;
                for (int i = 0; i < 100; i++) {
                    if (Math.getRandom(1, 1) != 1) allOne = false;
                }
                System.out.println(allOne);
            }
        }
        """);
    if (result3.trim().equals("true")) {
        IO.println("  PASS: Math.getRandom(1,1) always returns 1");
        passed++;
    } else {
        IO.println("  FAIL: Math.getRandom(1,1) did not always return 1");
    }

    // Test 4: Arrays.toIntArray
    total++;
    var result4 = compileAndRun("""
        import fi.tuni.tamk.tiko.student.util.Arrays;
        public class TempTest {
            public static void main(String[] args) {
                int[] arr = Arrays.toIntArray(new String[]{"1", "2", "3"});
                System.out.println(arr[0] + " " + arr[1] + " " + arr[2] + " " + arr.length);
            }
        }
        """);
    if (result4.trim().equals("1 2 3 3")) {
        IO.println("  PASS: Arrays.toIntArray converts correctly");
        passed++;
    } else {
        IO.println("  FAIL: Arrays.toIntArray expected '1 2 3 3', got: " + result4.trim());
    }

    // Test 5: Arrays.contains true
    total++;
    var result5 = compileAndRun("""
        import fi.tuni.tamk.tiko.student.util.Arrays;
        public class TempTest {
            public static void main(String[] args) {
                int[] arr = {1, 2, 3, 4, 5};
                System.out.println(Arrays.contains(3, arr));
            }
        }
        """);
    if (result5.trim().equals("true")) {
        IO.println("  PASS: Arrays.contains finds existing value");
        passed++;
    } else {
        IO.println("  FAIL: Arrays.contains expected true, got: " + result5.trim());
    }

    // Test 6: Arrays.contains false
    total++;
    var result6 = compileAndRun("""
        import fi.tuni.tamk.tiko.student.util.Arrays;
        public class TempTest {
            public static void main(String[] args) {
                int[] arr = {1, 2, 3, 4, 5};
                System.out.println(Arrays.contains(9, arr));
            }
        }
        """);
    if (result6.trim().equals("false")) {
        IO.println("  PASS: Arrays.contains returns false for missing value");
        passed++;
    } else {
        IO.println("  FAIL: Arrays.contains expected false, got: " + result6.trim());
    }

    // Test 7: Arrays.containsSameValues with overlap
    total++;
    var result7 = compileAndRun("""
        import fi.tuni.tamk.tiko.student.util.Arrays;
        public class TempTest {
            public static void main(String[] args) {
                int[] a = {1, 2, 3, 4, 5, 6, 20};
                int[] b = {1, 20, 21, 22, 23, 24, 25};
                System.out.println(Arrays.containsSameValues(a, b));
            }
        }
        """);
    if (result7.trim().equals("2")) {
        IO.println("  PASS: Arrays.containsSameValues returns 2 for two shared values");
        passed++;
    } else {
        IO.println("  FAIL: Arrays.containsSameValues expected 2, got: " + result7.trim());
    }

    // Test 8: Arrays.containsSameValues no overlap
    total++;
    var result8 = compileAndRun("""
        import fi.tuni.tamk.tiko.student.util.Arrays;
        public class TempTest {
            public static void main(String[] args) {
                int[] a = {1, 2, 3};
                int[] b = {4, 5, 6};
                System.out.println(Arrays.containsSameValues(a, b));
            }
        }
        """);
    if (result8.trim().equals("0")) {
        IO.println("  PASS: Arrays.containsSameValues returns 0 for no overlap");
        passed++;
    } else {
        IO.println("  FAIL: Arrays.containsSameValues expected 0, got: " + result8.trim());
    }

    // Test 9: Arrays.sort
    total++;
    var result9 = compileAndRun("""
        import fi.tuni.tamk.tiko.student.util.Arrays;
        public class TempTest {
            public static void main(String[] args) {
                int[] arr = {5, 3, 1, 4, 2};
                int[] sorted = Arrays.sort(arr);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < sorted.length; i++) {
                    if (i > 0) sb.append(" ");
                    sb.append(sorted[i]);
                }
                System.out.println(sb.toString());
                // verify original unchanged
                System.out.println(arr[0]);
            }
        }
        """);
    var lines9 = result9.trim().split("\n");
    if (lines9.length >= 2 && lines9[0].trim().equals("1 2 3 4 5") && lines9[1].trim().equals("5")) {
        IO.println("  PASS: Arrays.sort returns sorted copy, original unchanged");
        passed++;
    } else {
        IO.println("  FAIL: Arrays.sort expected '1 2 3 4 5' and original[0]=5, got: " + result9.trim());
    }

    // Test 10: Arrays.removeIndex
    total++;
    var result10 = compileAndRun("""
        import fi.tuni.tamk.tiko.student.util.Arrays;
        public class TempTest {
            public static void main(String[] args) {
                int[] arr = {10, 20, 30, 40, 50};
                int[] removed = Arrays.removeIndex(arr, 2);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < removed.length; i++) {
                    if (i > 0) sb.append(" ");
                    sb.append(removed[i]);
                }
                System.out.println(sb.toString());
                System.out.println(removed.length);
            }
        }
        """);
    var lines10 = result10.trim().split("\n");
    if (lines10.length >= 2 && lines10[0].trim().equals("10 20 40 50") && lines10[1].trim().equals("4")) {
        IO.println("  PASS: Arrays.removeIndex removes correct element");
        passed++;
    } else {
        IO.println("  FAIL: Arrays.removeIndex expected '10 20 40 50' length 4, got: " + result10.trim());
    }

    // Test 11: Arrays.sort already sorted
    total++;
    var result11 = compileAndRun("""
        import fi.tuni.tamk.tiko.student.util.Arrays;
        public class TempTest {
            public static void main(String[] args) {
                int[] arr = {1, 2, 3};
                int[] sorted = Arrays.sort(arr);
                System.out.println(sorted[0] + " " + sorted[1] + " " + sorted[2]);
            }
        }
        """);
    if (result11.trim().equals("1 2 3")) {
        IO.println("  PASS: Arrays.sort handles already sorted array");
        passed++;
    } else {
        IO.println("  FAIL: Arrays.sort already sorted expected '1 2 3', got: " + result11.trim());
    }

    // Test 12: Math.getRandom produces varied values
    total++;
    var result12 = compileAndRun("""
        import fi.tuni.tamk.tiko.student.util.Math;
        public class TempTest {
            public static void main(String[] args) {
                java.util.HashSet<Integer> seen = new java.util.HashSet<>();
                for (int i = 0; i < 1000; i++) {
                    seen.add(Math.getRandom(1, 10));
                }
                System.out.println(seen.size());
            }
        }
        """);
    int distinctValues = 0;
    try { distinctValues = Integer.parseInt(result12.trim()); } catch (Exception e) {}
    if (distinctValues >= 5) {
        IO.println("  PASS: Math.getRandom produces at least 5 distinct values in 1-10");
        passed++;
    } else {
        IO.println("  FAIL: Math.getRandom produced only " + distinctValues + " distinct values");
    }

    // Test 13: Arrays.toIntArray empty array
    total++;
    var result13 = compileAndRun("""
        import fi.tuni.tamk.tiko.student.util.Arrays;
        public class TempTest {
            public static void main(String[] args) {
                int[] arr = Arrays.toIntArray(new String[]{});
                System.out.println(arr.length);
            }
        }
        """);
    if (result13.trim().equals("0")) {
        IO.println("  PASS: Arrays.toIntArray handles empty array");
        passed++;
    } else {
        IO.println("  FAIL: Arrays.toIntArray empty expected length 0, got: " + result13.trim());
    }

    // Test 14: Arrays.contains on first and last element
    total++;
    var result14 = compileAndRun("""
        import fi.tuni.tamk.tiko.student.util.Arrays;
        public class TempTest {
            public static void main(String[] args) {
                int[] arr = {10, 20, 30};
                System.out.println(Arrays.contains(10, arr));
                System.out.println(Arrays.contains(30, arr));
                System.out.println(Arrays.contains(10, new int[]{}));
            }
        }
        """);
    var lines14 = result14.trim().split("\n");
    if (lines14.length >= 3
            && lines14[0].trim().equals("true")
            && lines14[1].trim().equals("true")
            && lines14[2].trim().equals("false")) {
        IO.println("  PASS: Arrays.contains first, last, and empty array");
        passed++;
    } else {
        IO.println("  FAIL: Arrays.contains edge cases, got: " + result14.trim());
    }

    // Test 15: Arrays.containsSameValues identical arrays
    total++;
    var result15 = compileAndRun("""
        import fi.tuni.tamk.tiko.student.util.Arrays;
        public class TempTest {
            public static void main(String[] args) {
                int[] a = {1, 2, 3};
                int[] b = {1, 2, 3};
                System.out.println(Arrays.containsSameValues(a, b));
            }
        }
        """);
    if (result15.trim().equals("3")) {
        IO.println("  PASS: Arrays.containsSameValues returns 3 for identical arrays");
        passed++;
    } else {
        IO.println("  FAIL: Arrays.containsSameValues identical expected 3, got: " + result15.trim());
    }

    // Test 16: Arrays.sort with duplicates and reverse order
    total++;
    var result16 = compileAndRun("""
        import fi.tuni.tamk.tiko.student.util.Arrays;
        public class TempTest {
            public static void main(String[] args) {
                int[] arr = {5, 3, 3, 1, 5};
                int[] sorted = Arrays.sort(arr);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < sorted.length; i++) {
                    if (i > 0) sb.append(" ");
                    sb.append(sorted[i]);
                }
                System.out.println(sb.toString());
            }
        }
        """);
    if (result16.trim().equals("1 3 3 5 5")) {
        IO.println("  PASS: Arrays.sort handles duplicates");
        passed++;
    } else {
        IO.println("  FAIL: Arrays.sort duplicates expected '1 3 3 5 5', got: " + result16.trim());
    }

    // Test 17: Arrays.removeIndex first and last element
    total++;
    var result17 = compileAndRun("""
        import fi.tuni.tamk.tiko.student.util.Arrays;
        public class TempTest {
            public static void main(String[] args) {
                int[] arr = {10, 20, 30};
                int[] r1 = Arrays.removeIndex(arr, 0);
                int[] r2 = Arrays.removeIndex(arr, 2);
                System.out.println(r1[0] + " " + r1[1]);
                System.out.println(r2[0] + " " + r2[1]);
            }
        }
        """);
    var lines17 = result17.trim().split("\n");
    if (lines17.length >= 2
            && lines17[0].trim().equals("20 30")
            && lines17[1].trim().equals("10 20")) {
        IO.println("  PASS: Arrays.removeIndex first and last element");
        passed++;
    } else {
        IO.println("  FAIL: Arrays.removeIndex first/last, got: " + result17.trim());
    }

    // Test 18: calculateLotto returns 7 unique values in range 1-40
    total++;
    var result18 = compileAndRun("""
        import fi.tuni.tamk.tiko.student.Main;
        import fi.tuni.tamk.tiko.student.util.Arrays;
        public class TempTest {
            public static void main(String[] args) {
                int[] lotto = Main.calculateLotto();
                boolean correctLength = lotto.length == 7;
                boolean allInRange = true;
                boolean allUnique = true;
                for (int i = 0; i < lotto.length; i++) {
                    if (lotto[i] < 1 || lotto[i] > 40) allInRange = false;
                    for (int j = i + 1; j < lotto.length; j++) {
                        if (lotto[i] == lotto[j]) allUnique = false;
                    }
                }
                System.out.println(correctLength + " " + allInRange + " " + allUnique);
            }
        }
        """);
    if (result18.trim().equals("true true true")) {
        IO.println("  PASS: calculateLotto returns 7 unique values in range 1-40");
        passed++;
    } else {
        IO.println("  FAIL: calculateLotto expected 'true true true', got: " + result18.trim());
    }

    // Test 19: calculateLotto produces varied results
    total++;
    var result19 = compileAndRun("""
        import fi.tuni.tamk.tiko.student.Main;
        public class TempTest {
            public static void main(String[] args) {
                int[] first = Main.calculateLotto();
                boolean different = false;
                for (int attempt = 0; attempt < 100; attempt++) {
                    int[] next = Main.calculateLotto();
                    for (int i = 0; i < first.length; i++) {
                        if (first[i] != next[i]) { different = true; break; }
                    }
                    if (different) break;
                }
                System.out.println(different);
            }
        }
        """);
    if (result19.trim().equals("true")) {
        IO.println("  PASS: calculateLotto produces varied results");
        passed++;
    } else {
        IO.println("  FAIL: calculateLotto always returns same values");
    }

    // Test 20: Math.getRandom max value is reachable
    total++;
    var result20 = compileAndRun("""
        import fi.tuni.tamk.tiko.student.util.Math;
        public class TempTest {
            public static void main(String[] args) {
                boolean seenMax = false;
                for (int i = 0; i < 10000; i++) {
                    if (Math.getRandom(1, 3) == 3) { seenMax = true; break; }
                }
                System.out.println(seenMax);
            }
        }
        """);
    if (result20.trim().equals("true")) {
        IO.println("  PASS: Math.getRandom max value is reachable");
        passed++;
    } else {
        IO.println("  FAIL: Math.getRandom never returned max in 10000 calls");
    }

    // Test 21: Arrays.containsSameValues different-length arrays
    total++;
    var result21 = compileAndRun("""
        import fi.tuni.tamk.tiko.student.util.Arrays;
        public class TempTest {
            public static void main(String[] args) {
                int[] a = {1, 2};
                int[] b = {2, 3, 4, 5};
                System.out.println(Arrays.containsSameValues(a, b));
            }
        }
        """);
    if (result21.trim().equals("1")) {
        IO.println("  PASS: Arrays.containsSameValues works with different-length arrays");
        passed++;
    } else {
        IO.println("  FAIL: containsSameValues different lengths expected 1, got: " + result21.trim());
    }

    // Test 22: Arrays.sort single element
    total++;
    var result22 = compileAndRun("""
        import fi.tuni.tamk.tiko.student.util.Arrays;
        public class TempTest {
            public static void main(String[] args) {
                int[] sorted = Arrays.sort(new int[]{42});
                System.out.println(sorted[0] + " " + sorted.length);
            }
        }
        """);
    if (result22.trim().equals("42 1")) {
        IO.println("  PASS: Arrays.sort single element");
        passed++;
    } else {
        IO.println("  FAIL: Arrays.sort single element expected '42 1', got: " + result22.trim());
    }

    // Test 23: Arrays.sort reverse-sorted input
    total++;
    var result23 = compileAndRun("""
        import fi.tuni.tamk.tiko.student.util.Arrays;
        public class TempTest {
            public static void main(String[] args) {
                int[] sorted = Arrays.sort(new int[]{5, 4, 3, 2, 1});
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < sorted.length; i++) {
                    if (i > 0) sb.append(" ");
                    sb.append(sorted[i]);
                }
                System.out.println(sb.toString());
            }
        }
        """);
    if (result23.trim().equals("1 2 3 4 5")) {
        IO.println("  PASS: Arrays.sort reverse-sorted input");
        passed++;
    } else {
        IO.println("  FAIL: Arrays.sort reverse expected '1 2 3 4 5', got: " + result23.trim());
    }

    // Test 24: Arrays.removeIndex single-element array
    total++;
    var result24 = compileAndRun("""
        import fi.tuni.tamk.tiko.student.util.Arrays;
        public class TempTest {
            public static void main(String[] args) {
                int[] result = Arrays.removeIndex(new int[]{99}, 0);
                System.out.println(result.length);
            }
        }
        """);
    if (result24.trim().equals("0")) {
        IO.println("  PASS: Arrays.removeIndex single-element array");
        passed++;
    } else {
        IO.println("  FAIL: Arrays.removeIndex single expected length 0, got: " + result24.trim());
    }

    // Test 25: calculateLotto uniqueness over multiple runs
    total++;
    var result25 = compileAndRun("""
        import fi.tuni.tamk.tiko.student.Main;
        public class TempTest {
            public static void main(String[] args) {
                boolean allValid = true;
                for (int run = 0; run < 50; run++) {
                    int[] lotto = Main.calculateLotto();
                    if (lotto.length != 7) { allValid = false; break; }
                    for (int i = 0; i < lotto.length; i++) {
                        if (lotto[i] < 1 || lotto[i] > 40) { allValid = false; break; }
                        for (int j = i + 1; j < lotto.length; j++) {
                            if (lotto[i] == lotto[j]) { allValid = false; break; }
                        }
                        if (!allValid) break;
                    }
                    if (!allValid) break;
                }
                System.out.println(allValid);
            }
        }
        """);
    if (result25.trim().equals("true")) {
        IO.println("  PASS: calculateLotto valid over 50 runs");
        passed++;
    } else {
        IO.println("  FAIL: calculateLotto produced invalid result in 50 runs");
    }

    // Test 26: Main with args outputs incremental best-of results
    total++;
    var result26 = compileAndRunWithArgs(
        "fi.tuni.tamk.tiko.student.Main",
        "1", "2", "3", "4", "5", "6", "7");
    boolean hasGot1 = result26.contains("Got 1 right!");
    boolean hasGot7 = result26.contains("Got 7 right!");
    boolean hasTook = result26.contains("Took");
    boolean hasYears = result26.contains("years");
    boolean hasWon = result26.contains("You won!");
    if (hasGot1 && hasGot7 && hasTook && hasYears && hasWon) {
        IO.println("  PASS: Main outputs incremental best-of with Took/years and You won!");
        passed++;
    } else {
        IO.println("  FAIL: Main expected 'Got 1 right!', 'Got 7 right!', 'Took', 'years', 'You won!', got first line: "
            + result26.trim().lines().findFirst().orElse(""));
    }

    // Cleanup
    Files.deleteIfExists(Path.of("TempTest.java"));
    Files.deleteIfExists(Path.of("TempTest.class"));

    IO.println("Exercise batman: " + passed + "/" + total + " passed");
}

String compileAndRunWithArgs(String className, String... args) throws Exception {
    var cmd = new java.util.ArrayList<String>();
    cmd.add("java");
    cmd.add(className);
    for (var a : args) cmd.add(a);
    var pb = new ProcessBuilder(cmd);
    pb.redirectErrorStream(true);
    var process = pb.start();
    process.getOutputStream().close();
    var output = new String(process.getInputStream().readAllBytes());
    boolean exited = process.waitFor(60, TimeUnit.SECONDS);
    if (!exited) {
        process.destroyForcibly();
        return "TIMEOUT";
    }
    return output;
}

String compileAndRun(String code) throws Exception {
    Files.writeString(Path.of("TempTest.java"), code);

    var comp = new ProcessBuilder("javac", "TempTest.java");
    comp.redirectErrorStream(true);
    var p1 = comp.start();
    var compOut = new String(p1.getInputStream().readAllBytes());
    p1.waitFor();
    if (p1.exitValue() != 0) {
        return "COMPILE_ERROR: " + compOut;
    }

    var run = new ProcessBuilder("java", "TempTest");
    run.redirectErrorStream(true);
    var p2 = run.start();
    var output = new String(p2.getInputStream().readAllBytes());
    boolean exited = p2.waitFor(10, TimeUnit.SECONDS);
    if (!exited) {
        p2.destroyForcibly();
        return "TIMEOUT";
    }
    return output;
}
