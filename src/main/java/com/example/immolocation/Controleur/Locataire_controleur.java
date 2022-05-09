package com.example.immolocation.Controleur;

import com.example.immolocation.Dao.LocatireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Locataire_controleur {
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
}
