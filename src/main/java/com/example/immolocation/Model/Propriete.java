package com.example.immolocation.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Propriete implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id_propriete;
    private String description="non precisé";
    private String localisation="non precisé";
    private String region="non precisé";
    private boolean disponible=true;
    private int prix=0;


    private Date date;

    public Propriete(Date date,String description, String localisation, String region, int prix) {

        this.description = description;
        this.localisation = localisation;
        this.region = region;
        this.disponible = true;
        this.prix = prix;
        this.date =date;
    }


    public boolean isDisponible() {
        return disponible;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    //***********************************************************************
    @ManyToOne
    @JoinColumn(name = "id_bailleur")
    private Bailleur bailleur;

    public Propriete(){
        super();
    }

    public Propriete(String description, String localisation, String region, boolean disponible, int prix,Bailleur bailleur) {
        this.description = description;
        this.localisation = localisation;
        this.region = region;
        this.disponible = disponible;
        this.prix = prix;
        this.bailleur=bailleur;

    }


    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setPrix(int prix) {
        this.prix = prix;
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

    public int getPrix_lcation() {
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


    public String toString() {
        return "Propriete{" +
                "id_propriete=" + id_propriete +
                ", description='" + description + '\'' +
                ", localisation='" + localisation + '\'' +
                ", region='" + region + '\'' +
                ", disponible=" + disponible +
                ", prix=" + prix +
                ", date=" + date +
                ", bailleur=" + bailleur +
                '}';
    }


}
