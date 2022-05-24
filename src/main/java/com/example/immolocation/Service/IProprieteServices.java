package com.example.immolocation.Service;

import com.example.immolocation.Model.Bailleur;
import com.example.immolocation.Model.Propriete;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProprieteServices {

    public void ajouterProprieter(Propriete propriete);
    public void supprimerPropriete(Propriete propriete);
    public void modifierPropriete(Propriete propriete);
    public Propriete consulterPropriete(Long id);
    public List<Propriete> listProprieteparBailleur(Bailleur Bailleur, Pageable pageable);
    public List<Propriete> findAllPropriete();






}
