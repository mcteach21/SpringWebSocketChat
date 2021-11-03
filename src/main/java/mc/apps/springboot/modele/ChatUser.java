package mc.apps.springboot.modele;

import java.security.Principal;

public class ChatUser implements Principal {
    private String name;
    public ChatUser(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
