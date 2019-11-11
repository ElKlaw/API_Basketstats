package application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import application.bean.Equipe;

public interface IEquipeService {
	
	List<Equipe> getEquipesJoueur(int id);
	List<Equipe> getEquipesClub(int id);
	
	// Chemin de base
	List<Equipe> getAllEquipes();
	List<Equipe> getAllEquipes(Pageable pageable);
	List<Equipe> searchEquipes(String nom, Pageable pageable);
	Optional<Equipe> getEquipeById(int id);
	Equipe addEquipe(Equipe equipe);
	Equipe updateEquipe(Equipe equipe);
	boolean deleteEquipe(int id);
}
