package com.example.immolocation.Service;

import com.example.immolocation.Dao.FactureRepository;
import com.example.immolocation.Dao.LocatireRepository;
import com.example.immolocation.Model.Facture;
import com.example.immolocation.Model.Locataire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceFacture {

@Autowired
Facture facture;
    @Autowired
    LocatireRepository locataireRepository;
@Autowired
    private FactureRepository factureRepository;

    public List<Facture> Liste_de_facture(int id){
        return factureRepository.liste_facture(id);
    }
    public void attribuer_fact(long id, int montant){

        Locataire locataire =locataireRepository.findById(id);
            facture.setLocataire(locataire);
          if (montant == (int) locataireRepository.montant_mentuel(id)){
              factureRepository.save(facture);
          }
          else if (montant < (int) locataireRepository.montant_mentuel(id))
          {
              facture.setDette((int) locataireRepository.montant_mentuel(id)-montant);
              facture.setAvance(montant);
              facture.setMontant(0);
              factureRepository.save(facture);
          }else
          {
            facture.setSurplus(montant-(int)locataireRepository.montant_mentuel(id));
              factureRepository.save(facture);
          }
            facture.setMontant(montant);
          factureRepository.save(facture);

    }
}
