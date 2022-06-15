package com.example.immolocation.Dao;

import com.example.immolocation.Model.Proprietes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProprietesRepository extends JpaRepository<Proprietes, Long>{

}

