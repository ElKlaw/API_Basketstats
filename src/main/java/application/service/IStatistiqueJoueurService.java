package application.service;

import java.util.List;
import java.util.Optional;

import application.bean.StatistiqueJoueur;

public interface IStatistiqueJoueurService {
	List<StatistiqueJoueur> getStatistiquesJoueur(int id);
	List<StatistiqueJoueur> getStatistiqueJoueurMatch(int id);
	
	// Chemin de base
	Optional<StatistiqueJoueur> getStatistiqueJoueurById(int id);
	StatistiqueJoueur addStatistiqueJoueur(StatistiqueJoueur statistiqueJoueur);
	StatistiqueJoueur updateStatistiqueJoueur(StatistiqueJoueur statistiqueJoueur);
	boolean deleteStatistiqueJoueur(int id);
}
