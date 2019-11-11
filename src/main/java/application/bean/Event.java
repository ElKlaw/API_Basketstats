package application.bean;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import application.utils.enumeration.TypeEvent;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="event")
@ApiModel(description = "Classe représentant un évenement")
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Identifiant unique de l'event", example = "1", required = true, position = 0)
	private Integer id;
	
	@Column(name="title")
	@ApiModelProperty(notes = "Titre de l'event", position = 1)
	private String title;
	
	@Column(name="datedebut")
	@ApiModelProperty(notes = "Date de début de l'event", position = 2)
	private LocalDateTime dateDebut;
	
	@Column(name="datefin")
	@ApiModelProperty(notes = "Date de fin de l'event", position = 3)
	private LocalDateTime dateFin;
	
	@Column(name="infossup")
	@ApiModelProperty(notes = "Informations supplémentaires de l'event", position = 4)
	private String infosSup;
	
	@Column(name="typeevent")
	@ApiModelProperty(notes = "Type de l'event", position = 5)
	@Enumerated(EnumType.STRING)
	private TypeEvent typeEvent;
	
	@Column(name="recurent")
	@ApiModelProperty(notes = "Evenement récurent ?")
	private boolean recurent;
	
	@Column(name="freq")
	@ApiModelProperty(notes = "frequence de l'évènement")
	private String freq;
	
	@Column(name="bymonth")
	@ApiModelProperty(notes = "")
	private String bymonth;
	
	@Column(name="bymonthday")
	@ApiModelProperty(notes = "")
	private String bymonthday;
	
	@Column(name="byweekday")
	@ApiModelProperty(notes = "")
	private String byweekday;
	
	@ManyToOne
	@JoinColumn(name="idlieu", nullable=false)
	private Lieu lieu;
	
	@OneToOne
	@JoinColumn(name="idmatch", nullable=true)
	private Match match;
	
	@ManyToMany
	@JoinTable(name="eventequipe",
		joinColumns= {@JoinColumn(name= "idevent", referencedColumnName="id")},
		inverseJoinColumns= {@JoinColumn(name="idequipe", referencedColumnName="id")})
	private Set<Equipe> equipes = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name="eventclub",
		joinColumns= {@JoinColumn(name= "idevent", referencedColumnName="id")},
		inverseJoinColumns= {@JoinColumn(name="idclub", referencedColumnName="id")})
	private Set<Club> clubs = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDateTime getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDateTime dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDateTime getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDateTime dateFin) {
		this.dateFin = dateFin;
	}

	public String getInfosSup() {
		return infosSup;
	}

	public void setInfosSup(String infosSup) {
		this.infosSup = infosSup;
	}

	public TypeEvent getTypeEvent() {
		return typeEvent;
	}

	public void setTypeEvent(TypeEvent typeEvent) {
		this.typeEvent = typeEvent;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
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

	public boolean isRecurent() {
		return recurent;
	}

	public void setRecurent(boolean recurent) {
		this.recurent = recurent;
	}

	public String getFreq() {
		return freq;
	}

	public void setFreq(String freq) {
		this.freq = freq;
	}

	public String getBymonth() {
		return bymonth;
	}

	public void setBymonth(String bymonth) {
		this.bymonth = bymonth;
	}

	public String getBymonthday() {
		return bymonthday;
	}

	public void setBymonthday(String bymonthday) {
		this.bymonthday = bymonthday;
	}

	public String getByweekday() {
		return byweekday;
	}

	public void setByweekday(String byweekday) {
		this.byweekday = byweekday;
	}

	public Lieu getLieu() {
		return lieu;
	}

	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
	}

	
}
