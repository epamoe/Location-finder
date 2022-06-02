package com.example.immolocation.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
public class Image implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Lob
    @Column(columnDefinition="MEDIUMBLOB")
    String image;

    @ManyToOne
    private Propriete propriete;

    public Image() {

    }

    public Image(String name, String image, Propriete propriete) {
        this.name = name;
        this.image = image;
        this.propriete = propriete;
    }

    public Propriete getPropriete() {
        return propriete;
    }

    public void setPropriete(Propriete propriete) {
        this.propriete = propriete;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
