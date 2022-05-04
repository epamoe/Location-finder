package com.example.immolocation.Controleur;

import com.example.immolocation.Dao.BailleurRepository;
import com.example.immolocation.Model.Bailleur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Bailleur_controlleur {
    @Autowired
    BailleurRepository repoBailleur;

    @RequestMapping("/addBailleur")

    public String ajouter_Bailleur( Bailleur bailleur){
        repoBailleur.save(bailleur);
        return "auth_bailleur";
    }

}
