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
<<<<<<< HEAD

        BCryptPasswordEncoder crypte= new BCryptPasswordEncoder();
        String mot_de_passe_code= crypte.encode("123");
        System.out.println(mot_de_passe_code);
=======
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
>>>>>>> 15d4ac3189412932c2318b6a23d1c04d0dbe1eba
    }

}
