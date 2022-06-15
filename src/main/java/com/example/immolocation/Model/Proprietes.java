package com.example.immolocation.Model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

@Entity
public class Proprietes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private String Localisation;
	private String ville;
	private int prix;
	private boolean disponible;
	@Lob
    @Column(name = "Image", length = Integer.MAX_VALUE, nullable = true)
    private byte[] image;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false)
    private Date createDate;

	public Proprietes() {}

	public Proprietes(String name, String description, String localisation, String ville, int prix, boolean disponible, byte[] image, Date createDate) {
		this.name = name;
		this.description = description;
		Localisation = localisation;
		this.ville = ville;
		this.prix = prix;
		this.disponible = disponible;
		this.image = image;
		this.createDate = createDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocalisation() {
		return Localisation;
	}

	public void setLocalisation(String localisation) {
		Localisation = localisation;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Propriete{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", Localisation='" + Localisation + '\'' +
				", prix=" + prix +
				", image=" + Arrays.toString(image) +
				", createDate=" + createDate +
				'}';
	}



	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
}


