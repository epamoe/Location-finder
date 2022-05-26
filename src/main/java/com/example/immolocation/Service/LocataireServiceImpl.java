package com.example.immolocation.Service;

import com.example.immolocation.Model.Bailleur;
import com.example.immolocation.Model.Locataire;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LocataireServiceImpl implements ILocataireServices {

    @Autowired
    ILocataireServices iLocataireServices;

    @Override
    public void addLocataire(Locataire locataire) {
        iLocataireServices.addLocataire(locataire);
    }

    @Override
    public void deleteLocatire(Locataire locataire) {
        iLocataireServices.deleteLocatire(locataire);
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
