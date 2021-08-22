package application.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="Photo")
@ApiModel(description="classe représentant les différents photo de l'application")
public class Photo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Identifiant unique de la photo", example = "1", required = true, position = 0)
	private Integer id;
	
	@Column(name="nom")
	@ApiModelProperty(notes = "", example = "", position = 1)
	private String nom;
	
	@Column(name="extension")
	@ApiModelProperty(notes = "", example = "", position = 2)
	private String extension;
	
	@Column(name="data")
	@ApiModelProperty(notes = "", example = "", position = 3)
	private byte[] data;

	
	public Photo() {
		super();
	}

	public Photo(String nom, String extension, byte[] data) {
		super();
		this.nom = nom;
		this.extension = extension;
		this.data = data;
	}

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

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
		
}
