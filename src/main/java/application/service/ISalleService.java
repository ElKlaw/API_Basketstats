package application.service;

import java.util.List;
import java.util.Optional;

import application.bean.Salle;

public interface ISalleService {
	List<Salle> getSallesClub(int id);
	
	//Chemin de base
	Optional<Salle> getSalleById(int id);
	Salle addSalle(Salle salle);
	Salle updateSalle(Salle salle);
	boolean deleteSalle(int id);
}
