package com.example.immolocation.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Propriete implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id_propriete;
    private String name;
    private String description="non precisé";
    private String localisation="non precisé";
    private String ville ="non precisé";
    private boolean disponible=true;
    private int prix=0;
    private Date date;
    //***********************************************************************
    @ManyToOne
    @JoinColumn(name = "id_bailleur")
    private Bailleur bailleur;


    public Propriete(String name, String description, String localisation, String ville, String etat, int prix, Date date, Bailleur bailleur) {
        this.name = name;
        this.description = description;
        this.localisation = localisation;
        this.ville = ville;

        if(etat.equalsIgnoreCase("LA PROPRIETE N'EST PAS OCCUPEE PAR UN LOCATAIRE")){
            this.disponible = true;
        }
        else{
            this.disponible=false;
        }

        this.prix = prix;
        this.date = date;
        this.bailleur = bailleur;
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


    public Propriete(){
        super();
    }

    public Propriete(String description, String localisation, String region, boolean disponible, int prix,Bailleur bailleur) {
        this.description = description;
        this.localisation = localisation;
        this.ville = region;
        this.disponible = disponible;
        this.prix = prix;
        this.bailleur=bailleur;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String region) {
        this.ville = region;
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
                ", region='" + ville + '\'' +
                ", disponible=" + disponible +
                ", prix=" + prix +
                ", date=" + date +
                ", bailleur=" + bailleur +
                '}';
    }


}
