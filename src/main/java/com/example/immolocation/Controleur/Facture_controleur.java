package com.example.immolocation.Controleur;

import com.example.immolocation.Dao.FactureRepository;
import com.example.immolocation.Dao.LocataireRepository;
import com.example.immolocation.Model.Facture;
import com.example.immolocation.Model.Locataire;
import com.example.immolocation.Service.ServiceFacture;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
public class Facture_controleur {
    @Autowired
    ServiceFacture serviceFacture;
    @Autowired
    LocataireRepository locataireRepository;
    @Autowired
       Locataire locataire;

    @GetMapping("/factureLocataire")
    public String factureloc() {
        return "/Locataire/Facture";
    }




    @PostMapping(value = "/form")
    public String facturer( @RequestParam int montant) {
         serviceFacture.attribuer_fact(locataire.getLogin(), montant);
         System.out.println(serviceFacture.Liste_de_facture(locataire.getLogin()));
        return "Accueil";
    }

}
