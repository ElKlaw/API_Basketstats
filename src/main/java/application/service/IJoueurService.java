package application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import application.bean.Joueur;

public interface IJoueurService {
	List<Joueur> getJoueursClub(int id);
	List<Joueur> getJoueursEquipe(int id);
	// Chemin de base
	List<Joueur> getAllJoueurs();
	List<Joueur> getAllJoueurs(Pageable pageable);
	List<Joueur> searchJoueurs(String nomPrenom, Pageable pageable);
	Optional<Joueur> getJoueurById(int id);
	Joueur addJoueur(Joueur joueur);
	Joueur updateJoueur(Joueur joueur);
	boolean deleteJoueur(int id);
}

