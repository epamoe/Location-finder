package com.example.immolocation.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Bailleur  implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id_bailleur;
    private String nom_bailleur;
    private String prenom_bailleur;
    private int age;
    private String Login;
    private String mot_de_passe;


    @OneToMany(mappedBy="bailleur")
    private Collection<Propriete> propriete;

    @OneToMany(mappedBy="bailleur")
    private List<Locataire> locataire =new ArrayList<Locataire>();


    public Bailleur() {

    }

    public Bailleur(int id_bailleur, String nom_bailleur, String prenom_bailleur, int age, String mot_de_passe, String login, Collection<Propriete> propriete, List<Locataire> locataire) {
        this.id_bailleur = id_bailleur;
        this.nom_bailleur = nom_bailleur;
        this.prenom_bailleur = prenom_bailleur;
        this.age = age;
        this.mot_de_passe = mot_de_passe;
        Login = login;
        this.propriete = propriete;
        this.locataire = locataire;
    }

    // getters et setters



    public Collection<Propriete> getPropriete() {
        return propriete;
    }

    public void setPropriete(Collection<Propriete> propriete) {
        this.propriete = propriete;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

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

    public List<Locataire> getLocataire() {
        return locataire;
    }

    public void setLocataire(List<Locataire> locataire) {
        this.locataire = locataire;
    }
}
