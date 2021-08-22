package application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import application.bean.Ville;

@Repository
public interface VilleRepository extends PagingAndSortingRepository<Ville, Integer>{
	@Query(value ="select v from Ville v join v.clubVille c where c.id = ?1")
	List<Ville> getAllVilleFromClub(int id);
	
	@Query("select v from Ville v where v.nom=?1 and v.codePostal=?2 ")
	Ville getVilleFromNomAndCodePostal(String nom, int codePostal);
}
