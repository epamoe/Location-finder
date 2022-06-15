package com.example.immolocation.Service;
import java.util.List;
import java.util.Optional;

import com.example.immolocation.Dao.ImageRepository;
import com.example.immolocation.Model.Image;
import com.example.immolocation.Model.Propriete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;
import java.io.IOException;
import java.util.Base64;



@Service
public class ImageServiceImpl implements IimageServices {

    @Autowired
    private ImageRepository imageRepository;

    public void AjouterImage(Image image) {
        imageRepository.save(image);
    }

    public List<Image> getAllActiveImages() {
        return imageRepository.findAll();
    }

    public void AjoutImage(MultipartFile file, Propriete propriete) {

        Image image = new Image();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("..")) {
            System.out.println("fichier non valide");
        }
        try {
            image.setImage(Base64.getEncoder().encodeToString(file.getBytes()));

        } catch (IOException e) {
            e.printStackTrace();
        }

        image.setPropriete(propriete);
        imageRepository.save(image);
    }



    @Override
    public List<Image> RechercherParPropriete(Propriete propriete) {
        List<Image> images =imageRepository.findByPropriete(propriete);
        return images;
    }


    @Override
    public void AjouterImage(MultipartFile file, Propriete propriete) {

    }

    @Override
    public void supprimerImage(Image image) {
        imageRepository.delete(image);

    }

    public Optional<Image> getImageById(Long id) {
        return imageRepository.findById(id);
    }

}

