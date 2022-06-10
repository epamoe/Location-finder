package com.example.immolocation.Service;

import com.example.immolocation.Dao.ImageRepository;
import com.example.immolocation.Model.Image;
import com.example.immolocation.Model.Propriete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class ImageServceImpl implements IimageServices {


    @Autowired
    ImageRepository imageRepository;

    public void AjouterImage(MultipartFile file,Propriete propriete){

        Image image = new Image();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains("..")){
            System.out.println("fichier non valide");
        }
        try {
                image.setImage(Base64.getEncoder().encodeToString(file.getBytes()) );

            }
            catch(IOException e){
                e.printStackTrace();
            }

        image.setPropriete(propriete);
        imageRepository.save(image);
        }

    @Override
    public void SupprimmerImage(Image image) {
        imageRepository.delete(image);
    }

    @Override
    public List<Image> RechercherParPropriete(Propriete propriete) {
        List<Image> images =imageRepository.findByPropriete(propriete);
        return images;
    }


<<<<<<< HEAD
    /*
    public List<Image> AllImageParIdPropriete(Propriete propriete) {
=======
}

   /* public List<Image> AllImageParIdPropriete(Propriete propriete) {
>>>>>>> 15d4ac3189412932c2318b6a23d1c04d0dbe1eba
        return imageRepository.findByPropriete(propriete);
    }*/

