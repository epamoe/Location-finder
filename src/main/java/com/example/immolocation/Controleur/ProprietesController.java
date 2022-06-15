package com.example.immolocation.Controleur;



import com.example.immolocation.Model.Proprietes;
import com.example.immolocation.Service.ProprietesServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@Value("${uploadDir}")
	private String uploadFolder;

	@Autowired
	private ProprietesServiceImpl proprietesService;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping(value = {"/", "/home"})
	public String addProductPage() {
		return "index";
	}

	@PostMapping("/image/saveImageDetails")
	public @ResponseBody ResponseEntity<?> createProduct(@RequestParam("name") String name,final @RequestParam("image") MultipartFile file, @RequestParam("description") String description,
			 @RequestParam("localisation") String localisation,@RequestParam("ville") String ville,@RequestParam("etat") String etat,@RequestParam("prix") int prix, Model model, HttpServletRequest request)
			 {
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
			log.info("ville" +ville);
			log.info("etat" +etat);

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
			propriete.setVille(ville);
			propriete.setCreateDate(createDate); propriete.setLocalisation(localisation);
			proprietesService.savePropriete(propriete);
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
		propriete = proprietesService.getProprieteById(id);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(propriete.get().getImage());
		response.getOutputStream().close();
	}

	@GetMapping("/image/imageDetails")
	String showProductDetails(@RequestParam("id") Long id, Optional<Proprietes> propriete, Model model) {
		try {
			log.info("Id :: " + id);
			if (id != 0) {
				propriete = proprietesService.getProprieteById(id);
			
				log.info("products :: " + propriete);
				if (propriete.isPresent()) {
					model.addAttribute("id", propriete.get().getId());
					model.addAttribute("description", propriete.get().getDescription());
					model.addAttribute("name", propriete.get().getName());
					model.addAttribute("price", propriete.get().getPrix());
					return "imagedetails";
				}
				return "redirect:/home";
			}
		return "redirect:/home";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/home";
		}	
	}

	@GetMapping("/image/show")
	String show(Model map) {
		List<Proprietes> propriete = proprietesService.getAllActivePropriete();
		map.addAttribute("propriete", propriete);
		return "Bailleur/GestionProprietes";
	}

}	

