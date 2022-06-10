package com.example.immolocation.Service;

import com.example.immolocation.Dao.BailleurRepository;
import com.example.immolocation.Dao.ProprieteRepository;
import com.example.immolocation.Model.Bailleur;
import com.example.immolocation.Model.Image;
import com.example.immolocation.Model.Locataire;
import com.example.immolocation.Model.Propriete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProprieteServiceImp implements IProprieteServices{

    @Autowired
    ILocataireServices iLocataireServices;

    @Autowired
    private ProprieteRepository proprieteRepository;
    @Autowired
    private BailleurRepository bailleurRepository;

    @Autowired
    IimageServices iimageServices;

    public Bailleur retourneBailleur(Propriete propriete){
       Bailleur bailleur= propriete.getBailleur();
       return bailleur;
    }

    @Override
    public List<Propriete> findAllFreePropriete() {
       List<Propriete> proprieteList=proprieteRepository.findAll();
       List<Propriete> listPropriete=new ArrayList<>();
       for(int i=0;i<proprieteList.size();i++){
           if(proprieteList.get(i).getDisponible()==true){
               listPropriete.add(proprieteList.get(i));
           }
       }
        return listPropriete;
    }


    @Override
    public void ajouterProprieter(Propriete propriete,Bailleur bailleur) {
        propriete.setBailleur(bailleur);
        proprieteRepository.save(propriete);
    }

    //********************la suppression d'une propriete occupé entraine la suppression de son locataire******************************
    public void supprimerPropriete(Long id) {
        Propriete propriete=proprieteRepository.findById(id).get();
        List<Image> images = iimageServices.RechercherParPropriete(propriete);

        if(propriete.getDisponible()== true){
            for(int i=0;i<images.size();i++){
                Image image=images.get(i);
                iimageServices.SupprimmerImage(image);
            }
            proprieteRepository.delete(propriete );
        }
        else{
            for(int i=0;i<images.size();i++){
                Image image=images.get(i);
                iimageServices.SupprimmerImage(image);
            }
        Locataire locataire=iLocataireServices.rechercherParPropriete(propriete);
        iLocataireServices.deleteLocatire(locataire);
        proprieteRepository.delete(propriete);
        }
    }


    public void modifierPropriete(Long id,Propriete propriete) {
       Propriete propriete1=proprieteRepository.findById(id).get();
       propriete1.setLocalisation(propriete.getLocalisation());
       propriete1.setVille(propriete.getVille());
       propriete1.setDisponible(propriete.getDisponible());
       propriete1.setDate(propriete.getDate());
       propriete1.setName(propriete.getName());
        proprieteRepository.save(propriete1);
    }




    public Propriete consulterPropriete(Long id) {
        Propriete propriete=proprieteRepository.findById(id).get();
        if(id<=0) throw new RuntimeException("Il n'existe pas de propriete avec cet identifiant");
        return propriete;
    }

    @Override
    public List<Propriete> findByRegion(String Region) {
        List<Propriete> proprieteList = proprieteRepository.finfAllByRegion(Region);
        return proprieteList;
    }

    @Override
    public List<Propriete> findByLocalisation(String localisation) {
        List<Propriete> proprieteList = proprieteRepository.finfAllByLocalisation(localisation);
        return proprieteList;
    }

    @Override
    public List<Propriete> findByPrix(Long prixiInf, Long prixSup) {
        List<Propriete> proprieteList = proprieteRepository.finfAllByPrix(prixiInf,prixSup);
        return proprieteList;
    }

    @Override
    public List<Propriete> listProprieteparBailleur(Bailleur bailleur) {
        List<Propriete> proprieteList = proprieteRepository.findAllByBailleur(bailleur);
        return proprieteList;
    }

    @Override
    public Propriete findByName(String name) {
     //   proprieteRepository.findByName(name);

        return null;
    }
    //////////////////////::::::encours de traitement!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


    @Override
    public Optional<Propriete> consulterProp(Long id) {
        return proprieteRepository.findById(id);
    }


}
