package application.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import application.bean.User;
import application.bean.Utilisateur;
import application.repository.UtilisateurRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Utilisateur> utilisateur = utilisateurRepository.findUtilisateurByIdentifiant(username);
		if(utilisateur.isPresent()) {
			return User.build(utilisateur.get());
		} else {
			return null;
		}
	}
}
