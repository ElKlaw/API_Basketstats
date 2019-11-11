package application.service;

import java.util.List;
import java.util.Optional;

import application.bean.Lieu;

public interface ILieuService {	
	List<Lieu> getSalles(String nom);
	List<Lieu> getSallesClub(int id);
	//Chemin de base
	Optional<Lieu> getLieuById(int id);
	Lieu addLieu(Lieu salle);
	Lieu updateLieu(Lieu salle);
	boolean deleteLieu(int id);
}
