package application.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="lieu")
@ApiModel(description = "Classe représentant un lieu de rendez-vous")
public class Lieu {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Identifiant unique du lieu", example = "1", required = true, position = 0)
	private Integer id;
	
	@Column(name="nom")
	@ApiModelProperty(notes = "Nom", position = 2)
	private String nom;
	
	@Column(name="salle")
	@ApiModelProperty(notes = "Est-ce une salle ?", position = 3)
	private boolean salle;
	
	@ManyToOne
	@JoinColumn(name="idadresse")
	private Adresse adresse;
	
	@ManyToOne
	@JoinColumn(name="idclub")
	private Club clubSalle;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public boolean isSalle() {
		return salle;
	}

	public void setSalle(boolean salle) {
		this.salle = salle;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Club getClubSalle() {
		return clubSalle;
	}

	public void setClubSalle(Club clubSalle) {
		this.clubSalle = clubSalle;
	}

	
}
