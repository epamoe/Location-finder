package com.example.immolocation.Dao;

import com.example.immolocation.Model.Image;
import com.example.immolocation.Model.Propriete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository
        extends JpaRepository<Image,Long> {
    List<Image> findByPropriete(Propriete propriete);

}
