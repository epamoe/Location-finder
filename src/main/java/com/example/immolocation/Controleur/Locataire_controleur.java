package com.example.immolocation.Controleur;

import com.example.immolocation.Dao.LocatireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Locataire_controleur {
    @Autowired
    LocatireRepository repoLocataire;
}
