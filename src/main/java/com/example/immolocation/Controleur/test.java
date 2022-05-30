package com.example.immolocation.Controleur;

import com.example.immolocation.Dao.ImageRepository;
import com.example.immolocation.Model.Bailleur;
import com.example.immolocation.Model.Image;
import com.example.immolocation.Model.Propriete;
import com.example.immolocation.Service.ILouerServices;
import com.example.immolocation.Service.IimageServices;
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

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.Date;

@Controller
public class test {
    @Autowired
    ImageRepository imageRepository;
    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Value("$(uploadDir)")
    private String uploadFolder;

    @RequestMapping(value = "/image",method = RequestMethod.GET)
    public String pageImage(Model model){
        model.addAttribute("image",new Image());
                return"Bailleur/Image";
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<?> save(@RequestParam("name") String name,HttpServletRequest request,
                                      Model model, final @RequestParam("image") MultipartFile file){
        try{
            //String uploadDirectory=System.getProperty("user.dir") + uploadFolder;
            String uploadDirectory= request.getServletContext().getRealPath(uploadFolder);
            logger.info("uploadDirectory::" + uploadDirectory);
            String fileName= file.getOriginalFilename().toString();
            String filePath = Paths.get(uploadDirectory,fileName).toString();
            logger.info("FileName:"+file.getOriginalFilename());
            if(fileName == null || fileName.contains("..")){
                model.addAttribute("invalide","désolé,le nom du fichier contient une seqence de chemin invalide"+ fileName);
                return new ResponseEntity<>("desolé! le nom du fichier contient un sequence de chemin d'acces invalide"+fileName, HttpStatus.BAD_GATEWAY);
            }
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

            byte[] imageData = file.getBytes();
            Image image=new Image();
            image.setName(name);
            image.setImage(imageData);
            imageRepository.save(image);


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
            logger.info("Exception:" + e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }







}
