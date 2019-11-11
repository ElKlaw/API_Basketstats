package application.service;

import java.util.List;
import java.util.Optional;

import application.bean.Ville;

public interface IVilleService {
	List<Ville> getVillesClub(int id);
	
	//Chemin de base
	Optional<Ville> getVilleById(int id);
	Ville addVille(Ville ville);
	Ville updateVille(Ville ville);
	boolean deleteVille(int id);
}
