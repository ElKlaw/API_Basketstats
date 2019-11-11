package application.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.bean.StatistiqueJoueur;
import application.repository.StatistiqueJoueurRepository;
import application.service.IStatistiqueJoueurService;

@Service
public class StatistiqueJoueurService implements IStatistiqueJoueurService{
	@Autowired
	private StatistiqueJoueurRepository statistiqueJoueurRepository;

	@Override
	public List<StatistiqueJoueur> getStatistiquesJoueur(int id) {
		return StreamSupport.stream(statistiqueJoueurRepository.getAllStatistiquesJoueur(id).spliterator(), false)
                .collect(Collectors.toList());
	}

	@Override
	public List<StatistiqueJoueur> getStatistiqueJoueurMatch(int id) {
		return StreamSupport.stream(statistiqueJoueurRepository.getStatistiquesJoueurMatch(id).spliterator(), false)
                .collect(Collectors.toList());
	}

	@Override
	public Optional<StatistiqueJoueur> getStatistiqueJoueurById(int id) {
		return statistiqueJoueurRepository.findById(id);
	}

	@Override
	public StatistiqueJoueur addStatistiqueJoueur(StatistiqueJoueur statistiqueJoueur) {
		statistiqueJoueurRepository.save(statistiqueJoueur);
		return statistiqueJoueur;
	}

	@Override
	public StatistiqueJoueur updateStatistiqueJoueur(StatistiqueJoueur statistiqueJoueur) {
		statistiqueJoueurRepository.save(statistiqueJoueur);
		return statistiqueJoueur;
	}

	@Override
	public boolean deleteStatistiqueJoueur(int id) {
		Optional<StatistiqueJoueur> statistiqueJoueur = getStatistiqueJoueurById(id);
		if(statistiqueJoueur.isPresent()) {
			statistiqueJoueurRepository.delete(statistiqueJoueur.get());
			return true;
		}else {
			return false;
		}
	}
}
