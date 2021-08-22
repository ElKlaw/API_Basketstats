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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
	@NotNull
	@ApiModelProperty(notes = "Code identifiant du Club via la Fédération", example = "PDL0049152", position = 1)
	private String codeClub;
	
	@Column(name="url")
	@NotNull
	private String url;
	
	@Column(name="nomcomplet")
	@NotNull
	private String nomcomplet;
	
	@Column(name="nom")
	@NotNull
	@ApiModelProperty(notes = "Nom du club", position = 2)
	private String nom;
	
	@ManyToOne
	@JoinColumn(name="idsport")
	@ApiModelProperty(notes = "Sport pratiqué par le club", position = 3)
	private Sport sport;
	
	@OneToMany(mappedBy="clubEquipe")
	@JsonIgnore
	private Set<Equipe> equipes = new HashSet<>();
	
	@OneToMany(mappedBy="clubSalle")
	@JsonIgnore
	private Set<Lieu> salles = new HashSet<>();
	
	@Column(name="fond")
	private Integer fond;
	
	@Column(name="logo")
	private Integer logo;
	
	@Column(name="couleurprincipale")
	@NotNull
	private String couleurprincipale;
	
	@Column(name="couleursecondaire")
	@NotNull
	private String couleursecondaire;
	
	@OneToMany(mappedBy = "clubVille")
	private Set<Ville> villes = new HashSet<>();
	
	@ManyToMany(mappedBy="clubs")
	@JsonIgnore
	private Set<Joueur> joueurs = new HashSet<>();
	
	public Club(Club club) {
		super();
		this.id = club.getId();
		this.codeClub = club.getCodeClub();
		this.url = club.getUrl();
		this.nomcomplet = club.getNomcomplet();
		this.nom = club.getNom();
		this.sport = club.getSport();
		this.equipes = club.getEquipes();
		this.salles = club.getSalles();
		this.fond = club.getFond();
		this.logo = club.getLogo();
		this.villes = club.getVilles();
		this.joueurs = club.getJoueurs();
		this.couleurprincipale = club.getCouleurprincipale();
		this.couleursecondaire = club.getCouleursecondaire();
	}

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

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
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

	public Integer getFond() {
		return fond;
	}

	public void setFond(Integer fond) {
		this.fond = fond;
	}

	public Integer getLogo() {
		return logo;
	}

	public void setLogo(Integer logo) {
		this.logo = logo;
	}

	public String getCouleurprincipale() {
		return couleurprincipale;
	}

	public void setCouleurprincipale(String couleurprincipale) {
		this.couleurprincipale = couleurprincipale;
	}

	public String getCouleursecondaire() {
		return couleursecondaire;
	}

	public void setCouleursecondaire(String couleursecondaire) {
		this.couleursecondaire = couleursecondaire;
	}
}
