package network.tcp;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GreetServer server=new GreetServer();
        server.start(6666);
    }
}
