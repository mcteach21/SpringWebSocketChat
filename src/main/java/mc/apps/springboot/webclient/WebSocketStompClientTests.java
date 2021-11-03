package mc.apps.springboot.webclient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.web.socket.messaging.WebSocketStompClient;

public class WebSocketStompClientTests implements CommandLineRunner {
    String loggerServerQueueUrl="";

//    @Autowired
//    WebSocketStompClient webSocketStompClient;

    @Override
    public void run(String... args) throws Exception {
//        StompSessionHandler sessionHandler = new CustomStompSessionHandler();
//        StompSession stompSession = webSocketStompClient.connect(loggerServerQueueUrl, sessionHandler).get();
//
//        stompSession.send("topic/greetings", "Hello new user");
    }
}
