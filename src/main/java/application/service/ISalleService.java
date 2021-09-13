package application.service;

import java.util.List;
import java.util.Optional;

import application.bean.Salle;

public interface ISalleService {
	List<Salle> getSalleByIdClub(int id);
	Optional<Salle> getSalleById(int id);
	Salle addSalle(Salle salle);
	Salle updateSalle(Salle salle);
	boolean deleteSalle(int id);
}
