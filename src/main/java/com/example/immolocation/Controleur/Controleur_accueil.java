package com.example.immolocation.Controleur;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controleur_accueil {

    @GetMapping(value="/Accueil")
    public String accueil()
    {

        return "Accueil";
    }

    @GetMapping(value="/")
    public String auth()
    {
        return "auth_test_bailleur";
    }
}
