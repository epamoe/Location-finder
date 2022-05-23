package com.example.immolocation.Dao;

import com.example.immolocation.Model.Bailleur;
import com.example.immolocation.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String Login);
}
