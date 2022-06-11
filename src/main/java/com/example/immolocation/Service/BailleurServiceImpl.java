package com.example.immolocation.Service;

import com.example.immolocation.Dao.BailleurRepository;
import com.example.immolocation.Model.Bailleur;
import com.example.immolocation.Model.Locataire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BailleurServiceImpl implements IBailleurServices {

    @Autowired
    BailleurRepository bailleurRepository;

    public Bailleur rechercherBailleurParId(String login) {

        Bailleur bailleur = bailleurRepository.findById(login).get();
        return bailleur;

    }

    public List<Locataire> locataireselonloginBailleur(String login) {
        List<Locataire> locataire = bailleurRepository.liste_loc_selon_Bailleurlogin(login);
        return locataire;
    }
}
