package com.example.immolocation.Controleur;

import com.example.immolocation.Model.Bailleur;
import com.example.immolocation.Model.User;
import com.example.immolocation.Service.IBailleurServices;
import com.example.immolocation.Service.IUserServices;
import com.example.immolocation.Service.ServiceFacture;
import com.example.immolocation.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Bailleur_controlleur {
    @Autowired
    ServiceFacture facture;

    @Autowired
    IBailleurServices iBailleurServices;

    @Autowired
    IUserServices iUserServices;
    /*
        @GetMapping("/Ajouter_locataire")
        public String ajouter_locataire() {
            return "/Bailleur/AjoutLocataire"        }

       /* @GetMapping("/Bailleur/AuthentificationBailleur")
        public String authentification_locataire() {
           // facture.avertissement_dette();
            return "/Bailleur/Bailleur";
        }

        @GetMapping("/h")
        public String pro()
        {
            return "/propriete";
        }
    */
    @GetMapping("/AjouterBailleur")
    public String AjouterBailleur(Model model){
        model.addAttribute("Bailleur",new Bailleur());
        return "Bailleur/AjouterBailleur";
    }
    @PostMapping("/SaveBailleurProcessing")
    public String save(Model model, Bailleur bailleur, User user){
        model.addAttribute("user",new User());
        model.addAttribute("Bailleur",new Bailleur());
        iBailleurServices.ajouterBailleur(bailleur);
        iUserServices.ajouterUtilsateurRoleBailleur(user);
        return "redirect:/Bailleur/AuthentificationBailleur";
    }
}
