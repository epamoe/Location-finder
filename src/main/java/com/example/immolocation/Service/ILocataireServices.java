package com.example.immolocation.Service;


import com.example.immolocation.Model.Bailleur;
import com.example.immolocation.Model.Locataire;
import com.example.immolocation.Model.Propriete;
import com.example.immolocation.Model.Proprietes;

import java.util.List;

public interface ILocataireServices {

    //*********ajoute un locataire
    public void addLocataire(Locataire locataire, Bailleur bailleur, Proprietes propriete);

    //*********supprime un locataire
    public void deleteLocatire(Locataire locataire);

    public  List<Locataire> findAllByBailleur(Bailleur bailleur);

    //*********retourne les info sur les proprietes occupée par le locataire
    public List<Locataire> findByPropriete();

    //********retourne la liste des locataires par bailleurs
    public List<Locataire> findByBailleur(Bailleur bailleur);


    public Locataire rechercherParPropriete(Propriete propriete);

    public Locataire rechercherParPropriete(Proprietes propriete);

}
