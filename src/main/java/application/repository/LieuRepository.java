package application.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import application.bean.Lieu;

@Repository
public interface LieuRepository extends PagingAndSortingRepository<Lieu, Integer> {
	@Query("select l from Lieu l join l.clubSalle c where l.salle=true and c.id = ?1 order by l.nom")
	List<Lieu> findSallesFromClub(int id);
	
	@Query("select l from Lieu l where l.salle=true and l.nom like %?1% order by l.nom")
	List<Lieu> findSalles(String nom);
}
