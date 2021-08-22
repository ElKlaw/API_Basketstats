package application.bean;

import java.util.HashSet;
import java.util.Set;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="Invitation")
@ApiModel(description="classe représentant les différents invitations")
public class Invitation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Identifiant unique de la présence", example = "1", required = true, position = 0)
	private Integer id;
	
	@Column(name="nom")
	@ApiModelProperty(notes = "", example = "", position = 1)
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="email")
	private String email;
	
	@Column(name="dateDeFin")
	private LocalDate dateDeFin;
	
	@Column(name="password")
	private String password;
	
	@ManyToMany
	@JoinTable(name="invitationequipe",
		joinColumns= {@JoinColumn(name= "idinvitation", referencedColumnName="id")},
		inverseJoinColumns= {@JoinColumn(name="idequipe", referencedColumnName="id")})
	private Set<Equipe> invitationequipes = new HashSet<>();
	
	//Getters and Setters
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getId() {
		return id;
	}
	public LocalDate getDateDeFin() {
		return dateDeFin;
	}
	public void setDateDeFin(LocalDate dateDeFin) {
		this.dateDeFin = dateDeFin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Equipe> getInvitationequipes() {
		return invitationequipes;
	}
	public void setInvitationequipes(Set<Equipe> invitationequipes) {
		this.invitationequipes = invitationequipes;
	}
	
	
	
}
