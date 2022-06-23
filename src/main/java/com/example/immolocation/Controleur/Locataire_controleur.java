package com.example.immolocation.Controleur;

import com.example.immolocation.Model.*;
import com.example.immolocation.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
    IProprietesServices iProprietesServices;

   private String login;
    private Bailleur bailleur;
    ProprietesController proprietesController=new ProprietesController();


    @GetMapping("/Locataire/AuthentificationLocataire")
    public String authentificationlocataire() {
        return "/Locataire/AuthentificationLocataire";
    }



    // @Secured(value="ROLE_LOCATAIRE") Faudra retirer les commentaires une fois qu'on poura ajouter un locataire avec son role
    @GetMapping("/locataire")
    public String locataire(HttpServletRequest httpServletRequest) {
       HttpSession httpSession = httpServletRequest.getSession();
        SecurityContext securityContext = (SecurityContext)
                httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
        String login = securityContext.getAuthentication().getName();
      //
        return "/Locataire/Locataire";
    }

    @GetMapping("/en")
    public String enre() {
        return "en_lo";
    }


    @PostMapping(value = "/val")
    public String ajouterUserRole(User user) {
        service.ajouterUtilsateurRole(user);
        return "Accueil";
    }


    @GetMapping("/AjouterLocataire")
    public String formulaireLocataire(Model model,HttpServletRequest httpServletRequest) {
        HttpSession httpSession = httpServletRequest.getSession();
        SecurityContext securityContext = (SecurityContext)
                httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
        String login = securityContext.getAuthentication().getName();
        this.bailleur= iBailleurServices.rechercherBailleur(login);
        model.addAttribute("bailleur",this.bailleur);
        model.addAttribute("locataire", new Locataire());
        List<Proprietes> proprieteList = iProprietesServices.proprieteLibreParBailleur(this.bailleur);
        model.addAttribute("proprieteList",proprieteList);
        return "Bailleur/AjouterLocataire";
    }

    @PostMapping("/SaveLocataire")
    public String save(Model model, Locataire locataire, @RequestParam("name") String name){
        model.addAttribute("locataire",new Locataire());
        Proprietes proprietes=iProprietesServices.findByName(name,this.bailleur);
        iLocataireServices.addLocataire(locataire,this.bailleur,proprietes);
        return "redirect:/GestionLocataire";
    }

    @GetMapping("/GestionLocataire")
    public String pageGestionLocataire(Model model,HttpServletRequest httpServletRequest){

        HttpSession httpSession = httpServletRequest.getSession();
        SecurityContext securityContext = (SecurityContext)
                httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
        String login = securityContext.getAuthentication().getName();
        this.bailleur= iBailleurServices.rechercherBailleur(login);



        List<Locataire> locataires= new ArrayList<>();

        List<Proprietes> proprietes=iProprietesServices.listProprieteparBailleur(iBailleurServices.rechercherBailleur("al"));
        for (int i=0;i<proprietes.size();i++){
            locataires.add(iLocataireServices.rechercherParPropriete(proprietes.get(i)));
        }
        model.addAttribute("locataireList",locataires);
        model.addAttribute("bailleur",this.bailleur);
        return "Bailleur/GestionLocataire";
    }

}
      /*  @PostMapping("/SaveProcessing1")
        public String SaveLocataire1 (Model model, Locataire locataire, String login){

  /*
     @GetMapping("/AjouterLocataire")
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
    return "AjouterLocataire";
    }*//* @PostMapping("/SaveProcessing")
    public String SaveLocataire(Model model, Locataire locataire){
>>>>>>> 15d4ac3189412932c2318b6a23d1c04d0dbe1eba

            model.addAttribute("Locatiare", new Locataire());

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
*/