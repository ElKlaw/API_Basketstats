package application.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="Niveau")
@ApiModel(description="classe représentant les différents niveau de l'application")
public class Niveau {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Identifiant unique de la présence", example = "1", required = true, position = 0)
	private Integer id;
	
	@Column(name="nom")
	@ApiModelProperty(notes = "", example = "", position = 1)
	private String nom;
	
	@ManyToOne
	@JoinColumn(name="idsport")
	@JsonIgnore
	private Sport sport;
	
	@OneToMany(mappedBy="niveau")
	private Set<Division> divisions = new HashSet<>();

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

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	public Set<Division> getDivisions() {
		return divisions;
	}

	public void setDivisions(Set<Division> divisions) {
		this.divisions = divisions;
	}
}
