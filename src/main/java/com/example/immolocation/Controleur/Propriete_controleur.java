package com.example.immolocation.Controleur;
import com.example.immolocation.Dao.BailleurRepository;
import com.example.immolocation.Dao.ProprieteRepository;
import com.example.immolocation.Model.Bailleur;
import com.example.immolocation.Model.Propriete;
import com.example.immolocation.Service.IProprieteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@Controller
public class Propriete_controleur {

    @Autowired
    IProprieteServices iProprieteServices;

    @Autowired
    ProprieteRepository proprieteRepository;
    //ceci es temporaire**********************faudra remplacer par les services du bailleur***************
    @Autowired
    BailleurRepository bailleurRepository;
    //********************************************************


    @GetMapping("/AjouterPropriete")
    public String formulairePropriete(Model model){
        model.addAttribute("propriete",new Propriete());
        return "Bailleur/AjouterPropriete";
    }

    //regler le probleme de date en bd**********************************************************************************
    @PostMapping("/SaveProcessing")
    public String SavePropriete(Model model,Propriete propriete){
        model.addAttribute("Propriete",new Propriete());
        iProprieteServices.ajouterProprieter(propriete,bailleurRepository.findById(1L).get());
        return"redirect:Bailleur/GestionPropriete";
    }


    @RequestMapping("/GestionPropriete")
    public String pageGestionPropriete(Model model){
        List<Propriete> proprieteList=iProprieteServices.listProprieteparBailleur(bailleurRepository.findById(1L).get());
        model.addAttribute("proprieteList",proprieteList);
        return"Bailleur/GestionPropriete";
    }


    @RequestMapping("/delete")
    public String delete(Long id){
        iProprieteServices.supprimerPropriete(id);
        return "redirect:Bailleur/GestionPropriete";
    }
}
