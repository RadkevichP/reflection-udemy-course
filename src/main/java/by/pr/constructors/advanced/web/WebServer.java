package by.pr.constructors.advanced.web;

import by.pr.constructors.advanced.ServerConfiguration;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Pavel Radkevich
 * @since 4.03.23
 */
public class WebServer {

    public void startServer() throws IOException {
        ServerConfiguration configuration = ServerConfiguration.getInstance();
        HttpServer httpServer = HttpServer.create(configuration.getServerAddress(), 0);

        httpServer.createContext("/greeting").setHandler(exchange -> {
            //String responseMessage = configuration.getGreetingMessage();
            String responseMessage = """
                    <!DOCTYPE html>
                    <html>
                    <body>
                                        
                    <h1>My First Heading</h1>
                                        
                    <p>My first paragraph.</p>
                                        
                    </body>
                    </html>
                    """;

            exchange.sendResponseHeaders(200, responseMessage.length());

            OutputStream responseBody = exchange.getResponseBody();
            responseBody.write(responseMessage.getBytes());
            responseBody.flush();
            responseBody.close();
        });

        System.out.println(String.format("Starting server on address %s:%d",
                configuration.getServerAddress().getHostName(),
                configuration.getServerAddress().getPort()));

        httpServer.start();
    }
}
