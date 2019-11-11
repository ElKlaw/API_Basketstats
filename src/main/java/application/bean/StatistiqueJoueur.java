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
@Table(name="statistiquejoueur")
@ApiModel(description = "Classe représentant une statistique de joueur à un match")
public class StatistiqueJoueur {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Identifiant unique de la statistique", example = "1", required = true, position = 0)
	private Integer id;
	
	@Column(name="minutes")
	@ApiModelProperty(notes = "Nombre de minutes jouées", position = 1)
	private int minutes;
	
	@Column(name="points")
	@ApiModelProperty(notes = "Nombre de points marqués", position = 2)
	private int points;
	
	@Column(name="rebonds")
	@ApiModelProperty(notes = "Nombre de rebonds captés", position = 3)
	private int rebonds;
	
	@Column(name="passes")
	@ApiModelProperty(notes = "Nombre de passes décisives effectuées", position = 4)
	private int passes;
	
	@Column(name="perteballes")
	@ApiModelProperty(notes = "Nombre de perte de balles effectuées", position = 5)
	private int perteBalles;
	
	@Column(name="contres")
	@ApiModelProperty(notes = "Nombre de contres effectuées", position = 6)
	private int contres;
	
	@Column(name="tr")
	@ApiModelProperty(notes = "Nombre de tirs réussis", position = 7)
	private int TR;
	
	@Column(name="tt")
	@ApiModelProperty(notes = "Nombre de tirs tentés", position = 8)
	private int TT;
	
	@Column(name="troisptst")
	@ApiModelProperty(notes = "Nombre de 3PTS tentés", position = 9)
	private int troisPTST;
	
	@Column(name="troisptsr")
	@ApiModelProperty(notes = "Nombre de 3PTS réussis", position = 10)
	private int troisPTSR;
	
	@Column(name="lft")
	@ApiModelProperty(notes = "Nombre de lancers francs tentés", position = 11)
	private int LFT;
	
	@Column(name="lfr")
	@ApiModelProperty(notes = "Nombre de lancers francs réussis", position = 12)
	private int LFR;
	
	@Column(name="faute")
	@ApiModelProperty(notes = "Nombre de fautes commisses", position = 13)
	private int faute;
	
	@ManyToOne
	@JoinColumn(name="idmatchs")
	private Match match;
	
	@ManyToOne
	@JoinColumn(name="idequipe")
	private Equipe equipe;
	
	@ManyToOne
	@JoinColumn(name="idjoueur")
	private Joueur joueur;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getRebonds() {
		return rebonds;
	}

	public void setRebonds(int rebonds) {
		this.rebonds = rebonds;
	}

	public int getPasses() {
		return passes;
	}

	public void setPasses(int passes) {
		this.passes = passes;
	}

	public int getPerteBalles() {
		return perteBalles;
	}

	public void setPerteBalles(int perteBalles) {
		this.perteBalles = perteBalles;
	}

	public int getContres() {
		return contres;
	}

	public void setContres(int contres) {
		this.contres = contres;
	}

	public int getTR() {
		return TR;
	}

	public void setTR(int tR) {
		TR = tR;
	}

	public int getTT() {
		return TT;
	}

	public void setTT(int tT) {
		TT = tT;
	}

	public int getTroisPTST() {
		return troisPTST;
	}

	public void setTroisPTST(int troisPTST) {
		this.troisPTST = troisPTST;
	}

	public int getTroisPTSR() {
		return troisPTSR;
	}

	public void setTroisPTSR(int troisPTSR) {
		this.troisPTSR = troisPTSR;
	}

	public int getLFT() {
		return LFT;
	}

	public void setLFT(int lFT) {
		LFT = lFT;
	}

	public int getLFR() {
		return LFR;
	}

	public void setLFR(int lFR) {
		LFR = lFR;
	}

	public int getFaute() {
		return faute;
	}

	public void setFaute(int faute) {
		this.faute = faute;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	
	
}
