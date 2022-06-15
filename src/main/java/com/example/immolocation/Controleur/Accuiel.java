package com.example.immolocation.Controleur;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class Accuiel {

    @GetMapping(value="/")
    public String accueil1()
    {
        return "Accueil";
    }

    @GetMapping(value="/home")
    public String accueil()
    {
        return "Accueil";
    }


    @GetMapping("/authentification")
    public String authentification(Model model){

        return "Bailleur/AuthentificationBailleur";

    }

    @GetMapping("/Bailleur/AuthentificationBailleur")
    public String pageBailleur() {
        return
                "propriete/GestionProprietes";
    }

    @GetMapping("/login-error")
    public String login(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        String errorMessage = null;
        if (session != null) {
            AuthenticationException ex = (AuthenticationException) session
                    .getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
            if (ex != null) {
                errorMessage = ex.getMessage();
            }
        }
        model.addAttribute("errorMessage", errorMessage);
        return "Bailleur/AuthentificationBailleur";
    }
}


