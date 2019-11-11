package application.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.bean.Utilisateur;
import application.repository.UtilisateurRepository;
import application.service.IUtilisateurService;

@Service
public class UtilisateurService implements IUtilisateurService{
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Override
	public Utilisateur addUtilisateur(Utilisateur utilisateur) {
		utilisateurRepository.save(utilisateur);
		return utilisateur;
	}
	
	@Override
	public Boolean existsByIdentifiant(String identifiant) {
		Optional<Utilisateur> utilisateur = utilisateurRepository.findUtilisateurByIdentifiant(identifiant);
		return utilisateur.isPresent()?true:false;
	}

	@Override
	public Boolean existsByEmail(String email) {
		Optional<Utilisateur> utilisateur = utilisateurRepository.findUtilisateurByEmail(email);
		return utilisateur.isPresent()?true:false;
	}
	
	@Override
	public Utilisateur updateUtilisateur(Utilisateur utilisateur) {
		utilisateurRepository.save(utilisateur);
		return utilisateur;
	}
	
	@Override
	public Optional<Utilisateur> getUtilisateurById(Integer id) {
		return utilisateurRepository.findById(id);
	}
}
