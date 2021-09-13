package application.bean;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.annotation.Nullable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="matchs")
@ApiModel(description = "Classe représentant un match")
public class Match {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Identifiant unique du match", example = "1", required = true, position = 0)
	private Integer id;
	
	@Column(name="datematch")
	@ApiModelProperty(notes = "Date du match", position = 1)
	private LocalDate dateMatch;

	@Column(name="domicile")
	@ApiModelProperty(notes = "Le match est-il a domicile ?", position = 2)
	private boolean domicile;
	
	@Column(name="heurematch")
	@ApiModelProperty(notes = "Heure du match", example="15:00", position = 3)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private LocalTime heureMatch;
	
	@Column(name="heurerdv")
	@ApiModelProperty(notes = "Heure de rendez-vous du match", example="14:00", position = 4)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private LocalTime heureRDV;

	@Column(name="adversaire")
	@ApiModelProperty(notes = "Adversaire du match", position = 5)
	private String adversaire;
	
	@Column(name="scoreequipe", nullable=true)
	@ApiModelProperty(notes = "Score de l'équipe", position = 6)
	private Integer scoreEquipe;
	
	@Column(name="scoreadversaire", nullable=true)
	@ApiModelProperty(notes = "Score de l'équipe adverse", position = 7)
	private Integer scoreAdversaire;
	
	@Column(name="infossup")
	@ApiModelProperty(notes = "Informations supplémentaire du match", position = 8)
	private String infosSup;
	
	@ManyToOne
	@JoinColumn(name="idequipe")
	private Equipe equipe;
	
	@ManyToOne
	@Nullable
	@JoinColumn(name="idadresserdv")
	private Adresse adresseRdv;
	
	@ManyToOne
	@Nullable
	@JoinColumn(name="idsallematch")
	private Salle salleMatch;
	
	@ManyToOne
	@Nullable
	@JoinColumn(name="idadressematch")
	private Adresse adresseMatch;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDateMatch() {
		return dateMatch;
	}

	public void setDateMatch(LocalDate dateMatch) {
		this.dateMatch = dateMatch;
	}

	public boolean isDomicile() {
		return domicile;
	}

	public void setDomicile(boolean domicile) {
		this.domicile = domicile;
	}

	public LocalTime getHeureMatch() {
		return heureMatch;
	}

	public void setHeureMatch(LocalTime heureMatch) {
		this.heureMatch = heureMatch;
	}

	public LocalTime getHeureRDV() {
		return heureRDV;
	}

	public void setHeureRDV(LocalTime heureRDV) {
		this.heureRDV = heureRDV;
	}

	public String getAdversaire() {
		return adversaire;
	}

	public void setAdversaire(String adversaire) {
		this.adversaire = adversaire;
	}

	public Integer getScoreEquipe() {
		return scoreEquipe;
	}

	public void setScoreEquipe(Integer scoreEquipe) {
		this.scoreEquipe = scoreEquipe;
	}

	public Integer getScoreAdversaire() {
		return scoreAdversaire;
	}

	public void setScoreAdversaire(Integer scoreAdversaire) {
		this.scoreAdversaire = scoreAdversaire;
	}

	public String getInfosSup() {
		return infosSup;
	}

	public void setInfosSup(String infosSup) {
		this.infosSup = infosSup;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Adresse getAdresseRdv() {
		return adresseRdv;
	}

	public void setAdresseRdv(Adresse adresseRdv) {
		this.adresseRdv = adresseRdv;
	}

	public Salle getSalleMatch() {
		return salleMatch;
	}

	public void setSalleMatch(Salle salleMatch) {
		this.salleMatch = salleMatch;
	}

	public Adresse getAdresseMatch() {
		return adresseMatch;
	}

	public void setAdresseMatch(Adresse adresseMatch) {
		this.adresseMatch = adresseMatch;
	}
}
