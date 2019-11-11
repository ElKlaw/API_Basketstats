package application.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import application.bean.Event;
import application.bean.Match;
import application.repository.MatchRepository;
import application.service.IMatchService;
import application.utils.enumeration.TypeRechercheMatch;

@Service
public class MatchService implements IMatchService {
	@Autowired
	private MatchRepository matchRepository;
	
	@Override
	public List<Match> getMatchsEquipe(int id) {
		return StreamSupport.stream(matchRepository.getAllMatchFromEquipe(id).spliterator(), false)
                .collect(Collectors.toList());
	}

	@Override
	public List<Match> getMatchsJoueur(int id) {
		return StreamSupport.stream(matchRepository.getAllMatchFromJoueur(id).spliterator(), false)
                .collect(Collectors.toList());
	}

	@Override
	public Page<Event> getMatchsClub(int id, Pageable pageable, String typeRecherche) {
		if(TypeRechercheMatch.PASSE.toString().equals(typeRecherche)) {
			return matchRepository.getMatchFromClubPasse(id, pageable);
		} else if(TypeRechercheMatch.FUTUR.toString().equals(typeRecherche)) {
			return matchRepository.getMatchFromClubFutur(id, pageable);
		}
		return matchRepository.getAllMatchFromClub(id, pageable);
	}

	@Override
	public Optional<Match> getMatchById(int id) {
		return matchRepository.findById(id);
	}

	@Override
	public Match addMatch(Match match) {
		matchRepository.save(match);
		return match;
	}

	@Override
	public Match updateMatch(Match match) {
		matchRepository.save(match);
		return match;
	}

	@Override
	public boolean deleteMatch(int id) {
		Optional<Match> match = getMatchById(id);
		if(match.isPresent()) {
			matchRepository.delete(match.get());
			return true;
		}else {
			return false;
		}
	}
	
}
