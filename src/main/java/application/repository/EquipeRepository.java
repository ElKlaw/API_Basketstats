package application.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import application.bean.Equipe;

@Repository
public interface EquipeRepository extends PagingAndSortingRepository<Equipe, Integer>{
	@Query("select e from Equipe e where e.nom like %?1%")
	List<Equipe> findCustomByNomContaining(String nom, Pageable pageable);
	
	@Query(value ="select e from Equipe e join e.joueurs je where je.id = ?1")
	List<Equipe> getAllEquipeFromJoueur(int id);
	
	@Query(value ="select e from Equipe e join e.clubEquipe c where c.id = ?1")
	List<Equipe> getAllEquipesFromClub(int id);	
}