package com.example.immolocation.Model;

import javax.transaction.Status;///////////////////////
import java.util.Date;

public class Message {
    private String nom_expediteur;
    private String nom_recepteur;
    private String message;
    private String date;
    private Status status;///////////////////////Attention a son pakage

    public Message(){

    }

    public Message(String nom_expediteur, String nom_recepteur, String message, String date, Status status) {
        this.nom_expediteur = nom_expediteur;
        this.nom_recepteur = nom_recepteur;
        this.message = message;
        this.date = date;
        this.status = status;
    }

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Message{" +
                "nom_expediteur='" + nom_expediteur + '\'' +
                ", nom_recepteur='" + nom_recepteur + '\'' +
                ", message='" + message + '\'' +
                ", date='" + date + '\'' +
                ", status=" + status +
                '}';
    }
}
