package com.example.immolocation.Controleur;


import com.example.immolocation.Model.Propriete;
import com.example.immolocation.Service.IProprieteServices;
import com.example.immolocation.Service.IimageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



@Controller
public class Image_controller {


    @Autowired
    private IimageServices iimageServices;

    @Autowired
    IProprieteServices iproprieteServices;

    private Long nId;

    @GetMapping("/AjouterImage")
    public String ajouterImage(Long id){
        this.nId=id;
        return "Bailleur/AjouterImage";
    }
    @PostMapping("/saveImage")
    public String SaveImage(@RequestParam("image")MultipartFile file){
        Propriete propriete=iproprieteServices.consulterPropriete(this.nId);
        iimageServices.AjouterImage(file,propriete);

    return "redirect:/GestionPropriete";
    }

  /*  @PostMapping("/saveImageProcessing")
    public @ResponseBody
    ResponseEntity<?> createImage(@RequestParam("name") String name,
                                  Model model)

*/


}
