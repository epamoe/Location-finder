package com.example.immolocation.Dao;

import com.example.immolocation.Model.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import javax.persistence.NamedNativeQuery;
import java.util.List;
@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {
    @Query("SELECT a FROM Facture a, Locataire b WHERE b.id_locataire= ?1")
    List<Facture> liste_facture(int Id_Locataire);
}

