package application.bean;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="joueur")
@ApiModel(description = "Classe représentant un joueur")
public class Joueur {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Identifiant unique du Joueur", example = "1", required = true, position = 0)
	private Integer id;
	
	@Column(name="nom")
	@ApiModelProperty(notes = "Nom du joueur", position = 1)
	private String nom;
	
	@Column(name="prenom")
	@ApiModelProperty(notes = "Prénom du joueur", position = 2)
	private String prenom;
	
	@Column(name="sexe")
	@ApiModelProperty(notes = "Sexe du joueur", position = 3)
	private String sexe;
	
	@Column(name="datenaissance")
	@ApiModelProperty(notes = "Date de naissance du joueur", example="15-06-1995", position = 4)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate dateNaissance;
	
	
	@ManyToMany
	@JoinTable(name="joueurequipe",
		joinColumns= {@JoinColumn(name= "idjoueur", referencedColumnName="id")},
		inverseJoinColumns= {@JoinColumn(name="idequipe", referencedColumnName="id")})
	private Set<Equipe> equipes = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name="joueurclub",
		joinColumns= {@JoinColumn(name= "idjoueur", referencedColumnName="id")},
		inverseJoinColumns= {@JoinColumn(name="idclub", referencedColumnName="id")})
	private Set<Club> clubs = new HashSet<>();
	
	public Joueur() {
		super();
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Set<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(Set<Equipe> equipes) {
		this.equipes = equipes;
	}

	public Set<Club> getClubs() {
		return clubs;
	}

	public void setClubs(Set<Club> clubs) {
		this.clubs = clubs;
	}	
	
	// Add and remove
	public void addClub(Club club) {
		clubs.add(club);
		club.getJoueurs().add(this);
	}
	public void removeClub(Club club) {
		clubs.remove(club);
		club.getJoueurs().remove(this);
	}
	
	public void addEquipe(Equipe equipe) {
		equipes.add(equipe);
		equipe.getJoueurs().add(this);
	}
	public void removeEquipe(Equipe equipe) {
		equipes.remove(equipe);
		equipe.getJoueurs().remove(this);
	}
	
}
