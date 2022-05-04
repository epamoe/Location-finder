package com.example.immolocation.Model;

import javax.persistence.*;

@Entity
public class Propriete {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id_propriete;
    private String type;
    private boolean statut;
    private int prix_lcation;
    private String description;
    private String localisation;

    //liaison des tables

    @ManyToOne
    private Bailleur bailleur;
    @ManyToOne
    private Locataire locataire;

    //getter et setter

    public long getId_propriete() {
        return id_propriete;
    }

    public void setId_propriete(long id_propriete) {
        this.id_propriete = id_propriete;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public int getPrix_lcation() {
        return prix_lcation;
    }

    public void setPrix_lcation(int prix_lcation) {
        this.prix_lcation = prix_lcation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }
}