package com.example.immolocation.Controleur;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Bailleur_controlleur {

    @GetMapping("/Ajouter_locataire")
    public String ajouter_locataire() {
        return "/Bailleur/AjoutLocataire";
    }

    @GetMapping("/Bailleur/AuthentificationBailleur")
    public String authentification_locataire() {
        return "/Bailleur/AjoutLocataire";
    }

    @GetMapping("/Bailleur")
    public String bailleur() {
        return "/Bailleur/Bailleur";
    }

    @GetMapping("/h")
    public String pro()
    {
        return "/propriete/h";
    }
}
