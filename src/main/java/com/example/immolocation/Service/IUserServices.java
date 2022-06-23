package com.example.immolocation.Service;

import com.example.immolocation.Model.User;

import java.util.List;

public interface IUserServices {


    public void ajouterUtilsateurRole(User user);
    public List<User> listAll();

    //retourne l'id de l'utilisateur
    public  Long id_utilisateur();

    public void ajouterUtilsateurRoleBailleur(User user);

}
