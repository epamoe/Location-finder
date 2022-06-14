package com.example.immolocation.Controleur;

import com.example.immolocation.Dao.LocataireRepository;
import com.example.immolocation.Model.Bailleur;
import com.example.immolocation.Model.Facture;
import com.example.immolocation.Model.Locataire;
import com.example.immolocation.Service.BailleurServiceImpl;
import com.example.immolocation.Service.ServiceFacture;
import com.example.immolocation.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@AllArgsConstructor
public class Bailleur_controlleur {
   @Autowired
   ServiceFacture facture;
   @Autowired
   Bailleur bailleur;
   @Autowired
   ServiceFacture serviceFacture;
   @Autowired
   LocataireRepository locataireRepository;
   @Autowired
    BailleurServiceImpl bailleurService;

  @Autowired
    Locataire locataire;
    @GetMapping("/Ajouter_locataire")
    public String ajouter_locataire() {
        return "/Bailleur/AjoutLocataire";
    }
   // @Secured(value="ROLE_BAILLEUR")

    @GetMapping("/Bailleur/AuthentificationBailleur")
    public String authentification_locataire(HttpServletRequest httpServletRequest) {
       // facture.avertissement_dette();
        HttpSession httpSession= httpServletRequest.getSession();
        SecurityContext securityContext= (SecurityContext)
        httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
        String login =securityContext.getAuthentication().getName();

        bailleur.setLogin("login");
        System.out.println(login);
        return "/Bailleur/Bailleur";
    }

    @GetMapping("/factureBailleur")
    public String facturebail(Model model){
        List<Locataire> locataires= new ArrayList<>();
        System.out.println(bailleur.getLogin());
        locataires.addAll(bailleurService.locataireselonloginBailleur(bailleur.getLogin()));
        model.addAttribute("listeDesLocataireDeBailleur",locataires);
        model.addAttribute("listeDesLocataireDeBailleur",locataires);
        System.out.println(locataires);
        return "/Bailleur/Facturer";
    }

    @RequestMapping("/locataire/facturer/{login}")
    public String proccederFacture(Model model, @PathVariable("login") String login) {

        Facture facture = serviceFacture.dernier_facture_loc(login);
        Locataire locataires = locataireRepository.chercher_loc_parLOGIN(login);
        model.addAttribute("listeDesLocataireDeBailleur", locataires);
        model.addAttribute("listeDesFactureDuLocTel", facture);
        locataire.setLogin(login);
        System.out.println(login);
        System.out.println(locataires);
        return "/Bailleur/fac_loc";
    }
}



