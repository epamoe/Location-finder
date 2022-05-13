package com.example.immolocation.Controleur;

import com.example.immolocation.Dao.ProprieteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Propriete_controleur {
    @Autowired
    ProprieteRepository Repopropriete;

    @GetMapping("Propriete/Proprietes")
    public String proprietes(){
        return "propriete/proprietes";
    }

}
