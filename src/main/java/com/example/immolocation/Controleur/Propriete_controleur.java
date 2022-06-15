package com.example.immolocation.Controleur;
import com.example.immolocation.Dao.BailleurRepository;
import com.example.immolocation.Model.Bailleur;
import com.example.immolocation.Model.Image;
import com.example.immolocation.Model.Propriete;
import com.example.immolocation.Service.IBailleurServices;
import com.example.immolocation.Service.IProprieteServices;
import com.example.immolocation.Service.IUserServices;
import com.example.immolocation.Service.IimageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.immolocation.Controleur.Bailleur_controlleur;



@Controller
public class Propriete_controleur {

    private Long nId;
    @Autowired
    IProprieteServices iProprieteServices;

    @Autowired
    IBailleurServices ibailleurServices;

    @Autowired
    private IimageServices iimageServices;
    IUserServices iUserServices;



  private String userConnect;
  private  Bailleur bailleur;





    //********************************************************


    @GetMapping("/AjouterPropriete")
    public String formulairePropriete(Model model){
        model.addAttribute("bailleur",bailleur);
        model.addAttribute("propriete",new Propriete());
        return "Bailleur/AjouterPropriete";
    }

   /*
   apres l'envoie du formulaire d'ajout si la propriete est occupé par un locataire,
   on demande au bailleur de renseigner les info du
    locataire concerné dans le cas contraire on lui
    retourne la page de gestion de propriete
     */
    @PostMapping("/SavePropriete")
    public String Save(Model model,Propriete propriete,@RequestParam("etat") String etat){
        model.addAttribute("propriete",new Propriete());
        propriete=iProprieteServices.setDisponibilite(etat,propriete);
        iProprieteServices.ajouterProprieter(propriete,this.bailleur);
    return "redirect:/GestionPropriete";
    }

@GetMapping("/propriete")
public String propreite(){

        return "/propriete/proprietes";
}
    /*
    renvoie le dashbord de gestion de propriete,
     locataire et de facturation
     */
    @GetMapping("/GestionPropriete")
    public String pageGestionPropriete(Model model,Authentication authentication){
       this.bailleur=ibailleurServices.rechercherBailleur(authentication.getName());//recuperation du bailleur connecté
        List<Propriete> proprieteList=iProprieteServices.listProprieteparBailleur(this.bailleur);
        List<Image> imageList=null;
        for(int i=0;i<proprieteList.size();i++){
           imageList= iimageServices.RechercherParPropriete(proprieteList.get(i));
        }
        model.addAttribute("bailleur",this.bailleur);
        model.addAttribute("listImage",imageList);
        model.addAttribute("proprieteList",proprieteList);
        return "Bailleur/GestionPropriete";
    }


    @RequestMapping("/delete")
    public String delete(Long id){
        iProprieteServices.supprimerPropriete(id);
        return "redirect:/GestionPropriete";
    }

    /*
    permet de mettre a jour une propriete dont on lui passe l'id
    en parametre
     */
    @GetMapping("/update")
    public String Pageupdate(Long id,Model model){
        this.nId=id;
        Propriete propriete=iProprieteServices.consulterPropriete(this.nId);
        model.addAttribute("bailleur",this.bailleur);
        model.addAttribute("propriete",propriete);
        return "Bailleur/ModifierPropriete";

    }

    @PostMapping("/SaveUpdate")
    public String upadate(Model model,Propriete propriete){
        model.addAttribute("propriete",new Propriete());
        iProprieteServices.modifierPropriete(this.nId,propriete);
        return"redirect:/GestionPropriete";
    }
    @GetMapping("/annuler")
    public String annuler(){
        return "redirect:/GestionPropriete";
    }

    @GetMapping("/proprieteLibre")
    public String proprieteLibre(Model model){
       List<Propriete>proprieteList= iProprieteServices.proprieteLibreParBailleur(this.bailleur);
        model.addAttribute("bailleur",this.bailleur);
       model.addAttribute("proprieteList",proprieteList);
        return "Bailleur/ProprieteLibre";
    }
}
