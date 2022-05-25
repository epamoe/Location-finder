package com.example.immolocation.Controleur;

import com.example.immolocation.Dao.ProprieteRepository;
import com.example.immolocation.Model.Propriete;
import com.example.immolocation.Service.IProprieteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@Controller
public class Propriete_controleur {

    @Autowired
    IProprieteServices iProprieteServices;


    @RequestMapping("/propriete")
    public String Pagepropriete(){

        return "/propriete/propriete";
    }

    //***************************************client demande le formulaire ajout propriete********************************
    @GetMapping("/ajoutPropriete")
    public String PageAjout(){
        return "Bailleur/ajouterPropriete";
    }


    //*********************************traitement du formulaire******************************************************
    @PostMapping("/saveProcessing")
    public String saveProcessing(Propriete propriete,Model model){
        model.addAttribute("p",new Propriete());
        iProprieteServices.ajouterProprieter(propriete);
        return "/propriete/propriete";
    }


}

