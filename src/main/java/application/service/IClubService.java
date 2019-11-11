package application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import application.bean.Club;
import application.bean.Joueur;

public interface IClubService {
	
	// Chemins de base
	List<Club> getAllClubs();
	List<Club> getAllClubs(Pageable pageable);
	Page<Club> searchClubs(String nom, Pageable pageable);
	Optional<Club> getClubById(int id);
	Optional<Club> getClubByURL(String url);
	Club addClub(Club club);
	Club updateClub(Club club);
	Club patchClub(int id, Club club, Club patchClub);
	boolean deleteClub(int id);
	boolean existClub(String url);
	Joueur addJoueurToClub(Club club, Joueur joueur);
	List<Joueur> addJoueursToClub(Club club, List<Joueur> joueur);
}
