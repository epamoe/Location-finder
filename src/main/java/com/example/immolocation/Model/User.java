package com.example.immolocation.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="users")
public class User implements Serializable {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
 private Long id;
@Column(unique = true )
@Id
protected String login;
protected String mot_de_passe;

 @ManyToMany(fetch = FetchType.EAGER)
 @JoinTable(name="User_Role",
            joinColumns= @JoinColumn(name ="users_login"),
            inverseJoinColumns =@JoinColumn(name="roles_role")
            )
 private List<Role> roles = new ArrayList<>();

    public void addRole(Role role)
    {
        this.roles.add(role);

    }

}
