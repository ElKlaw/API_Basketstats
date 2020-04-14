package application.bean;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="club")
@ApiModel(description = "Classe représentant un Club")
public class Club {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Identifiant unique du Club", example = "1", required = true, position = 0)
	private Integer id;
	
	@Column(name="codeclub")
	@ApiModelProperty(notes = "Code identifiant du Club via la Fédération", example = "PDL0049152", position = 1)
	private String codeClub;
	
	@Column(name="url")
	private String url;
	
	@Column(name="nomcomplet")
	private String nomcomplet;
	
	@Column(name="nom")
	@ApiModelProperty(notes = "Nom du club", position = 2)
	private String nom;
	
	@Column(name="sport")
	@ApiModelProperty(notes = "Sport pratiqué par le club", position = 3)
	private String sport;
	
	@OneToMany(mappedBy="clubEquipe")
	@JsonIgnore
	private Set<Equipe> equipes = new HashSet<>();
	
	@OneToMany(mappedBy="clubSalle")
	@JsonIgnore
	private Set<Lieu> salles = new HashSet<>();
	
	@OneToOne
	@JoinColumn(name = "idfond", referencedColumnName = "id")
	private Photo fond;
	
	@OneToOne
	@JoinColumn(name = "idlogo", referencedColumnName = "id")
	private Photo logo;
	
	@ManyToMany
	@JoinTable(name="clubville",
		joinColumns= {@JoinColumn(name= "idclub", referencedColumnName="id")},
		inverseJoinColumns= {@JoinColumn(name="idville", referencedColumnName="id")})
	@OrderBy(value="nom")
	private Set<Ville> villes = new HashSet<>();
	
	@ManyToMany(mappedBy="clubs")
	@JsonIgnore
	private Set<Joueur> joueurs = new HashSet<>();
	
	public Integer getId() {
		return id;
	}

	public Club() {
		super();
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodeClub() {
		return codeClub;
	}

	public void setCodeClub(String codeClub) {
		this.codeClub = codeClub;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public Set<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(Set<Equipe> equipes) {
		this.equipes = equipes;
	}

	

	public Set<Lieu> getSalles() {
		return salles;
	}

	public void setSalles(Set<Lieu> salles) {
		this.salles = salles;
	}

	public Set<Ville> getVilles() {
		return villes;
	}

	public void setVilles(Set<Ville> villes) {
		this.villes = villes;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNomcomplet() {
		return nomcomplet;
	}

	public void setNomcomplet(String nomcomplet) {
		this.nomcomplet = nomcomplet;
	}

	public Set<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(Set<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	public Photo getFond() {
		return fond;
	}

	public void setFond(Photo fond) {
		this.fond = fond;
	}

	public Photo getLogo() {
		return logo;
	}

	public void setLogo(Photo logo) {
		this.logo = logo;
	}
	
	
}
