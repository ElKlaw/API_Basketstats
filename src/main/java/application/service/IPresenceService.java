package application.service;

import java.util.List;
import java.util.Optional;

import application.bean.Presence;

public interface IPresenceService {
	List<Presence> getPresencesJoueur(int id);
	List<Presence> getPresencesMatch(int id);
	
	// Chemin de base
	Optional<Presence> getPresenceById(int id);
	Presence addPresence(Presence presence);
	Presence updatePresence(Presence presence);
	boolean deletePresence(int id);
}
