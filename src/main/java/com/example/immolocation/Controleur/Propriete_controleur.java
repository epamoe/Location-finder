package com.example.immolocation.Controleur;

import com.example.immolocation.Dao.ProprieteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class Propriete_controleur {
    @Autowired
    ProprieteRepository Repopropriete;
}
