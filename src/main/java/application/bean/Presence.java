package application.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import application.utils.enumeration.TypePresence;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="presence")
@ApiModel(description = "Classe représentant la présence ou non d'un joueur à un évènement")
public class Presence {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Identifiant unique de la présence", example = "1", required = true, position = 0)
	private Integer id;
	
	@Column(name="present")
	@ApiModelProperty(notes = "", example = "", position = 1)
	private TypePresence present;
	
	@ManyToOne
	@JoinColumn(name="idjoueur")
	private Joueur joueur;
	
	@ManyToOne
	@JoinColumn(name="idevent")
	private Event event;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TypePresence getPresent() {
		return present;
	}

	public void setPresent(TypePresence present) {
		this.present = present;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	
	
}
