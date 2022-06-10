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
<<<<<<< HEAD
    // @Column(name="Image",length = Integer.MAX_VALUE, nullable = true);
    private byte[] image;
   private Date date;

    @ManyToOne
    @JoinColumn(name = "id_propriete")
    private Propriete propriete;


    public Image(String name, byte[] image) {
        this.name = name;
        this.image = image;
       this.date = new Date();
        this.propriete = propriete;
    }
=======
    @Column(columnDefinition="MEDIUMBLOB")
    String image;

    @ManyToOne
    private Propriete propriete;
>>>>>>> 15d4ac3189412932c2318b6a23d1c04d0dbe1eba

    public Image() {

    }

    public Image( String image, Propriete propriete) {
        this.image = image;
<<<<<<< HEAD
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
=======
        this.propriete = propriete;
>>>>>>> 15d4ac3189412932c2318b6a23d1c04d0dbe1eba
    }

    public Propriete getPropriete() {
        return propriete;
    }

    public void setPropriete(Propriete propriete) {
        this.propriete = propriete;
    }
<<<<<<< HEAD
=======

    public Long getId() {
        return id;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
>>>>>>> 15d4ac3189412932c2318b6a23d1c04d0dbe1eba
}
