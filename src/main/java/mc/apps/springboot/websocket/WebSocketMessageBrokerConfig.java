package mc.apps.springboot.websocket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketMessageBrokerConfig implements WebSocketMessageBrokerConfigurer {
    private static final Logger logger = LogManager.getLogger(WebSocketMessageBrokerConfig.class);


    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        /*
        Topics – common conversations or chat topics open to any client or user
        Queues – reserved for specific users and their current sessions
        Endpoints – generic endpoints
         */
        config.enableSimpleBroker("/topic", "/queue");
        /*
         * destinations (prefix) pour envoi et réception de messages clients
         * convention : 'topic' tous les abonnées pub-sub
         *              'queue' messages privés
         */

        // filtrer les destinations gérées par les méthodes annotées
        // avec @MessageMapping (dans Controller)
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        /*
        endpoint "/ws" pour établir connection.
        utilise SockJS (bibliothèque JavaScript) comme option de repli(fallback option ) pour les navigateurs qui ne gerent pas WebSocket.
         */
        stompEndpointRegistry.addEndpoint("/ws");
                //.setHandshakeHandler(new CustomHandshakeHandler())
                //.setAllowedOriginPatterns("*");
                //.withSockJS();
    }
}
