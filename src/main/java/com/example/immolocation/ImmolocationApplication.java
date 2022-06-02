package com.example.immolocation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class ImmolocationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImmolocationApplication.class, args);
        /*BCryptPasswordEncoder crypt= new BCryptPasswordEncoder();
        String mdp="aaaa";
        String mdpcrypte=crypt.encode(mdp);
        System.out.println(mdpcrypte);

        System.out.print("bonjour");
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        System.out.println(myDateObj);
*/
    }

}
