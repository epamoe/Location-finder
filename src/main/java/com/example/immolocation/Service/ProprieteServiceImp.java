package com.example.immolocation.Service;

import com.example.immolocation.Dao.BailleurRepository;
import com.example.immolocation.Dao.ProprieteRepository;
import com.example.immolocation.Model.Bailleur;
import com.example.immolocation.Model.Propriete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProprieteServiceImp implements IProprieteServices{


    @Autowired
    private ProprieteRepository proprieteRepository;
    @Autowired
    private BailleurRepository bailleurRepository;


    @Override
    public void ajouterProprieter(Propriete propriete) {
        proprieteRepository.save(propriete);
    }


    public void supprimerPropriete(Propriete propriete) {
        proprieteRepository.delete(propriete);
    }


    public void modifierPropriete(Propriete propriete) {
        proprieteRepository.save(propriete);
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
    //////////////////////::::::encours de traitement!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    @Override
    public void publierPropriete(Propriete propriete) {
        if(propriete.getDisponible() == true){


        }
        else{
            ajouterProprieter(propriete);
        }
    }


}
