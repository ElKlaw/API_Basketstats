package application.controller;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import application.bean.Role;
import application.bean.Utilisateur;
import application.service.IRoleService;
import application.service.IUtilisateurService;
import application.utils.enumeration.RoleName;
import io.swagger.annotations.ApiOperation;

@RestController
public class UtilisateurController {
	@Autowired
    IUtilisateurService utilisateurService;
	@Autowired
	IRoleService roleService;
	@Autowired
    PasswordEncoder encoder;
	
	@ApiOperation(value="Ajout d'un nouvelle utilisateur")
	@PostMapping(value="utilisateur")
	public ResponseEntity<Utilisateur> addUtilisateur(@RequestBody Utilisateur utilisateur) {
		utilisateur.setMotdepasse(encoder.encode(utilisateur.getMotdepasse()));
		Role role = roleService.getRoleByName(RoleName.USER.name());
		Set<Role> roles = new HashSet<>();
        roles.add(role);
        utilisateur.setRoles(roles);
        String generatedString = RandomStringUtils.random(20, true, true);
        utilisateur.setSecret(generatedString);
        
		Utilisateur utilisateurResponse = utilisateurService.addUtilisateur(utilisateur);
		return new ResponseEntity<>(utilisateurResponse, HttpStatus.OK);
	}
	
	@ApiOperation(value="Modifier un utilisateur")
	@PutMapping("utilisateur")
	public ResponseEntity<Utilisateur> updateUtilisateur(@RequestBody Utilisateur utilisateur) {
		Utilisateur utilisateurResponse = utilisateurService.updateUtilisateur(utilisateur);
		return new ResponseEntity<>(utilisateurResponse, HttpStatus.OK);
	}
	
	
	@ApiOperation(value="Trouver l'utilisateur")
	@GetMapping("utilisateur")
	public ResponseEntity<Utilisateur> getUtilisateurById() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Optional<Utilisateur> utilisateur = utilisateurService.getUtilisateurById(Integer.parseInt((String) authentication.getPrincipal()));
		if(utilisateur.isPresent()) {
			return new ResponseEntity<>(utilisateur.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}