package application.service;

import java.util.List;
import java.util.Optional;

import application.bean.StatistiqueEquipe;

public interface IStatistiqueEquipeService {
	StatistiqueEquipe getStatistiqueEquipeMatch(int id);
	List<StatistiqueEquipe> getStatistiquesEquipe(int id);
	
	//Chemin de base
	Optional<StatistiqueEquipe> getStatistiqueEquipeById(int id);
	StatistiqueEquipe addStatistiqueEquipe(StatistiqueEquipe statistiqueEquipe);
	StatistiqueEquipe updateStatistiqueEquipe(StatistiqueEquipe statistiqueEquipe);
	boolean deleteStatistiqueEquipe(int id);
}
