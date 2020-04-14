package application.repository;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import application.bean.Club;

@Repository
public interface ClubRepository extends PagingAndSortingRepository<Club, Integer> {
	@Query("select c from Club c where c.nomcomplet like %?1% order by c.nomcomplet")
	Page<Club> findCustomByNomContaining(String nom, Pageable pageable);
	
	@Query("select c from Club c where c.url=?1")
	Optional<Club> findCustomByURL(String url);
	
	@Query("select c from Club c join c.equipes e where e.id=?1")
	Optional<Club> findCustomByIdEquipe(int id);
}
