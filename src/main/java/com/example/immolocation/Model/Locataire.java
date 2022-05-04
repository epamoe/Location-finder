package com.example.immolocation.Model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Locataire {
    @Id          // precise que l'attribut qui est juste en bas est l'identifiant
    @GeneratedValue(strategy= GenerationType.IDENTITY) //genere les valeurs de l'id automatiquement de un a un
    private int id_locataire;
    private String nom_bailleur;
    private String prenom_bailleur;
    private int age;
    private String mot_de_passe;

    @OneToMany(mappedBy="locataire")    //pour les liaisons des tables dit qui s'agit d'une relation un a plusieurs
    private Collection<Propriete> propriete;


    public int getId_locataire() {
        return id_locataire;
    }

    public void setId_locataire(int id_locataire) {
        this.id_locataire = id_locataire;
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
