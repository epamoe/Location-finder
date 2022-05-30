package com.example.immolocation.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Locataire extends User  implements Serializable {
    // precise que l'attribut qui est juste en bas est l'identifiant
    @GeneratedValue(strategy= GenerationType.IDENTITY) //genere les valeurs de l'id automatiquement de un a un
@Id
    private String nom_Locataire;
    private String Numero_cni;
    private int montant_mensuel_a_payer;
    private LocalDateTime date_entree_locataire= LocalDateTime.now();

//liason de la table locataire a la table facture



        @ManyToOne
        @JoinColumn(name="Id_Bailleur")
       private Bailleur bailleur;

//liason de la table locataire a la table facture

        @OneToMany(mappedBy="locataire", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Facture> factures= new ArrayList<Facture>();

    //liason de la table locataire a la table propriete

        @OneToMany
    private List<Propriete> propriete = new ArrayList<Propriete>();
        //constructeur
    public Locataire(){

    }

    public Locataire(String nom_Locataire, String numero_cni, int montant_mensuel_a_payer, LocalDateTime date_entree_locataire, Bailleur bailleur, List<Facture> factures, List<Propriete> propriete) {
        this.nom_Locataire = nom_Locataire;
        Numero_cni = numero_cni;
        this.montant_mensuel_a_payer = montant_mensuel_a_payer;
        this.date_entree_locataire = date_entree_locataire;
        this.bailleur = bailleur;
        this.factures = factures;
        this.propriete = propriete;
    }

    public Locataire(Long user_id, String login, String mot_de_passe, List<Role> roles, String nom_Locataire, String numero_cni, int montant_mensuel_a_payer, LocalDateTime date_entree_locataire, Bailleur bailleur, List<Facture> factures, List<Propriete> propriete) {
        super(user_id, login, mot_de_passe, roles);
        this.nom_Locataire = nom_Locataire;
        Numero_cni = numero_cni;
        this.montant_mensuel_a_payer = montant_mensuel_a_payer;
        this.date_entree_locataire = date_entree_locataire;
        this.bailleur = bailleur;
        this.factures = factures;
        this.propriete = propriete;
    }

    public String getNumero_cni() {
        return Numero_cni;
    }

    public Bailleur getBailleur() {
        return bailleur;
    }

    public void setBailleur(Bailleur bailleur) {
        this.bailleur = bailleur;
    }

    public List<Facture> getFactures() {
        return factures;
    }

    public void setFactures(List<Facture> factures) {
        this.factures = factures;
    }

    public List<Propriete> getPropriete() {
        return propriete;
    }

    public void setPropriete(List<Propriete> propriete) {
        this.propriete = propriete;
    }

    public void setNumero_cni(String numero_cni) {
        Numero_cni = numero_cni;
    }

    public String getNom_Locataire() {
        return nom_Locataire;
    }

    public void setNom_Locataire(String nom_bailleur) {
        this.nom_Locataire = nom_bailleur;
    }

    public int getMontant_mensuel_a_payer() {
        return montant_mensuel_a_payer;
    }

    public void setMontant_mensuel_a_payer(int montant_mensuel_a_payer) {
        this.montant_mensuel_a_payer = montant_mensuel_a_payer;
    }

    public LocalDateTime getDate_entree_locataire() {
        return date_entree_locataire;
    }

    public void setDate_entree_locataire(LocalDateTime date_entree_locataire) {
        this.date_entree_locataire = date_entree_locataire;
    }
}
