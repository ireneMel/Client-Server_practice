package network.tcp;


import lombok.SneakyThrows;

import java.io.IOException;
import java.net.ServerSocket;

public class GreetServer implements Runnable {
    private ServerSocket serverSocket;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
//        clientSocket = serverSocket.accept(); //чекає 1 клієнта і з ним працює
        for (int i = 0; i < 2; i++) {
            new ClientHandler(serverSocket.accept()).start();
        }
    }

    @SneakyThrows
    @Override
    public void run() {
        GreetServer server = new GreetServer();
        server.start(6666);
    }
}
