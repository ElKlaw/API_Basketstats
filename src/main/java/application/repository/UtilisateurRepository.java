package application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import application.bean.Utilisateur;

public interface UtilisateurRepository extends PagingAndSortingRepository<Utilisateur, Integer> {
	@Query("select u from Utilisateur u where u.identifiant=?1")
	Optional<Utilisateur> findUtilisateurByIdentifiant(String identifiant);
	
	@Query("select u from Utilisateur u where u.email=?1")
	Optional<Utilisateur> findUtilisateurByEmail(String email);
	
	@Query("select u from Utilisateur u where u.identifiant=?1 or u.email=?2")
	Optional<Utilisateur> findUtilisateurByIdentifiantOrEmail(String identifiant, String email);
}
