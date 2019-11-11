package application.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import application.bean.Club;
import application.bean.Equipe;
import application.service.IClubService;
import application.service.IEquipeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = {"Equipe"})
public class EquipeController {
	@Autowired
	private IEquipeService equipeService;
	
	@Autowired
	private IClubService clubService;
	
	@ApiOperation(value="Obtenir l'ensemble des equipes")
	@GetMapping("/equipes")
	public ResponseEntity<List<Equipe>> getAllEquipeWithPageAndSize(@RequestParam(defaultValue="0", value="page", required=false) int page, 
			@RequestParam(defaultValue="10", value="size", required=false) int size){
		Pageable pageable =  PageRequest.of(page, size);
		List<Equipe> listEquipe = equipeService.getAllEquipes(pageable);
		return new ResponseEntity<>(listEquipe,HttpStatus.OK);
	}
	
	@ApiOperation(value="Obtenir l'ensemble des équipes correspondant à la recherche")
	@GetMapping("/equipes/results")
	public ResponseEntity<List<Equipe>> searchEquipe(@RequestParam(value="search_query") String nom, 
			@RequestParam(defaultValue="0", value="page", required=false) int page, 
			@RequestParam(defaultValue="10", value="size", required=false) int size){
		Pageable pageable =  PageRequest.of(page, size);
		List<Equipe> listEquipe = equipeService.searchEquipes(nom, pageable);
		return new ResponseEntity<>(listEquipe,HttpStatus.OK);
	}
	
	@ApiOperation(value="Trouver l'équipe correspondant à l'ID")
	@GetMapping("equipe/{id}")
	public ResponseEntity<Equipe> getEquipeById(@PathVariable("id") Integer id) {
		Optional<Equipe> equipe = equipeService.getEquipeById(id);
		if(equipe.isPresent()) {
			return new ResponseEntity<>(equipe.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Ajout d'une nouvelle équipe")
	@PostMapping("equipe")
	public ResponseEntity<Equipe> addEquipe(@RequestBody Equipe equipe) {
		Equipe equipeResponse = equipeService.addEquipe(equipe);
		return new ResponseEntity<>(equipeResponse, HttpStatus.OK);
	}
	
	@ApiOperation(value="Ajout d'une nouvelle équipe avec l'ID du club")
	@PostMapping("/club/{id}/equipe")
	public ResponseEntity<Equipe> addEquipeWithIdClub(@PathVariable("id") Integer id, @RequestBody Equipe equipe) {
		Optional<Club> club = clubService.getClubById(id);
		if(club.isPresent()) {
			equipe.setClubEquipe(club.get());
			Equipe equipeResponse = equipeService.addEquipe(equipe);
			return new ResponseEntity<>(equipeResponse, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Modifier une équipe")
	@PutMapping("equipe")
	public ResponseEntity<Equipe> updateEquipe(@RequestBody Equipe club) {
		Equipe equipeResponse = equipeService.updateEquipe(club);
		return new ResponseEntity<>(equipeResponse, HttpStatus.OK);
	}
	
	@ApiOperation(value="Supprimer l'équipe correspondant à l'ID")
	@DeleteMapping("equipe/{id}")
	public ResponseEntity<Void> deleteEquipe(@PathVariable("id") Integer id) {
		equipeService.deleteEquipe(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value="Obtenir l'ensemble des équipes d'un joueur")
	@GetMapping("/joueur/{id}/equipes")
	public ResponseEntity<List<Equipe>> getEquipesJoueur(@PathVariable("id") Integer id){
		List<Equipe> listEquipe = equipeService.getEquipesJoueur(id);
		return new ResponseEntity<>(listEquipe,HttpStatus.OK);
	}	
	
	@ApiOperation(value="Obtenir l'ensemble des equipes d'un club")
	@GetMapping("/club/{id}/equipes")
	public ResponseEntity<List<Equipe>> getAllEquipesFromClub(@PathVariable("id") Integer id){
		List<Equipe> listEquipe = equipeService.getEquipesClub(id);
		return new ResponseEntity<>(listEquipe,HttpStatus.OK);
	}
	
	@ApiOperation(value="Obtenir mes équipes")
	@GetMapping("/mesequipes")
	public ResponseEntity<List<Equipe>> getMesEquipes(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		List<Equipe> listEquipe = equipeService.getEquipesJoueur(Integer.parseInt((String) authentication.getPrincipal()));
		return new ResponseEntity<>(listEquipe,HttpStatus.OK);
	}
	
}
