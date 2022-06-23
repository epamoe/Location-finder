package com.example.immolocation.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.transaction.Status;///////////////////////
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Message {
 
    private TypeMessage Type;
    private String content;
    private String sender;

    public enum TypeMessage {
        MESSAGE,
        JOIN,
        LEAVE,
        
    }

    public TypeMessage getType() {
        return Type;
    }
    public void setType(TypeMessage type) {
        this.Type = type;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getSender() {
        return sender;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
}
