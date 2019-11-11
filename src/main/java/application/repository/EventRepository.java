package application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import application.bean.Event;

@Repository
public interface EventRepository extends PagingAndSortingRepository<Event, Integer> {
	@Query(value="Select distinct(e) From Event e join e.equipes eq where eq.id=?1")
	List<Event> getAllEventFromEquipe(int id);
	
	@Query(value="Select distinct(e) From Event e join e.clubs c where c.id=?1")
	List<Event> getAllEventFromClub(int id);
	
	@Query(value="Select distinct(e) From Event e join e.equipes eq join eq.joueurs j where j.id=?1")
	List<Event> getAllEventFromJoueur(int id);
}
