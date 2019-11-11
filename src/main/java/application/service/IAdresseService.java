package application.service;

import java.util.Optional;

import application.bean.Adresse;

public interface IAdresseService {
	Optional<Adresse> getAdresseById(int id);
	Adresse addAdresse(Adresse adresse);
	Adresse updateAdresse(Adresse adresse);
	boolean deleteAdresse(int id);
}
