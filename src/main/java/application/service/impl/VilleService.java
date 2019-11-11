package application.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.bean.Ville;
import application.repository.VilleRepository;
import application.service.IVilleService;

@Service
public class VilleService implements IVilleService{
	@Autowired
	private VilleRepository villeRepository;

	@Override
	public List<Ville> getVillesClub(int id) {
		return villeRepository.getAllVilleFromClub(id);
	}

	@Override
	public Optional<Ville> getVilleById(int id) {
		return villeRepository.findById(id);
	}

	@Override
	public Ville addVille(Ville ville) {
		Ville villeIdentique = villeRepository.getVilleFromNomAndCodePostal(ville.getNom(), ville.getCodePostal());
		if(villeIdentique!=null) {
			return villeIdentique;
		}else {
			return villeRepository.save(ville);
		}
	}

	@Override
	public Ville updateVille(Ville ville) {
		villeRepository.save(ville);
		return ville;
	}

	@Override
	public boolean deleteVille(int id) {
		Optional<Ville> ville= getVilleById(id);
		if(ville.isPresent()) {
			villeRepository.delete(ville.get());
			return true;
		}else {
			return false;
		}
	}
}
