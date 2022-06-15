package com.example.immolocation.Controleur;



import com.example.immolocation.Model.Bailleur;
import com.example.immolocation.Model.Propriete;
import com.example.immolocation.Model.Proprietes;
import com.example.immolocation.Service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Controller
public class ProprietesController {


	private String userConnect;
	private  Bailleur bailleur;
	private Long nId;



	@Value("${uploadDir}")
	private String uploadFolder;

	@Autowired
	IBailleurServices ibailleurServices;

	@Autowired
	IProprietesServices iProprietesServices;

	private final Logger log = LoggerFactory.getLogger(this.getClass());


	@GetMapping("/GestionProprietes")
	public String pageGestionPropriete(Model model, Authentication authentication){
		this.bailleur=ibailleurServices.rechercherBailleur(authentication.getName());//recuperation du bailleur connecté
		List<Proprietes> propriete=iProprietesServices.listProprieteparBailleur(this.bailleur);
		model.addAttribute("bailleur",this.bailleur);
		model.addAttribute("propriete", propriete);
		return "propriete/GestionProprietes";
	}


	@GetMapping("/AjouterPropriete")
	public String formulairePropriete(Model model){
		model.addAttribute("bailleur",bailleur);
		model.addAttribute("propriete",new Propriete());
		return "propriete/AjouterPropriete";
	}

	@PostMapping("/image/saveImageDetails")
	public @ResponseBody ResponseEntity<?> createProduct(@RequestParam("name") String name,
														 @RequestParam("prix") int prix, @RequestParam("description") String description, @RequestParam("localisation") String localisation, Model model, HttpServletRequest request
			,final @RequestParam("image") MultipartFile file) {
		try {
			//String uploadDirectory = System.getProperty("user.dir") + uploadFolder;
			String uploadDirectory = request.getServletContext().getRealPath(uploadFolder);
			log.info("uploadDirectory:: " + uploadDirectory);
			String fileName = file.getOriginalFilename();
			String filePath = Paths.get(uploadDirectory, fileName).toString();
			log.info("FileName: " + file.getOriginalFilename());
			if (fileName == null || fileName.contains("..")) {
				model.addAttribute("invalid", "Sorry! Filename contains invalid path sequence \" + fileName");
				return new ResponseEntity<>("Sorry! Filename contains invalid path sequence " + fileName, HttpStatus.BAD_REQUEST);
			}
			String[] names = name.split(",");
			String[] descriptions = description.split(",");
			Date createDate = new Date();
			log.info("Name: " + names[0]+" "+filePath);
			log.info("description: " + descriptions[0]);
			log.info("prix: " + prix);
			log.info("localisation: " +localisation);
			try {
				File dir = new File(uploadDirectory);
				if (!dir.exists()) {
					log.info("Folder Created");
					dir.mkdirs();
				}
				// Save the file locally
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
				stream.write(file.getBytes());
				stream.close();
			} catch (Exception e) {
				log.info("in catch");
				e.printStackTrace();
			}
			byte[] imageData = file.getBytes();
			Proprietes propriete = new Proprietes();
			propriete.setName(names[0]);
			propriete.setImage(imageData);
			propriete.setPrix(prix);
			propriete.setDescription(descriptions[0]);
			propriete.setCreateDate(createDate); propriete.setLocalisation(localisation);
			iProprietesServices.savePropriete(propriete);
			log.info("HttpStatus===" + new ResponseEntity<>(HttpStatus.OK));
			return new ResponseEntity<>("Product Saved With File - " + fileName, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception: " + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}


	@GetMapping("/image/display/{id}")
	@ResponseBody
	void showImage(@PathVariable("id") Long id, HttpServletResponse response, Optional<Proprietes> propriete)
			throws ServletException, IOException {
		log.info("Id :: " + id);
		propriete = iProprietesServices.getProprieteById(id);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(propriete.get().getImage());
		response.getOutputStream().close();
	}

	@GetMapping("/image/imageDetails")
	String showProductDetails(@RequestParam("id") Long id, Optional<Proprietes> propriete, Model model) {
		try {
			log.info("Id :: " + id);
			if (id != 0) {
				propriete = iProprietesServices.getProprieteById(id);
			
				log.info("products :: " + propriete);
				if (propriete.isPresent()) {
					model.addAttribute("id", propriete.get().getId());
					model.addAttribute("description", propriete.get().getDescription());
					model.addAttribute("name", propriete.get().getName());
					model.addAttribute("localisation", propriete.get().getLocalisation());
					model.addAttribute("prix", propriete.get().getPrix());
					System.out.println(this.bailleur.getNom_bailleur());
					return "imagedetails";
				}
				return "redirect:/GestionProprietes";
			}
		return "redirect:/GestionProprietes";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/GestionProprietes";
		}	
	}

	@GetMapping("/image/show")
	String show(Model map) {
		List<Proprietes> propriete = iProprietesServices.getAllActivePropriete();
		map.addAttribute("propriete", propriete);
		return "propriete/GestionProprietes";
	}




	/*
    apres l'envoie du formulaire d'ajout si la propriete est occupé par un locataire,
    on demande au bailleur de renseigner les info du
     locataire concerné dans le cas contraire on lui
     retourne la page de gestion de propriete
      */
	@PostMapping("/SavePropriete")
	public String Save(Model model,Proprietes propriete,@RequestParam("etat") String etat){
		model.addAttribute("propriete",new Propriete());
		propriete=iProprietesServices.setDisponibilite(etat,propriete);
		iProprietesServices.ajouterProprieter(propriete,this.bailleur);
		return "redirect:/GestionProprietes";
	}


	/*
    renvoie le dashbord de gestion de propriete,
     locataire et de facturation
     */


	@RequestMapping("/delete")
	public String delete(Long id){
		iProprietesServices.supprimerPropriete(id);
		return "redirect:/GestionProprietes";
	}

	/*
    permet de mettre a jour une propriete dont on lui passe l'id
    en parametre
     */
	@GetMapping("/update")
	public String Pageupdate(Long id,Model model){
		this.nId=id;
		Proprietes propriete=iProprietesServices.consulterPropriete(this.nId);
		model.addAttribute("bailleur",this.bailleur);
		model.addAttribute("propriete",propriete);
		return "Bailleur/ModifierPropriete";

	}

	@PostMapping("/SaveUpdate")
	public String upadate(Model model,Proprietes propriete){
		model.addAttribute("propriete",new Propriete());
		iProprietesServices.modifierPropriete(this.nId,propriete);
		return"redirect:/GestionPropriete";
	}
	@GetMapping("/annuler")
	public String annuler(){
		return "redirect:/GestionPropriete";
	}

	@GetMapping("/proprieteLibre")
	public String proprieteLibre(Model model){
		List<Proprietes>proprieteList= iProprietesServices.proprieteLibreParBailleur(this.bailleur);
		model.addAttribute("bailleur",this.bailleur);
		model.addAttribute("proprieteList",proprieteList);
		return "Bailleur/ProprieteLibre";
	}

}	

