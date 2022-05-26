package com.example.immolocation.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Propriete implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id_propriete;
    private String name="inconnue";
    private String description="inconnue";
    private String localisation="inconnue";
    private String region="inconnue";
    private boolean disponible=true;
    private long prix=0;
  //********************************************************************************************************************
    @Lob
    // @Column(name="Image",length = Integer.MAX_VALUE, nullable = true);
    private byte[] image;
    private Date date;

    public Propriete(String nom,String description, String localisation, String region,Date date, boolean disponible, long prix, byte[] image) {
        this.name=nom;
        this.description = description;
        this.localisation = localisation;
        this.region = region;
        this.disponible = disponible;
        this.prix = prix;
        this.image = image;
        this.date =date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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

    public Propriete(String description, String localisation, String region, boolean disponible, long prix) {
        this.description = description;
        this.localisation = localisation;
        this.region = region;
        this.disponible = disponible;
        this.prix = prix;

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

    public void setPrix(long prix) {
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
