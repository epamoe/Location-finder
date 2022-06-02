package com.example.immolocation.Controleur;
import com.example.immolocation.Model.Propriete;
import com.example.immolocation.Service.IBailleurServices;
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

    //ceci es temporaire**********************faudra remplacer par les services du bailleur***************
    @Autowired
    IBailleurServices ibailleurServices;

    private final Long Id_BailleurConnecter=1L;

    //********************************************************


    @GetMapping("/AjouterPropriete")
    public String formulairePropriete(Model model){
        model.addAttribute("propriete",new Propriete());
        return "Bailleur/AjouterPropriete";
    }

    //regler le probleme de date en bd**********************************************************************************

    @PostMapping("/GestionPropriete")
    public String Save(Model model,Propriete propriete){
        model.addAttribute("propriete",new Propriete());
        iProprieteServices.ajouterProprieter(propriete,ibailleurServices.rechercherBailleurParId(Id_BailleurConnecter));
       /* List<Propriete> proprieteList=iProprieteServices.listProprieteparBailleur(ibailleurServices.rechercherBailleurParId(Id_BailleurConnecter));
        model.addAttribute("proprieteList",proprieteList);*/
        return "redirect:/GestionPropriete";
    }


    @GetMapping("/GestionPropriete")
    public String pageGestionPropriete(Model model){
        List<Propriete> proprieteList=iProprieteServices.listProprieteparBailleur(ibailleurServices.rechercherBailleurParId(Id_BailleurConnecter));
        model.addAttribute("proprieteList",proprieteList);
        return "Bailleur/GestionPropriete";
    }


    @RequestMapping("/delete")
    public String delete(Long id){
        iProprieteServices.supprimerPropriete(id);
        return "redirect:/GestionPropriete";
    }
}
