package com.example.immolocation.Dao;

import com.example.immolocation.Model.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {

    @Query("SELECT a FROM Facture a inner join Locataire b WHERE b.login= ?1")
    List<Facture> liste_facture(String login);

    @Query("SELECT a FROM Facture a inner JOIN a.locataire r where r.login=?1  order by a.id_facture desc " )
                        List<Facture> dernier_facture_loc(String login);

}


