package com.example.immolocation.Model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Component
@Entity
public class Facture {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id_facture;
    private String date_Facturation= LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    private  int montant=0 ;
    private int avance=0;
    private int surplus=0;
    private int dette=0;

    // liaison de tables

  @ManyToOne
  @JoinColumn(name="Id_Locataire")
  private Locataire locataire;
  // getters et setters

    //public void attribuer_Facture(Locataire locataire){


    public Facture() {
    }

    public Facture(int id_facture, String date_Facturation, int montant, int avance, int surplus, int dette, Locataire locataire) {
        this.id_facture = id_facture;
        this.date_Facturation = date_Facturation;
        this.montant = montant;
        this.avance = avance;
        this.surplus = surplus;
        this.dette = dette;
        this.locataire = locataire;
    }

    public String getDate_Facturation() {
        return date_Facturation;
    }

    public void setDate_Facturation(String date_Facturation) {
        this.date_Facturation = date_Facturation;
    }

    public Locataire getLocataire() {
        return locataire;
    }

    public void setLocataire(Locataire locataire) {
        this.locataire = locataire;
    }

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
