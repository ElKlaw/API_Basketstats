package application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import application.bean.StatistiqueEquipe;;

@Repository
public interface StatistiqueEquipeRepository extends PagingAndSortingRepository<StatistiqueEquipe, Integer>{
	@Query(value ="select s from StatistiqueEquipe s join s.equipe e where e.id = ?1")
	List<StatistiqueEquipe> getAllStatistiquesEquipe(int id);
	
	@Query(value ="select s from StatistiqueEquipe s join s.match m where m.id = ?1")
	StatistiqueEquipe getStatistiquesEquipeMatch(int id);
}
