package com.example.immolocation.Dao;


import com.example.immolocation.Model.Bailleur;
import com.example.immolocation.Model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface  BailleurRepository extends CrudRepository<Bailleur, Long> {


}
