package com.example.immolocation.Service;


import com.example.immolocation.Dao.ProprieteRepository;
import com.example.immolocation.Model.Propriete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LouerServiceImpl implements ILouerServices{

    @Autowired
    ProprieteRepository proprieteRepository;
    @Override
    public void ajouterPropriete(Propriete propriete) {
        proprieteRepository.save(propriete);
    }

    @Override
    public void arracher() {

    }
}
