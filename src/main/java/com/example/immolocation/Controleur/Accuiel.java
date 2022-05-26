package com.example.immolocation.Controleur;

import com.example.immolocation.Dao.LocatireRepository;
import com.example.immolocation.Service.ServiceFacture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Accuiel {

    @GetMapping(value="/home")
    public String accueil()
    {
        return "Accueil";
    }
}
