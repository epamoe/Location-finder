package com.example.immolocation.Controleur;

import com.example.immolocation.Model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {
    private SimpMessagingTemplate simpMessagingTemplate;
    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public Message sendMessage(@Payload Message message) {
        return message;
    }

    @MessageMapping("/message.addUser")
    @SendTo("/chatroom/public")
    public Message addUser(@Payload Message message, SimpMessageHeaderAccessor headerAccessor) {
      // ajout d'un nom d'utilisateur dans une session de web socket
        headerAccessor.getSessionAttributes().put("username", message.getSender());
        return message;
    }

}
