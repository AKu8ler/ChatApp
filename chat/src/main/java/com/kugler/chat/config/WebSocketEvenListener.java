package com.kugler.chat.config;

import jakarta.websocket.Session;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@RequiredArgsConstructor
@Slf4j
public class WebSocketEvenListener {

    @EventListener // odpojeni od chatu
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        //TODO -- implement
    }
    StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
    String username =(String) headerAccessor.getSessionAttributes().get("username");
    if
}
