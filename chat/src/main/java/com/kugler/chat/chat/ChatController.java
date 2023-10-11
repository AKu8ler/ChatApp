package com.kugler.chat.chat;

import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMassega) {
        return chatMassega;
    }

    //prida uživatele do chatu a získa jeho jmeno
    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccesor){
        headerAccesor.getSessionAttributes().put("username",chatMessage.getSender());
        return chatMessage;

    }
}
