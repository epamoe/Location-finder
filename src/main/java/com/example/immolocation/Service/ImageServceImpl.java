package com.example.immolocation.Service;

import com.example.immolocation.Dao.ImageRepository;
import com.example.immolocation.Model.Image;
import com.example.immolocation.Model.Propriete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageServceImpl implements IimageServices {


    @Autowired
    ImageRepository imageRepository;

    @Override
    public void ajouterImage(Image image) {
        imageRepository.save(image);
    }

    @Override
    public void supprimerImage(Image image) {
        imageRepository.delete(image);
    }

    @Override
    public Optional<Image> getImageById(Long id) {
        return imageRepository.findById(id);
    }

    @Override
    public List<Image> AllImageParIdPropriete(Propriete propriete) {
        return null;
    }


   /* public List<Image> AllImageParIdPropriete(Propriete propriete) {
        return imageRepository.findByPropriete(propriete);
    }*/
}
