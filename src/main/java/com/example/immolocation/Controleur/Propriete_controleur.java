package com.example.immolocation.Controleur;

import com.example.immolocation.Dao.BailleurRepository;
import com.example.immolocation.Model.Bailleur;
import com.example.immolocation.Model.Propriete;
import com.example.immolocation.Service.IProprieteServices;
import com.sun.jdi.event.ExceptionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.http.HttpRequest;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Optional;


@Controller
public class Propriete_controleur {

    @Autowired
    IProprieteServices iProprieteServices;
//ceci es temporaire*************************************
    @Autowired
    BailleurRepository bailleurRepository;
//********************************************************

    @RequestMapping("/propriete")
    public String Pagepropriete(){

        return "/propriete/propriete";
    }
    //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    @Value("$(uploadDir)")
    private String uploadFolder;

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @GetMapping(value="/AjouterPropriete")
    public String addImage(){
        return"formPropriete";
    }
    @PostMapping("/saveImageProcessing")
    public @ResponseBody
    ResponseEntity<?> createPropriete(@RequestParam("name") String name,
                                      @RequestParam("description") String description,
                                      @RequestParam("localisation") String localisation,
                                      @RequestParam("region") String region,
                                      @RequestParam("disponible") boolean disponible,
                                      @RequestParam("prix") long prix, HttpServletRequest request,
                                      Model model, final @RequestParam("image")MultipartFile file){
        try{
            //String uploadDirectory=System.getProperty("user.dir") + uploadFolder;
            String uploadDirectory= request.getServletContext().getRealPath(uploadFolder);
            logger.info("uploadDirectory::" + uploadDirectory);
            String fileName= file.getOriginalFilename().toString();
            String filePath = Paths.get(uploadDirectory,fileName).toString();
            logger.info("FileName:"+file.getOriginalFilename());
                if(fileName == null || fileName.contains("..")){
                    model.addAttribute("invalide","désolé,le nom du fichier contient une seqence de chemin invalide"+ fileName);
                    return new ResponseEntity<>("desolé! le nom du fichier contient un sequence de chemin d'acces invalide"+fileName,HttpStatus.BAD_GATEWAY);
                }
                String[] descriptions = description.split(",");
                Date date=new Date();
                logger.info("region" + region);
                logger.info("localisation:"+localisation);
                logger.info("description:"+ descriptions[0]);
                logger.info("prix:"+ prix);
                logger.info("name" + name);
                try{
                    File dir = new File(uploadDirectory);
                    if(!dir.exists()){
                        logger.info("fichier creer");
                        dir.mkdirs();
                    }
                    //enregistrement local du fichier
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
                    stream.write(file.getBytes());
                    stream.close();
                }
                catch(Exception e){
                    logger.info("in catch");
                    e.printStackTrace();
                }
                //bailleur proprietaire
            Bailleur bailleur=new Bailleur("marc","berger",22,"marco","galipette");
                bailleurRepository.save(bailleur);///////////////////////////////////////////////////////////////////////////////////////////////a rectifier
                byte[] imageData = file.getBytes();
                Propriete propriete = new Propriete();
                propriete.setDescription(descriptions[0]);
                propriete.setPrix(prix);
                propriete.setRegion(region);
                propriete.setLocalisation(localisation);
                propriete.setDate(date);
                propriete.setImage(imageData);
                propriete.setDisponible(disponible);
                propriete.setName(name);
             /*

                iProprieteServices.ajouterProprieter(propriete,bailleur);
                if (propriete.getDisponible() == true){

                publier()

                }
                else{

                ajouter locataire

                }*/
            logger.info("HttpStatus===" + new ResponseEntity<>(HttpStatus.OK));
            return new ResponseEntity<>("propriete enregistrée avec comme nom de fichier -" +fileName,HttpStatus.OK);

        }
        catch (Exception e){
            e.printStackTrace();
            logger.info("Exception:" +e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


                                  //***************************************client demande le formulaire ajout propriete********************************
                                  @GetMapping("/ajoutPropriete")
    public String PageAjout(){
        return "propriete";
    }


    //******************retourne une propriete avec son image
    @GetMapping("/infoPropriete")
    @ResponseBody
    public void showImage(@PathVariable("id_propriete") Long id_propriete,HttpServletResponse response,Optional<Propriete> propriete) throws IOException {

            logger.info("id_propriete::" + id_propriete);
            propriete = iProprieteServices.consulterProp(id_propriete);
            response.setContentType("image/jpeg" + "image/jpg" + "image/png" + "image/gif");
            response.getOutputStream().write(propriete.get().getImage());
            response.getOutputStream().close();
    }


    public String showProprieteDetails(@PathVariable("id_propriete") Long id_propriete, HttpServletResponse reponse, Optional<Propriete> propriete,Model model){
        try {
            logger.info("id_propriete ::"+ id_propriete);
            if (id_propriete != 0){
               propriete=iProprieteServices.consulterProp(id_propriete);
               logger.info("propriete ::" + propriete);
               if (propriete.isPresent()){
                   model.addAttribute("id_propriete",propriete.get().getId_propriete());
                   model.addAttribute("name",propriete.get().getName());
                   model.addAttribute("description",propriete.get().getDescription());
                   model.addAttribute("localisation",propriete.get().getLocalisation());
                   model.addAttribute("region",propriete.get().getRegion());
                   model.addAttribute("disponible",propriete.get().getDisponible());
                   model.addAttribute("prix",propriete.get().getPrix());
                   model.addAttribute("date",propriete.get().getDate());

                   return "proprieteDetail";
               }
               return "propriete";
            }
            return "propriete";
        }catch (Exception e){
            e.printStackTrace();
            return "propriete";
        }

    }
    //*********************************traitement du formulaire******************************************************
   /* @PostMapping("/saveProcessing")
    public String saveProcessing(Propriete propriete,Model model){
        model.addAttribute("p",new Propriete());

        return "/propriete/propriete";
    }

*/
}

