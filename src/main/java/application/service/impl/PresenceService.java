package application.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.bean.Presence;
import application.repository.PresenceRepository;
import application.service.IPresenceService;

@Service
public class PresenceService implements IPresenceService{
	@Autowired
	private PresenceRepository presenceRepository;
	
	@Override
	public List<Presence> getPresencesJoueur(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Presence> getPresencesMatch(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Presence> getPresenceById(int id) {
		return presenceRepository.findById(id);
	}

	@Override
	public Presence addPresence(Presence presence) {
		presenceRepository.save(presence);
		return presence;
	}

	@Override
	public Presence updatePresence(Presence presence) {
		presenceRepository.save(presence);
		return presence;
	}

	@Override
	public boolean deletePresence(int id) {
		Optional<Presence> presence = getPresenceById(id);
		if(presence.isPresent()) {
			presenceRepository.delete(presence.get());
			return true;
		}else {
			return false;
		}
	}

}
