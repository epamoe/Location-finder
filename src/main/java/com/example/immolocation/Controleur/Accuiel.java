package com.example.immolocation.Controleur;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Accuiel {

    @GetMapping(value="/home")
    public String accueil()
    {
        return "Accueil";
    }
}
