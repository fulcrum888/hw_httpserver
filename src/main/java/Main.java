import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final var validPaths = List.of("/index.html", "/spring.svg", "/spring.png", "/resources.html", "/styles.css", "/app.js", "/links.html", "/forms.html", "/classic.html", "/events.html", "/events.js");

        final var server = new Server(validPaths);
        try {
            server.runServer(9999, 64);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


