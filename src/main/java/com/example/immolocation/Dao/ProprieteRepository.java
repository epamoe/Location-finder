package com.example.immolocation.Dao;

import com.example.immolocation.Model.Bailleur;
import com.example.immolocation.Model.Propriete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.awt.event.PaintEvent;
import java.util.ArrayList;
import java.util.List;


public interface ProprieteRepository
        extends JpaRepository<Propriete, Long> {

    public Propriete findById(long id_propriete);

   /* @Query("update from propriete where ")
    public void updatePropriete(Propriete propriete);*/

    public List<Propriete> findAllByBailleur(Bailleur bailleur);

    @Query("select p from  Propriete p where p.prix >:x and p.prix <:y ")
    public List<Propriete> finfAllByPrix(@Param("x") Long prixInf,@Param("y")Long prixSup);

    @Query("select p from  Propriete p where p.ville like :x ")
    public List<Propriete> finfAllByRegion(@Param("x")String region);

    @Query("select p from  Propriete p where p.localisation like :x")
    public List<Propriete> finfAllByLocalisation(@Param("x")String localisation);



}
