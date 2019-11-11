package application.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="ville")
@ApiModel(description = "Classe représentant une ville")
public class Ville {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Identifiant unique de la ville", example = "1", required = true, position = 0)
	private Integer id;
	
	@Column(name="nom")
	@ApiModelProperty(notes = "Nom de la ville", position = 1)
	private String nom;
	
	@Column(name="codedepartement")
	@ApiModelProperty(notes = "Code de département de la ville", position = 2)
	private String codeDepartement;
	
	@Column(name="departement")
	@ApiModelProperty(notes = "Département de la ville", position = 3)
	private String departement;
	
	@Column(name="region")
	@ApiModelProperty(notes = "Région de la ville", position = 4)
	private String region;
	
	@Column(name="codepostal")
	@ApiModelProperty(notes = "Code postal de la ville", position = 5)
	private int codePostal;
	
	@Column(name="pays")
	@ApiModelProperty(notes = "Pays de la ville", position = 6)
	private String pays;
	
	@ManyToMany(mappedBy="villes")
	@JsonIgnore
	private Set<Club> clubs = new HashSet<>();

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

	public String getCodeDepartement() {
		return codeDepartement;
	}

	public void setCodeDepartement(String codeDepartement) {
		this.codeDepartement = codeDepartement;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public Set<Club> getClubs() {
		return clubs;
	}

	public void setClubs(Set<Club> clubs) {
		this.clubs = clubs;
	}
}
