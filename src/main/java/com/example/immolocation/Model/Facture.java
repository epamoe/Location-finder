package com.example.immolocation.Model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Facture {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id_facture;
    private Date date_Facturation;
    private  int montant ;
    private int avance;
    private int surplus;
    private int dette;

    // liaison de tables

    @OneToOne
    private Envoie envoie;

  // getters et setters

    public int getDette() {
        return dette;
    }

    public void setDette(int dette) {
        this.dette = dette;
    }

    public int getId_facture() {
        return id_facture;
    }

    public void setId_facture(int id_facture) {
        this.id_facture = id_facture;
    }

    public Date getDate_Facturation() {
        return date_Facturation;
    }

    public void setDate_Facturation(Date date_facturation) {
        this.date_Facturation = date_facturation;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public int getAvance() {
        return avance;
    }

    public void setAvance(int avance) {
        this.avance = avance;
    }

    public int getSurplus() {
        return surplus;
    }

    public void setSurplus(int surplus) {
        this.surplus = surplus;
    }


}
