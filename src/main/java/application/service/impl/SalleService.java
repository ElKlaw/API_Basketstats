package application.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.bean.Salle;
import application.repository.SalleRepository;
import application.service.ISalleService;

@Service
public class SalleService implements ISalleService {
	@Autowired
	private SalleRepository salleRepository;
	
	@Override
	public List<Salle> getSallesClub(int id) {
		return salleRepository.getAllVilleFromClub(id);
	}

	@Override
	public Optional<Salle> getSalleById(int id) {
		return salleRepository.findById(id);
	}

	@Override
	public Salle addSalle(Salle salle) {
		return salleRepository.save(salle);
	}

	@Override
	public Salle updateSalle(Salle salle) {
		return salleRepository.save(salle);
	}

	@Override
	public boolean deleteSalle(int id) {
		Optional<Salle> salle = getSalleById(id);
		if(salle.isPresent()) {
			salleRepository.delete(salle.get());
			return true;
		} else {
			return false;
		}
	}

}
