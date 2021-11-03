package mc.apps.springboot.controllers;

import mc.apps.springboot.modele.ChatMessage;
import mc.apps.springboot.modele.ChatUsersManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@Controller
public class WebSocketController {
    private static final Logger logger = LogManager.getLogger(WebSocketController.class);

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    private final ChatUsersManager chatUsersManager;
    public WebSocketController(ChatUsersManager chatUsersManager) {
        this.chatUsersManager = chatUsersManager;
    }

    @GetMapping("/stomp-websocket")
    public String getWebSocketBroadcast() {
        logger.info("WebSocketBroadcastController => getWebSocketBroadcast");
        return "stomp-websocket";
    }
    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @MessageMapping("/ws")
    @SendTo("/topic/messages")
    public ChatMessage send(SimpMessageHeaderAccessor sha, ChatMessage chatMessage) throws Exception {
        logger.info("  => send : "+chatMessage.getText()+" from : "+chatMessage.getFrom());
        simpMessagingTemplate.convertAndSendToUser(chatMessage.getFrom(), "/queue/messages", chatMessage.getText());
        return new ChatMessage(chatMessage.getFrom(), chatMessage.getText(), "ALL");
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/publicChat")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/publicChatUsers")
    public Set<String> addUser(@Payload ChatMessage chatMessage){
        this.chatUsersManager.addUser(chatMessage.getFrom(), "");
        return  this.chatUsersManager.getAllUsers();
    }
    @MessageMapping("/chat.removeUser")
    @SendTo("/topic/publicChatUsers")
    public Set<String> removeUser(@Payload ChatMessage chatMessage) {
        logger.info("removeUser : " + chatMessage.getFrom());
        this.chatUsersManager.removeUser(chatMessage.getFrom());

        logger.info("chatUsersManager - users  : " + this.chatUsersManager.getAllUsers());
        return  this.chatUsersManager.getAllUsers();
    }
}
