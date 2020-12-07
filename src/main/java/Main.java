import java.io.*;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        final var validPaths = List.of("/index.html", "/spring.svg", "/spring.png", "/resources.html", "/styles.css", "/app.js", "/links.html", "/forms.html", "/classic.html", "/events.html", "/events.js");
        final ExecutorService threadPool = Executors.newFixedThreadPool(64);
        final var server = new Server(validPaths);
        try {
            server.runServer(9999);

            while (true) {
                try (
                        final var socket = server.getServerSocket().accept();
                ) {
                    Runnable handleConnection = () -> {
                        try {
                            server.handleConnection(socket);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    };
                    threadPool.submit(handleConnection);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


