package com.example.immolocation.Service;


import com.example.immolocation.Model.Bailleur;
import com.example.immolocation.Model.Locataire;

import java.util.List;

public interface ILocataireServices {

    //*********ajoute un locataire
    public void addLocataire(Locataire locataire);

    //*********supprime un locataire
    public void deleteLocatire(Locataire locataire);

    //*********retourne les info sur les proprietes occupée par le locataire
    public List<Locataire> findByPropriete();

    //********retourne la liste des locataires par bailleurs
    public List<Locataire> findByBailleur(Bailleur bailleur);

}
