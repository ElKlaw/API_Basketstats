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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="utilisateur")
@ApiModel(description = "Classe représentant un utilisateur")
public class Utilisateur {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Identifiant unique de l'utilisateur", example = "1", required = true, position = 0)
	private Integer id;
	
	@Column(name="identifiant")
	private String identifiant;
	
	@Column(name="motdepasse")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String motdepasse;
	
	@Column(name="email")
	private String email;
	
	@Column(name="secret")
	@JsonIgnore
	private String secret;
	
	@ManyToMany
	@JoinTable(name="roleutilisateur",
		joinColumns= {@JoinColumn(name= "idutilisateur", referencedColumnName="id")},
		inverseJoinColumns= {@JoinColumn(name="idrole", referencedColumnName="id")})
	private Set<Role> roles = new HashSet<>();
	
	@OneToOne
	@JoinColumn(name="idjoueur")
	private Joueur joueur;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMotdepasse() {
		return motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
