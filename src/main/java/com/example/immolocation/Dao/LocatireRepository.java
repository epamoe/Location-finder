package com.example.immolocation.Dao;


import com.example.immolocation.Model.Locataire;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface LocatireRepository extends CrudRepository<Locataire, Long> {
      @Query("SELECT u.montant_mensuel_a_payer FROM Locataire u WHERE u.id_locataire=?1")
               long montant_mentuel(long id);

                  Locataire findById(long Id);
}
