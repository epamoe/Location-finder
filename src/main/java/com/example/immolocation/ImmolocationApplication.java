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

        BCryptPasswordEncoder crypte= new BCryptPasswordEncoder();
        String mot_de_passe_code= crypte.encode("123");
        System.out.println(mot_de_passe_code);
    }

}
