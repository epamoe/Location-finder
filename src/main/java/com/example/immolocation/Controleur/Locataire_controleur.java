package com.example.immolocation.Controleur;

import com.example.immolocation.Model.Locataire;
import com.example.immolocation.Model.Propriete;
import com.example.immolocation.Model.User;
import com.example.immolocation.Service.IBailleurServices;
import com.example.immolocation.Service.ILocataireServices;
import com.example.immolocation.Service.IProprieteServices;
import com.example.immolocation.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class  Locataire_controleur {
    @Autowired
    UserService service;
    @Autowired
    ILocataireServices iLocataireServices;

    @Autowired
    IBailleurServices iBailleurServices;

    @Autowired
    IProprieteServices iProprieteServices;

    private Long IdBailleurConnecter=1L;

    @GetMapping("/Locataire/AuthentificationLocataire")
    public String authentificationlocataire()
    {
        return "/Locataire/AuthentificationLocataire";
    }

    @GetMapping("/locataire")
    public String locataire()
    {
        return "/Locataire/Locataire";
    }

    @GetMapping("/en")
    public String enre(){
        return "en_lo";
    }


    @PostMapping(value = "/val")
    public String ajouterUserRole(User user) {
        service.ajouterUtilsateurRole(user);
        return "Accueil";
    }

   @GetMapping("/AjouterLocataire")
    public String formulaireLocataire(Model model){
        List<Propriete> proprieteList = iProprieteServices.listProprieteparBailleur(iBailleurServices.rechercherBailleurParId(1L));
        model.addAttribute("proprieteList",proprieteList);
        model.addAttribute("locataire",new Locataire());
        //List<Propriete> proprieteList= iProprieteServices.listProprieteparBailleur();
    return "Bailleur/AjouterLocataire";


    } @PostMapping("/SaveProcessing")
    public String SaveLocataire(Model model,String name, Locataire locataire){
       Propriete propriete= iProprieteServices.findByName(name);

        model.addAttribute("Locatiare",new Locataire());

        iLocataireServices.addLocataire(locataire,iBailleurServices.rechercherBailleurParId(this.IdBailleurConnecter),propriete);
        return"redirect:Bailleur/GestionPropriete";
    }

    @GetMapping("/GestionLocataire")
    public String Gestion(Model model){
       List<Locataire>locataireList= iLocataireServices.findByBailleur(iBailleurServices.rechercherBailleurParId(this.IdBailleurConnecter));
       model.addAttribute("locataireList",locataireList);

       return "Bailleur/GestionLocataire";
    }
}
