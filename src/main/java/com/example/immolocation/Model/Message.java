package com.example.immolocation.Model;

import java.util.Date;

public class Message {
    private String nom_expediteur;
    private String nom_recepteur;

    public String getNom_expediteur() {
        return nom_expediteur;
    }

    public void setNom_expediteur(String nom_expediteur) {
        this.nom_expediteur = nom_expediteur;
    }

    public String getNom_recepteur() {
        return nom_recepteur;
    }

    public void setNom_recepteur(String nom_recepteur) {
        this.nom_recepteur = nom_recepteur;
    }

    public Date getDate_envoi() {
        return date_envoi;
    }

    public void setDate_envoi(Date date_envoi) {
        this.date_envoi = date_envoi;
    }

    private Date date_envoi;
}
