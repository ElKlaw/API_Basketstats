package application.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="equipe")
@ApiModel(description = "Classe représentant une équipe")
public class Equipe {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Identifiant unique de l'équipe", example = "1", required = true, position = 0)
	private Integer id;
	
	@Column(name="saison")
	@ApiModelProperty(notes = "Année de début de la saison", example = "2017", position = 1)
	private int saison;
	
	@Column(name="phase", nullable = true)
	@ApiModelProperty(notes = "Phase du championnat", example = "2", position = 2)
	private Integer phase;
	
	@Column(name="nom")
	@ApiModelProperty(notes = "Nom de l'équipe", example = "Equipe Séniors DM2", position = 3)
	private String nom;
	
	@Column(name="categorie")
	@ApiModelProperty(notes = "Catégorie de l'équipe", example = "U20", position = 4)
	private String categorie;
	
	@Column(name="sexe")
	@ApiModelProperty(notes = "Sexe de l'équipe", example = "Masculin ou Feminin", position = 5)
	private String sexe;
	
	@Column(name="niveau")
	@ApiModelProperty(notes = "Niveau de l'équipe", example = "Départemental", position = 6)
	private String niveau;
	
	@Column(name="division")
	@ApiModelProperty(notes = "Division de l'équipe", example = "4", position = 7)
	private String division;
	
	@Column(name="poule")
	@ApiModelProperty(notes = "Poule de l'équipe", example = "A", position = 8)
	private String poule;
	
	@Column(name="photo")
	private int photo;
	
	@ManyToMany(mappedBy="equipes")
	@JsonIgnore
	private Set<Joueur> joueurs = new HashSet<>();
	
	@ManyToMany(mappedBy="invitationequipes")
	@JsonIgnore
	private Set<Invitation> invitations = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name="idclub")
	private Club clubEquipe;
	
	public Equipe() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getSaison() {
		return saison;
	}

	public void setSaison(int saison) {
		this.saison = saison;
	}

	public Integer getPhase() {
		return phase;
	}

	public void setPhase(Integer phase) {
		this.phase = phase;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getPoule() {
		return poule;
	}

	public void setPoule(String poule) {
		this.poule = poule;
	}

	public Set<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(Set<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	public Set<Invitation> getInvitations() {
		return invitations;
	}

	public void setInvitations(Set<Invitation> invitations) {
		this.invitations = invitations;
	}

	public Club getClubEquipe() {
		return clubEquipe;
	}

	public void setClubEquipe(Club clubEquipe) {
		this.clubEquipe = clubEquipe;
	}

	public int getPhoto() {
		return photo;
	}

	public void setPhoto(int photo) {
		this.photo = photo;
	}

	

}

