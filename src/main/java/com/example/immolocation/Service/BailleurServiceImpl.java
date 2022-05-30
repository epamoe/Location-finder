package com.example.immolocation.Service;

import com.example.immolocation.Dao.BailleurRepository;
import com.example.immolocation.Model.Bailleur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BailleurServiceImpl implements IBailleurServices {

    @Autowired
    BailleurRepository bailleurRepository;

    public Bailleur rechercherBailleurParId(Long id){

        Bailleur bailleur=bailleurRepository.findById(id).get();
        return bailleur;

    }

}
