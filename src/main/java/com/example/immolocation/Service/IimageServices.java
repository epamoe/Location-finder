package com.example.immolocation.Service;

import com.example.immolocation.Model.Image;
import com.example.immolocation.Model.Propriete;

import java.util.List;
import java.util.Optional;

public interface IimageServices {

    //**********enregistre une image en BD
    public void ajouterImage(Image image);

    //**********supprime une image en BD
    public void supprimerImage(Image image);

    //**********retourne l'image de l'id
    public Optional<Image> getImageById(Long id);

    //**********retourne les images associées a une propriete
    public List<Image> AllImageParIdPropriete(Propriete propriete);
}
