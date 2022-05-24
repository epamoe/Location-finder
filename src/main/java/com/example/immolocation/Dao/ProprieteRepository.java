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

    public ArrayList<Propriete> findAllByBailleur(Bailleur bailleur);
}
