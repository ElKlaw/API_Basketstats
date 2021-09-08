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
@Table(name="adresse")
@ApiModel(description = "Classe représentant une adresse")
public class Adresse {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Identifiant unique de l'adresse", example = "1", required = true, position = 0)
	private Integer id;
	
	@Column(name="numrue")
	@ApiModelProperty(notes = "Numéro de rue", position = 2)
	private String numRue;
	
	@Column(name="nomrue")
	@ApiModelProperty(notes = "Nom de la rue", position = 3)
	private String nomRue;
	
	@Column(name="longitude")
	@ApiModelProperty(notes = "Longitude", position = 4)
	private String longitude;
	
	@Column(name="latitude")
	@ApiModelProperty(notes = "Latitude", position = 5)
	private String latitude;
	
	@Column(name="codepostal")
	@ApiModelProperty(notes = "Code postal de la ville", position = 5)
	private int codePostal;
	
	@Column(name="nom")
	@ApiModelProperty(notes = "Nom de la ville", position = 1)
	private String ville;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumRue() {
		return numRue;
	}

	public void setNumRue(String numRue) {
		this.numRue = numRue;
	}

	public String getNomRue() {
		return nomRue;
	}

	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	
	
	
}
