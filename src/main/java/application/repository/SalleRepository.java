package application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import application.bean.Salle;

@Repository
public interface SalleRepository extends PagingAndSortingRepository<Salle, Integer>{
	@Query(value ="select s from Salle s join s.clubSalle c where c.id = ?1")
	List<Salle> getAllVilleFromClub(int id);
}
