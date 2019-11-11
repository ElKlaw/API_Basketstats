package application.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import application.bean.Joueur;

@Repository
public interface JoueurRepository extends PagingAndSortingRepository<Joueur,Integer>{
	@Query("select j from Joueur j where j.nom like %?1% or j.prenom like %?1% ")
	List<Joueur> findCustomByNomPrenomContaining(String nomPrenom, Pageable pageable);
	
	@Query(value ="select distinct(j) from Joueur j join j.equipes e join e.clubEquipe c where c.id=?1 ")
	List<Joueur> getAllJoueursFromClub(int id);
	
	@Query(value ="select distinct(j) from Joueur j join j.equipes je where je.id = ?1")
	List<Joueur> getAllJoueurFromEquipe(int id);
}
