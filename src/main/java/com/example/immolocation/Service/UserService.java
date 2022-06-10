package com.example.immolocation.Service;

import com.example.immolocation.Dao.RoleRepository;
import com.example.immolocation.Dao.UserRepository;
import com.example.immolocation.Model.Role;
import com.example.immolocation.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserServices {

        private  User user;
    private UserRepository userRepository;

    private RoleRepository roleRepository;

    public UserService( UserRepository userRepository, RoleRepository roleRepository) {

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public void ajouterUtilsateurRole(User user){

        BCryptPasswordEncoder crypte= new BCryptPasswordEncoder();
        String mot_de_passe_code= crypte.encode(user.getMot_de_passe());
        user.setMot_de_passe( mot_de_passe_code);

        Role RoleUser = roleRepository.findByName("Locataire");
        user.addRole(RoleUser);
        userRepository.save(user);
    }

    public void ajouterUtilsateurRoleBailleur(User user){

        BCryptPasswordEncoder crypte= new BCryptPasswordEncoder();
        String mot_de_passe_code= crypte.encode(user.getMot_de_passe());
        user.setMot_de_passe( mot_de_passe_code);

        Role RoleUser = roleRepository.findByName("Bailleur");
        user.addRole(RoleUser);
        userRepository.save(user);
    }

    public  Long id_utilisateur(){
        return user.getUser_id();

    }
    public List<User> listAll(){
        return userRepository.findAll();
    }
}
