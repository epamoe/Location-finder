package com.example.immolocation.Service;

import com.example.immolocation.Dao.LocataireRepository;
import com.example.immolocation.Model.Bailleur;
import com.example.immolocation.Model.Locataire;
import com.example.immolocation.Model.Propriete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocataireServiceImpl implements ILocataireServices {

    @Autowired
    IBailleurServices iBailleurServices;
    @Autowired
    LocataireRepository locataireRepository;

    @Override
    public void addLocataire(Locataire locataire,Bailleur bailleur,Propriete propriete) {
        List<Propriete> proprieteList = locataire.getPropriete();//lorsque on alloue une propriete elle devient occupé
        for (int i = 0; i < proprieteList.size(); i++) {
            proprieteList.get(i).setDisponible(false);
        }

        locataire.setBailleur(bailleur);
        locataire.setPropriete(proprieteList);
        locataireRepository.save(locataire);

    }



    @Override
    public void deleteLocatire(Locataire locataire) {

    }

    @Override
    public List<Locataire> findByPropriete() {
        return null;
    }

    @Override
    public List<Locataire> findByBailleur(Bailleur bailleur) {
        return null;
    }
}