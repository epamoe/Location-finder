package com.example.immolocation.Service;


import com.example.immolocation.Model.Bailleur;

public interface IBailleurServices {

    //retourne un objet bailleur
    public Bailleur rechercherBailleurParId(Long id);
}
