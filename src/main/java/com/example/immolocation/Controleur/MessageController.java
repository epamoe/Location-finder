package com.example.immolocation.Controleur;

import com.example.immolocation.Model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {
    private SimpMessagingTemplate simpMessagingTemplate;
    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    private Message recevoir_message_public(@Payload Message message){
          return message;
    }

    @MessageMapping("/message-prive")
    public Message recevoir_message_prive(@Payload Message message) {
        simpMessagingTemplate.convertAndSendToUser(message.getNom_recepteur(), "/private", message);
        return message;
    }
}
