package com.example.immolocation.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Propriete implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id_propriete;
    private String description;
    private String localisation;
    private boolean disponible = true;
    private long prix;
    @ManyToOne
    private Bailleur bailleur;

    public Propriete(){
        super();
    }

    public Propriete( String description, String localisation, boolean disponible, long prix, Bailleur bailleur) {

        this.description = description;
        this.localisation = localisation;
        this.disponible = disponible;
        this.prix = prix;
        this.bailleur = bailleur;
    }

    public long getPrix() {
        return prix;
    }

    public Bailleur getBailleur() {
        return bailleur;
    }

    public void setBailleur(Bailleur bailleur) {
        this.bailleur = bailleur;
    }

    public long getId_propriete() {
        return id_propriete;
    }

    public void setId_propriete(long id_propriete) {
        this.id_propriete = id_propriete;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean statut) {
        this.disponible = statut;
    }

    public Long getPrix_lcation() {
        return prix;
    }

    public void setPrix_lcation(int prix_lcation) {
        this.prix = prix_lcation;
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
