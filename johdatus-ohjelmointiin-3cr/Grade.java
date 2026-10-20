import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Downloads the latest Check.java from the course site and runs it, so
// students get every fix without downloading anything again. Keep this file
// minimal: students download it only once.
public class Grade {
    static final String DEFAULT_URL =
        "https://pohjus.github.io/johdatus-ohjelmointiin-3cr/Check.java";
    static final Duration CONNECT_TIMEOUT = Duration.ofSeconds(10);
    static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(30);

    public static void main(String[] args) throws Exception {
        final var url = System.getProperty("check.url", DEFAULT_URL);
        final var dir = Files.createTempDirectory("grade-");
        final var checker = dir.resolve("Check.java");
        int exitCode;
        try {
            Files.writeString(checker, download(url));
            exitCode = run(checker, args);
        } catch (IOException e) {
            IO.println("ERROR: could not download the checker from " + url
                + " (" + Optional.ofNullable(e.getMessage())
                    .orElse(e.getClass().getSimpleName()) + ")");
            IO.println("Check your internet connection and try again.");
            exitCode = 1;
        } finally {
            Files.deleteIfExists(checker);
            Files.deleteIfExists(dir);
        }
        System.exit(exitCode);
    }

    // A captive portal or an error page would otherwise be run as Java and
    // fail with a confusing compiler error.
    static String download(String url) throws Exception {
        final var http = HttpClient.newBuilder()
            .followRedirects(HttpClient.Redirect.NORMAL)
            .connectTimeout(CONNECT_TIMEOUT)
            .build();
        final var request = HttpRequest.newBuilder(URI.create(url))
            .timeout(REQUEST_TIMEOUT)
            .build();
        final var response =
            http.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            throw new IOException("HTTP " + response.statusCode());
        }
        if (!response.body().contains("public class Check")) {
            throw new IOException("the downloaded file is not Check.java");
        }
        return response.body();
    }

    static int run(Path checker, String[] args) throws Exception {
        final var command = new ArrayList<>(List.of(javaCommand(),
            checker.toString()));
        command.addAll(List.of(args));
        return new ProcessBuilder(command).inheritIO().start().waitFor();
    }

    static String javaCommand() {
        return ProcessHandle.current().info().command().orElse("java");
    }
}
