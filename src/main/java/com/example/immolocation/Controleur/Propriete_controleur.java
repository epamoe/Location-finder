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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@Controller
public class Propriete_controleur {


    @Autowired
    IProprieteServices iProprieteServices;

    @Autowired
    IBailleurServices ibailleurServices;

    @Autowired
    private IimageServices iimageServices;
    IUserServices iUserServices;



    private Long nId;
    private  Long Id_BailleurConnecter=1L;

    //********************************************************

  //  public void find(){
      //  this.Id_BailleurConnecter=iUserServices.id_utilisateur();
   //  }

    @GetMapping("/AjouterPropriete")
    public String formulairePropriete(Model model){
        model.addAttribute("propriete",new Propriete());
        return "Bailleur/AjouterPropriete";
    }

   /*apres l'envoie du formulaire d'ajout si la propriete est occupé par un locataire,
   on demande au bailleur de renseigner les info du
    locataire concerné dans le cas contraire on lui
    retourne la page de gestion de propriete*/

    @PostMapping("/GestionPropriete")
    public String Save(Model model,Propriete propriete){


        model.addAttribute("propriete",new Propriete());
      //  String direction=null;
        iProprieteServices.ajouterProprieter(propriete,ibailleurServices.rechercherBailleurParId(Id_BailleurConnecter));
        /*if(propriete.getDisponible()==true){
            direction="redirect:/GestionPropriete";
        }
        else if(propriete.getDisponible()==false){
            direction="redirect:/AjouterLocataire";
        }
        return direction;
*/return "redirect:/GestionPropriete";
    }


    @GetMapping("/GestionPropriete")
    public String pageGestionPropriete(Model model){
        Bailleur bailleur=ibailleurServices.rechercherBailleurParId(Id_BailleurConnecter);
        List<Propriete> proprieteList=iProprieteServices.listProprieteparBailleur(bailleur);
        List<Image> imageList=null;
        for(int i=0;i<proprieteList.size();i++){
           imageList= iimageServices.RechercherParPropriete(proprieteList.get(i));
        }

        model.addAttribute("bailleur",bailleur);
        model.addAttribute("listImage",imageList);
        model.addAttribute("proprieteList",proprieteList);
        return "Bailleur/GestionPropriete";
    }


    @RequestMapping("/delete")
    public String delete(Long id){
        iProprieteServices.supprimerPropriete(id);
        return "redirect:/GestionPropriete";
    }

    @GetMapping("/update")
    public String Pageupdate(Long id,Model model){
        this.nId=id;
        Propriete propriete=iProprieteServices.consulterPropriete(this.nId);
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
       List<Propriete>proprieteList= iProprieteServices.findAllFreePropriete();
       model.addAttribute("proprieteList",proprieteList);
        return "Bailleur/ProprieteLibre";
    }
}
