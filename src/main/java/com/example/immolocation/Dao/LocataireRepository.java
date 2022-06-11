package com.example.immolocation.Dao;


import com.example.immolocation.Model.Locataire;
import com.example.immolocation.Model.Propriete;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface LocataireRepository extends CrudRepository<Locataire, String> {

     @Query("SELECT u.montant_mensuel_a_payer FROM Locataire u WHERE u.login=?1")
               long montant_mentuel(String login);
      


               public Locataire findLocataireByPropriete(Propriete propriete);

               @Query("select u from Locataire u  where u.login=?1")
                  Locataire chercher_loc_parLOGIN(String  login);

                 public List<Locataire> findByPropriete(Propriete propriete);



    @Query("SELECT a.nom_Locataire, a.montant_mensuel_a_payer,r.dette FROM Locataire a " +
            "inner JOIN a.factures r WHERE r.dette>0 AND r.id_facture=(select max(r.id_facture) from r  ) ")
                            List<String> locataire_endettes();

}
