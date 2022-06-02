package com.example.immolocation.Service;

import com.example.immolocation.Model.Image;
import com.example.immolocation.Model.Propriete;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface IimageServices {

    //**********enregistre une image en BD
    public void AjouterImage(MultipartFile file, String name,Propriete propriete);
    //**********supprime une image en BD
    //**********retourne l'image de l'id
    //**********retourne les images associées a une propriete
}
