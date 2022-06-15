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
    @Column(columnDefinition="MEDIUMLOB")
    private String image;

    @ManyToOne()
     private  Propriete propriete;
    // @Column(name="Image",length = Integer.MAX_VALUE, nullable = true);


}
