package com.example.immolocation.Dao;


import com.example.immolocation.Model.Locataire;
import com.example.immolocation.Model.Propriete;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface LocatireRepository extends CrudRepository<Locataire, Long> {
      @Query("SELECT u.montant_mensuel_a_payer FROM Locataire u WHERE u.id_locataire=?1")
               long montant_mentuel(long id);
      


                  Locataire findById(long Id);

                 public List<Locataire> findByPropriete(Propriete propriete);



    @Query("SELECT a.nom_Locataire, a.prenom_Locataire, a.montant_mensuel_a_payer,r.dette FROM Locataire a " +
            "JOIN a.factures r WHERE r.dette>0 AND r.id_facture=(select max(r.id_facture) from r  ) ")
                            List<String> locataire_endettes();

}
