package com.example.immolocation.Service;

import com.example.immolocation.Model.Bailleur;
import com.example.immolocation.Model.Propriete;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProprieteServices {

    //ajoute une propriete dans la bd
    public void ajouterProprieter(Propriete propriete,Bailleur bailleur);

    public Bailleur retourneBailleur(Propriete propriete);

    //retourne la liste de toute les proprietes libres presente en bd,tout bailleur confondu
    public List<Propriete> findAllFreePropriete();

    //supprime une propriete de la Bd
    public void supprimerPropriete(Long id);

    //modifie une propriete existante
    public void modifierPropriete(Long id,Propriete propriete);

    //retourne un propriete ayant l'id mis en parametre
    public Propriete consulterPropriete(Long id);

    //retourne une liste de propriete par region
    public List<Propriete> findByRegion(String Region);

    //retourne une liste de propriete par description
    public List<Propriete> findByLocalisation(String localisation);

    //retourne une liste de propriete par intervalle de prix
    public List<Propriete> findByPrix(Long prixiInf,Long prixSup);

    //retourne la liste des proprietes d'un bailleur d'identifiant idbailleur
    public List<Propriete> listProprieteparBailleur(Bailleur bailleur);

    //retourne une propriete
    public Propriete findByName(String name);

    public Optional<Propriete> consulterProp(Long id);





}
