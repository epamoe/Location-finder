package com.example.immolocation.Dao;

import com.example.immolocation.Model.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role,Integer> {

        public Role findByName(String name);
}
