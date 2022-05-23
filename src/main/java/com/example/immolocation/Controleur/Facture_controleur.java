package com.example.immolocation.Controleur;

import com.example.immolocation.Dao.FactureRepository;
import com.example.immolocation.Model.Facture;
import com.example.immolocation.Service.ServiceFacture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class Facture_controleur {
    @Autowired
     ServiceFacture serviceFacture;

    @GetMapping("/moi")
    public String fomr_fac(){
        return "fac_form";
    }

    @PostMapping(value ="/form")
    public String facturer(@RequestParam int id_locataire, @RequestParam int montant ) {
        serviceFacture.attribuer_fact(id_locataire,montant);
        //  System.out.println(serviceFacture.Liste_de_facture(id_locataire));
        return "Accueil";
    }

}
