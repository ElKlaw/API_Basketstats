package application.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.bean.Lieu;
import application.repository.LieuRepository;
import application.service.ILieuService;

@Service
public class LieuService implements ILieuService{
	@Autowired
	private LieuRepository lieuRepository;

	@Override
	public Optional<Lieu> getLieuById(int id) {
		return lieuRepository.findById(id);
	}

	@Override
	public Lieu addLieu(Lieu lieu) {
		lieuRepository.save(lieu);
		return lieu;
	}

	@Override
	public Lieu updateLieu(Lieu lieu) {
		lieuRepository.save(lieu);
		return lieu;
	}

	@Override
	public boolean deleteLieu(int id) {
		Optional<Lieu> salle = getLieuById(id);
		if(salle.isPresent()) {
			lieuRepository.delete(salle.get());
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<Lieu> getSallesClub(int id) {
		return StreamSupport.stream(lieuRepository.findSallesFromClub(id).spliterator(), false)
				.collect(Collectors.toList());
	}

	@Override
	public List<Lieu> getSalles(String nom) {
		return StreamSupport.stream(lieuRepository.findSalles(nom).spliterator(), false)
				.collect(Collectors.toList());
	}
}
