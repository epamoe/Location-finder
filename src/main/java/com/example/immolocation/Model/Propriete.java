package com.example.immolocation.Model;

import javax.persistence.*;

@Entity
public class Propriete {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id_propriete;
    private String type;
    private boolean statut;
    private int prix_location;
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

    public int getPrix_location() {
        return prix_location;
    }

    public void setPrix_location(int prix_location) {
        this.prix_location = prix_location;
    }

    public Bailleur getBailleur() {
        return bailleur;
    }

    public void setBailleur(Bailleur bailleur) {
        this.bailleur = bailleur;
    }

    public Locataire getLocataire() {
        return locataire;
    }

    public void setLocataire(Locataire locataire) {
        this.locataire = locataire;
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