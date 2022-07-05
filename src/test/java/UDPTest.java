import network.udp.EchoClient;
import network.udp.EchoServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UDPTest {
    static EchoClient client;

    @BeforeAll
    public static void setup() {
        new EchoServer().start();
        client = new EchoClient();
    }

    @Test
    public void whenCanSendAndReceivePacket_thenCorrect() {
        String echo = client.sendEcho("hello server");
        assertEquals("hello server", echo);
        echo = client.sendEcho("server is working");
        assertNotEquals("hello server", echo);
    }

    @AfterAll
    public static void tearDown() {
        client.sendEcho("end");
        client.close();
    }
}
