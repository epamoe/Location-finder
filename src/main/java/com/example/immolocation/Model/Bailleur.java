package com.example.immolocation.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Bailleur extends User  implements Serializable   {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String nom_bailleur;
    private String prenom_bailleur;
    private String Numero_cni;
    public String Numero_de_telephone;

    @OneToMany(mappedBy="bailleur")
    private Collection<Propriete> propriete;

    @OneToMany()
    private List<Locataire> locataire =new ArrayList<Locataire>();

}
