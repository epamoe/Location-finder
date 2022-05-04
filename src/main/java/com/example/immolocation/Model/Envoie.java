package com.example.immolocation.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.sql.Date;

@Entity
public class Envoie {
    @Id
    private Date date_envoie_facture;

    //liason de table

    @OneToOne(mappedBy = "envoie")
    private  Facture facture;

    @ManyToOne
    private Bailleur bailleur;

    // getters et setters

    public Date getDate_envoie_facture() {
        return date_envoie_facture;
    }

    public void setDate_envoie_facture(Date date_envoie_facture) {

        this.date_envoie_facture = date_envoie_facture;
    }

}
