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
    // @Column(name="Image",length = Integer.MAX_VALUE, nullable = true);
    private byte[] image;
   /* private Date date;
    @ManyToOne
    @JoinColumn(name = "id_propriete")
    private Propriete propriete;*/


    public Image(String name, byte[] image) {
        this.name = name;
        this.image = image;
      /*  this.date = new Date();
        this.propriete = propriete;*/
    }

    public Image() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    /*public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Propriete getPropriete() {
        return propriete;
    }

    public void setPropriete(Propriete propriete) {
        this.propriete = propriete;
    }*/
}
