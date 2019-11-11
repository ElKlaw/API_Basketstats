package application.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import application.bean.Joueur;
import application.service.IJoueurService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = {"Joueur"})
public class JoueurController {
	@Autowired
	private IJoueurService joueurService;
	
	@ApiOperation(value="Obtenir l'ensemble des joueurs")
	@GetMapping("/joueurs")
	public ResponseEntity<List<Joueur>> getAllJoueurWithPageAndSize(@RequestParam(defaultValue="0", value="page", required=false) int page, 
			@RequestParam(defaultValue="10", value="size", required=false) int size){
		Pageable pageable =  PageRequest.of(page, size);
		List<Joueur> listJoueur = joueurService.getAllJoueurs(pageable);
		return new ResponseEntity<>(listJoueur,HttpStatus.OK);
	}
	
	@ApiOperation(value="Obtenir l'ensemble des joueurs correspondant à la recherche")
	@GetMapping("/joueurs/results")
	public ResponseEntity<List<Joueur>> searchJoueur(@RequestParam(value="search_query") String nomPrenom, 
			@RequestParam(defaultValue="0", value="page", required=false) int page, 
			@RequestParam(defaultValue="10", value="size", required=false) int size){
		Pageable pageable =  PageRequest.of(page, size);
		List<Joueur> listJoueur = joueurService.searchJoueurs(nomPrenom, pageable);
		return new ResponseEntity<>(listJoueur,HttpStatus.OK);
	}
	
	@ApiOperation(value="Trouver le joueur correspondant à l'ID")
	@GetMapping("joueur/{id}")
	public ResponseEntity<Joueur> getJoueurById(@PathVariable("id") Integer id) {
		Optional<Joueur> joueur = joueurService.getJoueurById(id);
		if(joueur.isPresent()) {
			return new ResponseEntity<>(joueur.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Ajout d'un nouveau joueur")
	@PostMapping("joueur")
	public ResponseEntity<Joueur> addJoueur(@RequestBody Joueur joueur) {
		Joueur joueurResponse = joueurService.addJoueur(joueur);
		return new ResponseEntity<>(joueurResponse, HttpStatus.OK);
	}
	
	@ApiOperation(value="Modifier un joueur")
	@PutMapping("joueur")
	public ResponseEntity<Joueur> updateJoueur(@RequestBody Joueur joueur) {
		Joueur joueurResponse = joueurService.updateJoueur(joueur);
		return new ResponseEntity<>(joueurResponse, HttpStatus.OK);
	}
	
	@ApiOperation(value="Supprimer le joueur correspondant à l'ID")
	@DeleteMapping("joueur/{id}")
	public ResponseEntity<Void> deleteJoueur(@PathVariable("id") Integer id) {
		joueurService.deleteJoueur(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value="Trouver l'ensemble des joueurs d'une equipe")
	@GetMapping("equipe/{id}/joueurs")
	public ResponseEntity<List<Joueur>> getJoueursEquipe(@PathVariable("id") Integer id) {
		List<Joueur> listJoueur = joueurService.getJoueursEquipe(id);
		return new ResponseEntity<>(listJoueur,HttpStatus.OK);
	}
	
	@ApiOperation(value="Obtenir l'ensemble des joueurs d'un club")
	@GetMapping("/club/{id}/joueurs")
	public ResponseEntity<List<Joueur>> getAllJoueursFromClub(@PathVariable("id") Integer id){
		List<Joueur> listJoueur = joueurService.getJoueursClub(id);
		return new ResponseEntity<>(listJoueur,HttpStatus.OK);
	}
}

