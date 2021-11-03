package mc.apps.springboot.modele;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class ChatMessage {

    private String from;
    private String text;
    private String recipient;
    private String time;

    private MessageType type;
    public enum MessageType {
        CHAT, JOIN, LEAVE
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public ChatMessage() {}
    public ChatMessage(String from, String text, String recipient) {
        this.from = from;
        this.text = text;
        this.recipient = recipient;

        this.time =LocalDateTime.now().format(formatter);
    }
}
