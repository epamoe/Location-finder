package com.example.immolocation.Controleur;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Accuiel {

    @GetMapping(value="/home")
    public String accueil()
    {
        return "Accueil";
    }

    @GetMapping("/authentification")
    public String authentification(Model model){

        return "propriete/GestionProprietes";

    }
    @GetMapping("/Bailleur/AuthentificationBailleur\"")
    public String log(){
        return "propriete/GestionProprietes";
    }



}
