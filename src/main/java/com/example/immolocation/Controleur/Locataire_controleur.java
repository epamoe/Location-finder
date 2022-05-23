package com.example.immolocation.Controleur;

import com.example.immolocation.Dao.LocatireRepository;
import com.example.immolocation.Model.User;
import com.example.immolocation.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class  Locataire_controleur {
    @Autowired
    UserService service;
    @Autowired
    LocatireRepository repoLocataire;

    @GetMapping("/Locataire/AuthentificationLocataire")
    public String authentificationlocataire()
    {
        return "/Locataire/AuthentificationLocataire";
    }

    @GetMapping("/locataire")
    public String locataire()
    {
        return "/Locataire/Locataire";
    }

    @GetMapping("/en")
    public String enre(){
        return "en_lo";
    }


    @PostMapping(value = "/val")
    public String ajouterUserRole(User user) {
        service.ajouterUtilsateurRole(user);
        return "Accueil";
    }



}
