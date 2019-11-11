package application.service;

import java.util.Optional;

import application.bean.Utilisateur;

public interface IUtilisateurService {
	Utilisateur addUtilisateur(Utilisateur utilisateur);
	Boolean existsByIdentifiant(String identifiant);
    Boolean existsByEmail(String email);
    
    Utilisateur updateUtilisateur(Utilisateur utilisateur);
    Optional<Utilisateur> getUtilisateurById(Integer id);
}
