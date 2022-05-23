package com.example.immolocation.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="roles")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer role_id;
    String name;
    public Role(){

    }

    public Role(Integer role_id) {
        this.role_id = role_id;

    }

    public Role(String name) {

        this.name = name;
    }

    public Role(Integer role_id, String name) {
        this.role_id = role_id;
        this.name = name;
    }

    @Override
    public String  toString() {
        return this.name;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer id_Roles) {
        this.role_id = id_Roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
