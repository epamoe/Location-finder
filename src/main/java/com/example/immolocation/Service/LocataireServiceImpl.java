package com.example.immolocation.Service;

import com.example.immolocation.Dao.LocataireRepository;
import com.example.immolocation.Model.Bailleur;
import com.example.immolocation.Model.Locataire;
import com.example.immolocation.Model.Propriete;
import com.example.immolocation.Model.Proprietes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocataireServiceImpl implements ILocataireServices {

    @Autowired
    IBailleurServices iBailleurServices;
    @Autowired
    LocataireRepository locataireRepository;
    @Autowired
    IProprietesServices iProprietesServices;

    /*
    cette methode permet d'enregistrer un locataire
    en définissant la proprieté qu'il occupe comme
    non disponible et en definissant qui est le bailleur
    de ce locataire
     */
    @Override
    public void addLocataire(Locataire locataire,Bailleur bailleur,Proprietes propriete) {
        List<Proprietes> proprieteList = locataire.getPropriete();//lorsque on alloue une propriete elle devient occupé
        propriete=iProprietesServices.setDisponibilite("LA PROPRIETE EST OCCUPEE PAR UN LOCATAIRE",propriete);//changement d'etat de la propriete(passage de l'etat libre a occupé)
        locataire.setBailleur(bailleur);// definit le bailleur qui enregistre la propriete
        locataireRepository.save(locataire);//senregistrement du locataire
        iProprietesServices.modifierPropriete(propriete.getId(),propriete);//modification de la propriete le rendant occupée

    }



    @Override
    public void deleteLocatire(Locataire locataire) {
        locataireRepository.delete(locataire);
    }

    @Override
    public List<Locataire> findByPropriete() {
        return null;
    }

    @Override
    public List<Locataire> findByBailleur(Bailleur bailleur) {
        return null;
    }


    @Override
    public Locataire rechercherParPropriete(Propriete propriete) {
       Locataire locataire=locataireRepository.findLocataireByPropriete(propriete);
       return locataire;
    }

    public Locataire rechercherParPropriete(Proprietes propriete) {
        Locataire locataire=locataireRepository.findByPropriete(propriete);
        return locataire;
    }

}