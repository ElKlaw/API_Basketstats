package application.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import application.bean.Match;

@Repository
public interface MatchRepository extends PagingAndSortingRepository<Match, Integer> {
	//Match Equipe
	@Query(value="Select m from Match m join m.equipe eq where eq.id=?1 order by m.dateMatch desc, m.heureMatch desc")
	Page<Match> getAllMatchFromEquipe(int id, Pageable pageable);
	
	@Query(value="Select m from Match m join m.equipe eq where eq.id=?1 and (m.dateMatch>CURRENT_DATE or (m.dateMatch=CURRENT_DATE and m.heureMatch>CURRENT_DATE)) order by m.dateMatch asc, m.heureMatch asc")
	Page<Match> getMatchFromEquipeFutur(int id, Pageable pageable);
	
	@Query(value="Select m from Match m join m.equipe eq where eq.id=?1 and (m.dateMatch<CURRENT_DATE or (m.dateMatch=CURRENT_DATE and m.heureMatch<CURRENT_DATE)) order by m.dateMatch desc, m.heureMatch desc")
	Page<Match> getMatchFromEquipePasse(int id, Pageable pageable);
	
	//Match Club
	@Query(value="Select m from Match m join m.equipe eq join eq.clubEquipe c where c.id=?1 order by m.dateMatch desc, m.heureMatch desc")
	Page<Match> getAllMatchFromClub(int id, Pageable pageable);
	
	@Query(value="Select m from Match m join m.equipe eq join eq.clubEquipe c where c.id=?1 and (m.dateMatch>CURRENT_DATE or (m.dateMatch=CURRENT_DATE and m.heureMatch>CURRENT_DATE)) order by m.dateMatch asc, m.heureMatch asc")
	Page<Match> getMatchFromClubFutur(int id, Pageable pageable);
	
	@Query(value="Select m from Match m join m.equipe eq join eq.clubEquipe c where c.id=?1 and (m.dateMatch<CURRENT_DATE or (m.dateMatch=CURRENT_DATE and m.heureMatch<CURRENT_DATE)) order by m.dateMatch desc, m.heureMatch desc")
	Page<Match> getMatchFromClubPasse(int id, Pageable pageable);
	
	//Match Joueur
	@Query(value="Select distinct(m) From Match m join m.equipe eq join eq.joueurs j where j.id=?1 order by m.dateMatch desc")
	List<Match> getAllMatchFromJoueur(int id);
}