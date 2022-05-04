package com.example.immolocation.Model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Bailleur {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id_bailleur;
    private String nom_bailleur;
    private String prenom_bailleur;
    private int age;

    // liaison des tables
    @OneToMany(mappedBy="bailleur")
    private Collection<Envoie> envoie;

    @OneToMany(mappedBy="bailleur")
    private Collection<Propriete> propriete;

    // getters et setters

    public int getId_bailleur() {
        return id_bailleur;
    }

    public void setId_bailleur(int id_bailleur) {
        this.id_bailleur = id_bailleur;
    }

    public String getNom_bailleur() {
        return nom_bailleur;
    }

    public void setNom_bailleur(String nom_bailleur) {
        this.nom_bailleur = nom_bailleur;
    }

    public String getPrenom_bailleur() {
        return prenom_bailleur;
    }

    public void setPrenom_bailleur(String prenom_bailleur) {
        this.prenom_bailleur = prenom_bailleur;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
