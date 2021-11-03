package mc.apps.springboot.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

//@Configuration
//@EnableWebSocketMessageBroker
public class WebSocketConfiguration { //extends AbstractWebSocketMessageBrokerConfigurer {

//
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
//
//        stompEndpointRegistry.addEndpoint("/ws")
//                .setHandshakeHandler(new CustomHandshakeHandler())
//                .withSockJS();
//
//    }
//
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry registry) {
//
//        registry.setApplicationDestinationPrefixes("/app");
//
//        registry.enableSimpleBroker("/message");
//
//    }
}