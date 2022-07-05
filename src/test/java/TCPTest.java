import network.tcp.GreetClient;
import network.tcp.GreetServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

//socket would close by itself, but it is better to threads close manually

public class TCPTest {
    private static Thread serverThread;

    @BeforeAll
    static void init() {
        serverThread = new Thread(new GreetServer());
        serverThread.start();
    }

    @Test
    public void givenGreetingClient_whenServerRespondsWhenStarted_thenCorrect() throws IOException {
        GreetClient client = new GreetClient();
        client.startConnection("127.0.0.1", 6666);
        client.sendMessage("hello server");

        GreetClient client2 = new GreetClient();
        client2.startConnection("127.0.0.1", 6666);
        client2.sendMessage("hello server2");

        String response = client.readMessage();
        String response2 = client2.readMessage();
        assertEquals("hello client", response);
//        assertEquals("hello client", response2);
    }

    @AfterAll
    static void stop() throws InterruptedException {
       serverThread.join();
    }

}
