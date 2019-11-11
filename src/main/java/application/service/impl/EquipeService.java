package application.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import application.bean.Equipe;
import application.repository.EquipeRepository;
import application.service.IEquipeService;

@Service
public class EquipeService implements IEquipeService{
	@Autowired
	private EquipeRepository equipeRepository;

	public List<Equipe> getAllEquipes() {
		return StreamSupport.stream(equipeRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}

	public List<Equipe> getAllEquipes(Pageable pageable) {
		return StreamSupport.stream(equipeRepository.findAll(pageable).spliterator(), false)
				.collect(Collectors.toList());
	}

	public List<Equipe> searchEquipes(String nom, Pageable pageable) {
		return StreamSupport.stream(equipeRepository.findCustomByNomContaining(nom, pageable).spliterator(), false)
				.collect(Collectors.toList());
	}

	public Optional<Equipe> getEquipeById(int id) {
		return equipeRepository.findById(id);
	}

	public Equipe addEquipe(Equipe equipe) {
		equipeRepository.save(equipe);
		return equipe;
	}

	public Equipe updateEquipe(Equipe equipe) {
		equipeRepository.save(equipe);
		return equipe;
	}

	public boolean deleteEquipe(int id) {
		Optional<Equipe> club = getEquipeById(id);
		if(club.isPresent()) {
			equipeRepository.delete(club.get());
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<Equipe> getEquipesJoueur(int id) {
		return StreamSupport.stream(equipeRepository.getAllEquipeFromJoueur(id).spliterator(), false)
                .collect(Collectors.toList());
	}
	
	@Override
	public List<Equipe> getEquipesClub(int id) {
		return StreamSupport.stream(equipeRepository.getAllEquipesFromClub(id).spliterator(), false)
				.collect(Collectors.toList());
	}
}

