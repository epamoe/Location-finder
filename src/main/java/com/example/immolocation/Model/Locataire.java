package com.example.immolocation.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class Locataire  extends User implements Serializable {
    // precise que l'attribut qui est juste en bas est l'identifiant
    private String nom_Locataire;
    private String Numero_cni;
    private int montant_mensuel_a_payer;
    private String Profession;
    private String contact;
    private LocalDateTime date_entree_locataire= LocalDateTime.now();


   @ManyToOne
    //faudra changer ce nom de table avec login_Bailleur
    private Bailleur bailleur;

    //liason de la table locataire a la table facture

    @OneToMany(mappedBy="locataire", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Facture> factures= new ArrayList<Facture>();

    //liason de la table locataire a la table propriete

        @OneToMany
        @JoinColumn(name="login_loc")
    private List<Propriete> propriete = new ArrayList<Propriete>();


}
