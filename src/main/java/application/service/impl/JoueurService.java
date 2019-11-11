package application.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import application.bean.Joueur;
import application.repository.JoueurRepository;
import application.service.IJoueurService;

@Service
public class JoueurService implements IJoueurService{
	@Autowired
	private JoueurRepository joueurRepository;
	
	@Override
	public List<Joueur> getAllJoueurs() {
		return StreamSupport.stream(joueurRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
	}
	
	@Override
	public List<Joueur> getAllJoueurs(Pageable pageable) {
		return StreamSupport.stream(joueurRepository.findAll(pageable).spliterator(), false)
                .collect(Collectors.toList());
	}

	@Override
	public Optional<Joueur> getJoueurById(int id) {
		return joueurRepository.findById(id);
	}

	@Override
	public Joueur addJoueur(Joueur joueur) {
		joueurRepository.save(joueur);
		return joueur;
	}

	@Override
	public Joueur updateJoueur(Joueur joueur) {
		joueurRepository.save(joueur);
		return joueur;
	}

	@Override
	public boolean deleteJoueur(int id) {
		Optional<Joueur> joueur = getJoueurById(id);
		if(joueur.isPresent()) {
			joueurRepository.delete(joueur.get());
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<Joueur> searchJoueurs(String nomPrenom, Pageable pageable) {
		return StreamSupport.stream(joueurRepository.findCustomByNomPrenomContaining(nomPrenom, pageable).spliterator(), false)
                .collect(Collectors.toList());
	}

	@Override
	public List<Joueur> getJoueursEquipe(int id) {
		return StreamSupport.stream(joueurRepository.getAllJoueurFromEquipe(id).spliterator(), false)
				.collect(Collectors.toList());
	}
	
	@Override
	public List<Joueur> getJoueursClub(int id) {
		return StreamSupport.stream(joueurRepository.getAllJoueursFromClub(id).spliterator(), false)
				.collect(Collectors.toList());
	}
}

