package com.example.immolocation.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Bailleur extends User  implements Serializable   {
@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String nom_bailleur;
    private String prenom_bailleur;
    private String Numero_cni;
    public String Numero_de_telephone;

    @OneToMany(mappedBy="bailleur")
    private Collection<Propriete> propriete;

    @OneToMany(mappedBy="bailleur")
    private List<Locataire> locataire =new ArrayList<Locataire>();


    public Bailleur() {

    }

    public Bailleur(String nom_bailleur, String prenom_bailleur, String numero_cni, String numero_de_telephone, Collection<Propriete> propriete, List<Locataire> locataire) {
        this.nom_bailleur = nom_bailleur;
        this.prenom_bailleur = prenom_bailleur;
        Numero_cni = numero_cni;
        Numero_de_telephone = numero_de_telephone;
        this.propriete = propriete;
        this.locataire = locataire;
    }

    public Bailleur(Long user_id, String login, String mot_de_passe, List<Role> roles, String nom_bailleur, String prenom_bailleur, String numero_cni, String numero_de_telephone, Collection<Propriete> propriete, List<Locataire> locataire) {
        super(user_id, login, mot_de_passe, roles);
        this.nom_bailleur = nom_bailleur;
        this.prenom_bailleur = prenom_bailleur;
        Numero_cni = numero_cni;
        Numero_de_telephone = numero_de_telephone;
        this.propriete = propriete;
        this.locataire = locataire;
    }

    public String getNumero_cni() {
        return Numero_cni;
    }

    public void setNumero_cni(String numero_cni) {
        Numero_cni = numero_cni;
    }

    public Collection<Propriete> getPropriete() {
        return propriete;
    }

    public void setPropriete(Collection<Propriete> propriete) {
        this.propriete = propriete;
    }


    public String getNom_bailleur() {
        return nom_bailleur;
    }

    public void setNom_bailleur(String nom_bailleur) {
        this.nom_bailleur = nom_bailleur;
    }

    public String getPrenom_bailleur() {
        return prenom_bailleur;
    }

    public void setPrenom_bailleur(String prenom_bailleur) {
        this.prenom_bailleur = prenom_bailleur;
    }

    public List<Locataire> getLocataire() {
        return locataire;
    }

    public void setLocataire(List<Locataire> locataire) {
        this.locataire = locataire;
    }
}
