package com.kugler.chat.config;

import com.kugler.chat.chat.ChatMessage;
import com.kugler.chat.chat.MessageType;
import jakarta.websocket.Session;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@RequiredArgsConstructor
@Slf4j
public class WebSocketEvenListener {
private final SimpMessageSendingOperations messageTemplate;

    @EventListener // odpojeni od chatu
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {

    StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage()); // zabalí zprávu
    String username =(String) headerAccessor.getSessionAttributes().get("username"); // ziskani atriburu username
    if (username != null) {
        log.info("User disconnected");
        var chatMessage = ChatMessage.builder().type(MessageType.LEAVE).sender(username).build();

        messageTemplate.convertAndSend("/topic/public",chatMessage); // odeslani na zpravy o odpojeni na cílový kanál


}
}

}