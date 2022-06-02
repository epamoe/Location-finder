package com.example.immolocation.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
public class Image implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(columnDefinition="MEDIUMBLOB")
    String image;

    @ManyToOne
    private Propriete propriete;

    public Image() {

    }

    public Image( String image, Propriete propriete) {
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


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
