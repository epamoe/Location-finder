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
 private String message ;
 private String fromLogin;
}
