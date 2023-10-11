package com.kugler.chat.chat;

import lombok.*;

import java.awt.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {

    private String content; // obsah zprávy
    private String sender; // odesilatel
    private MessageType type;
}
