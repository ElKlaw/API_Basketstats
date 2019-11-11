package application.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.bean.Adresse;
import application.repository.AdresseRepository;
import application.service.IAdresseService;

@Service
public class AdresseService implements IAdresseService {
	@Autowired
	private AdresseRepository adresseRepository;
	
	@Override
	public Optional<Adresse> getAdresseById(int id) {
		return adresseRepository.findById(id);
	}

	@Override
	public Adresse addAdresse(Adresse adresse) {
		adresseRepository.save(adresse);
		return adresse;
	}

	@Override
	public Adresse updateAdresse(Adresse adresse) {
		adresseRepository.save(adresse);
		return adresse;
	}

	@Override
	public boolean deleteAdresse(int id) {
		Optional<Adresse> adresse = getAdresseById(id);
		if(adresse.isPresent()) {
			adresseRepository.delete(adresse.get());
			return true;
		}else {
			return false;
		}
	}
}
