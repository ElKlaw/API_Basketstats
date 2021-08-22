package application.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import application.bean.Club;
import application.bean.Joueur;
import application.repository.ClubRepository;
import application.service.IClubService;

@Service
public class ClubService implements IClubService {
	@Autowired
	private ClubRepository clubRepository;
	
	public List<Club> getAllClubs() {
		return StreamSupport.stream(clubRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}

	public List<Club> getAllClubs(Pageable pageable) {
		return StreamSupport.stream(clubRepository.findAll(pageable).spliterator(), false)
				.collect(Collectors.toList());
	}

	public Page<Club> searchClubs(String nom, Pageable pageable) {
		return clubRepository.findCustomByNomContaining(nom, pageable);
	}

	public Optional<Club> getClubById(int id) {
		return clubRepository.findById(id);
	}
	
	public Optional<Club> getClubByURL(String url) {
		return clubRepository.findCustomByURL(url);
	}
	
	@Override
	public Optional<Club> getClubByIdEquipe(int id) {
		return clubRepository.findCustomByIdEquipe(id);
	}

	public Club addClub(Club club) {
		clubRepository.save(club);
		return club;
	}

	public Club updateClub(Club club) {
		clubRepository.save(club);
		return club;
	}

	public boolean deleteClub(int id) {
		Optional<Club> club = getClubById(id);
		if(club.isPresent()) {
			clubRepository.delete(club.get());
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean existClub(String url) {
		Optional<Club> club = getClubByURL(url); 
		if(club.isPresent()) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Joueur addJoueurToClub(Club club, Joueur joueur) {
		joueur.addClub(club);
		clubRepository.save(club);
		return joueur;
	}

	@Override
	public List<Joueur> addJoueursToClub(Club club, List<Joueur> joueurs) {
		for(Joueur joueur : joueurs) {
			joueur.addClub(club);
		}
		clubRepository.save(club);
		return joueurs;
	}
	
}
