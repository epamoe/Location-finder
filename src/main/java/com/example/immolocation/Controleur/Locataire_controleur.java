package com.example.immolocation.Controleur;

import com.example.immolocation.Model.Locataire;
import com.example.immolocation.Model.Propriete;
import com.example.immolocation.Model.User;
import com.example.immolocation.Service.IBailleurServices;
import com.example.immolocation.Service.ILocataireServices;
import com.example.immolocation.Service.IProprieteServices;
import com.example.immolocation.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class  Locataire_controleur {
    @Autowired
    UserService service;
    @Autowired
    ILocataireServices iLocataireServices;

    @Autowired
    IBailleurServices iBailleurServices;

    @Autowired
    IProprieteServices iProprieteServices;

    @GetMapping("/Locataire/AuthentificationLocataire")
    public String authentificationlocataire() {
        return "/Locataire/AuthentificationLocataire";
    }

    @GetMapping("/locataire")
    public String locataire() {
        return "/Locataire/Locataire";
    }

    @GetMapping("/en")
    public String enre() {
        return "en_lo";
    }


    @PostMapping(value = "/val")
    public String ajouterUserRole(User user) {
        service.ajouterUtilsateurRole(user);
        return "Accueil";
    }


        @GetMapping("/AjouterLocataire")
        public String formulaireLocataire (Model model){
           /* model.addAttribute("locataire", new Locataire());
            List<Propriete> proprieteList = iProprieteServices.listProprieteparBailleur() */;
            return "AjouterLocataire";
        }
      /*  @PostMapping("/SaveProcessing1")
        public String SaveLocataire1 (Model model, Locataire locataire, String login){

  /*
   *//*  @GetMapping("/AjouterLocataire")
    public String formulaireLocataire(Model model){
        model.addAttribute("locataire",new Locataire());
        //List<Propriete> proprieteList= iProprieteServices.listProprieteparBailleur();
    return "AjouterLocataire";
    }*//* @PostMapping("/SaveProcessing")
    public String SaveLocataire(Model model, Locataire locataire){
>>>>>>> 15d4ac3189412932c2318b6a23d1c04d0dbe1eba

            model.addAttribute("Locatiare", new Locataire());

<<<<<<< HEAD
            iLocataireServices.addLocataire(locataire, iBailleurServices.rechercherBailleurParId(login), new Propriete());
            return "redirect:Bailleur/GestionPropriete";
        }
    }
=======
        iLocataireServices.addLocataire(locataire,iBailleurServices.rechercherBailleurParId(1L),new Propriete());
        return"redirect:Bailleur/GestionPropriete";
    }*/
}

