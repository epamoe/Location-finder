package com.example.immolocation.Model;

import jdk.jfr.DataAmount;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
@Data
@Entity
public class Bailleur  implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_bailleur;
    private String nom_bailleur;
    private String prenom_bailleur;
    private String telephone;
    private String ncni;




   /* @OneToMany(mappedBy="bailleur")
    private Collection<Propriete> propriete;

    @OneToMany(mappedBy="bailleur")
    private List<Locataire> locataire =new ArrayList<Locataire>();

*/
    public Bailleur() {

    }

    public Bailleur(String nom_bailleur, String prenom_bailleur, String telephone, String ncni) {
        this.nom_bailleur = nom_bailleur;
        this.prenom_bailleur = prenom_bailleur;
        this.telephone = telephone;
        this.ncni = ncni;
    }
}
