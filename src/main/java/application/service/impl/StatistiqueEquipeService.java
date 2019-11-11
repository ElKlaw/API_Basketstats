package application.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.bean.StatistiqueEquipe;
import application.repository.StatistiqueEquipeRepository;
import application.service.IStatistiqueEquipeService;

@Service
public class StatistiqueEquipeService implements IStatistiqueEquipeService {
	@Autowired
	private StatistiqueEquipeRepository statistiqueEquipeRepository;

	@Override
	public StatistiqueEquipe getStatistiqueEquipeMatch(int id) {
		return statistiqueEquipeRepository.getStatistiquesEquipeMatch(id);
	}

	@Override
	public List<StatistiqueEquipe> getStatistiquesEquipe(int id) {
		return StreamSupport.stream(statistiqueEquipeRepository.getAllStatistiquesEquipe(id).spliterator(), false)
                .collect(Collectors.toList());
	}

	@Override
	public Optional<StatistiqueEquipe> getStatistiqueEquipeById(int id) {
		return statistiqueEquipeRepository.findById(id);
	}

	@Override
	public StatistiqueEquipe addStatistiqueEquipe(StatistiqueEquipe statistiqueEquipe) {
		statistiqueEquipeRepository.save(statistiqueEquipe);
		return statistiqueEquipe;
	}

	@Override
	public StatistiqueEquipe updateStatistiqueEquipe(StatistiqueEquipe statistiqueEquipe) {
		statistiqueEquipeRepository.save(statistiqueEquipe);
		return statistiqueEquipe;
	}

	@Override
	public boolean deleteStatistiqueEquipe(int id) {
		Optional<StatistiqueEquipe> statistiqueEquipe = getStatistiqueEquipeById(id);
		if(statistiqueEquipe.isPresent()) {
			statistiqueEquipeRepository.delete(statistiqueEquipe.get());
			return true;
		}else {
			return false;
		}
	}
	
	
}
