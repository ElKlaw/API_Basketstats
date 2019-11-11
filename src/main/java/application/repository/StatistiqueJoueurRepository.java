package application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import application.bean.StatistiqueJoueur;

public interface StatistiqueJoueurRepository extends PagingAndSortingRepository<StatistiqueJoueur, Integer>{
	@Query(value ="select s from StatistiqueJoueur s join s.joueur j where j.id = ?1")
	List<StatistiqueJoueur> getAllStatistiquesJoueur(int id);
	
	@Query(value ="select s from StatistiqueJoueur s join s.match m where m.id = ?1")
	List<StatistiqueJoueur> getStatistiquesJoueurMatch(int id);
}
