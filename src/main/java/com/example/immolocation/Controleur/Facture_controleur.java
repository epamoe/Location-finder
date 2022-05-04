package com.example.immolocation.Controleur;

import com.example.immolocation.Dao.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class Facture_controleur {
    @Autowired
    FactureRepository Repofacture;
}
