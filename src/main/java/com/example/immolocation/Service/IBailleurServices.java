package com.example.immolocation.Service;


import com.example.immolocation.Model.Bailleur;
import com.example.immolocation.Model.Locataire;

import java.util.List;

public interface IBailleurServices {

   //retourne un objet bailleur
    public Bailleur rechercherBailleur(String login);

    void ajouterBailleur(Bailleur bailleur);

    Bailleur rechercherParId(Long id);

    public List<Locataire> locataireselonloginBailleur(String login);



   public Bailleur rechercherBailleurParLogin(String login);
}
