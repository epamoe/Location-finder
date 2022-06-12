package com.example.immolocation.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Getter
@Setter
public class Image implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob

    // @Column(name="Image",length = Integer.MAX_VALUE, nullable = true);
    private byte[] image;
   private Date date;

    @ManyToOne
    @JoinColumn(name = "id_propriete")
    private Propriete propriete;



/*

    public Image() {

    }

    public Image( String image, Propriete propriete) {
        this.image = image;

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;

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
*/
}
