package com.example.immolocation.Controleur;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


@Controller
public class Image_controller {


    @Value("$(uploadDir)")
    private String uploadFolder;

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @GetMapping(value="/Ajouterimage")
    public String addImage(){
        return"formImg";
    }
  /*  @PostMapping("/saveImageProcessing")
    public @ResponseBody
    ResponseEntity<?> createImage(@RequestParam("name") String name,
                                  Model model)

*/

}
