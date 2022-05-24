package com.example.immolocation.Controleur;

import com.example.immolocation.Service.ServiceFacture;
import com.example.immolocation.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Bailleur_controlleur {
    @Autowired
    ServiceFacture facture;

    @GetMapping("/Ajouter_locataire")
    public String ajouter_locataire() {
        return "/Bailleur/AjoutLocataire";
    }

    @GetMapping("/Bailleur/AuthentificationBailleur")
    public String authentification_locataire() {
       // facture.avertissement_dette();
        return "/Bailleur/Bailleur";
    }

    @GetMapping("/h")
    public String pro()
    {
        return "/propriete";
    }
}
