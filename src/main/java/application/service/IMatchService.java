package application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import application.bean.Event;
import application.bean.Match;

public interface IMatchService {
	List<Match> getMatchsEquipe(int id);
	List<Match> getMatchsJoueur(int id);
	Page<Event> getMatchsClub(int id, Pageable pageable, String typeRecherche);
	
	// Chemin de base
	Optional<Match> getMatchById(int id);
	Match addMatch(Match match);
	Match updateMatch(Match match);
	boolean deleteMatch(int id);
}
