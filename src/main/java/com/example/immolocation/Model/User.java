package com.example.immolocation.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

@Entity
@Table(name="users")
@Inheritance
public class User  implements Serializable {
 @Id
 @GeneratedValue(strategy= GenerationType.IDENTITY)
 private Long user_id;
 @Column(unique = true )
protected String login;
protected String mot_de_passe;

 @ManyToMany(fetch = FetchType.EAGER)
 @JoinTable(name="User_Role",
            joinColumns= @JoinColumn(name ="User_id"),
            inverseJoinColumns =@JoinColumn(name="Role_id")
            )
 private List<Role> roles = new ArrayList<>();

    public void addRole(Role role)
    {
        this.roles.add(role);

    }
 public User(){}

    public User(Long user_id, String login, String mot_de_passe, List<Role> roles) {
        this.user_id = user_id;
        this.login = login;
        this.mot_de_passe = mot_de_passe;
        this.roles = roles;
    }

    public  Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
