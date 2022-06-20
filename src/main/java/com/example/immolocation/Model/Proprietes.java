package com.example.immolocation.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@Entity
public class Proprietes {
/*
	private long id_propriete;
	private String name;
	private String description="non precisé";
	private String localisation="non precisé";
	private String ville ="non precisé";
	private boolean disponible=true;
	private int prix=0;
	private Date date;*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private String Localisation;
	private boolean disponible=true;
	//private String ville;
	private int prix;
	//private boolean disponible;
	@Lob
    @Column(name = "Image", length = Integer.MAX_VALUE, nullable = true)
    private byte[] image;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false)
    private Date createDate;
	@ManyToOne
	private Bailleur bailleur;

	public Proprietes() {}


}


