package application.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import application.bean.Club;
import application.bean.Ville;
import application.service.IClubService;
import application.service.IVilleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = {"Club"})
public class ClubController {
	@Autowired
	private IClubService clubService;
	
	@Autowired
	private IVilleService villeService;

	@ApiOperation(value="Obtenir l'ensemble des clubs")
	@GetMapping("/clubs")
	public ResponseEntity<List<Club>> getAllClubWithPageAndSize(@RequestParam(defaultValue="0", value="page", required=false) int page, 
			@RequestParam(defaultValue="3", value="size", required=false) int size){
		Pageable pageable =  PageRequest.of(page, size);
		List<Club> listClub = clubService.getAllClubs(pageable);
		return new ResponseEntity<>(listClub,HttpStatus.OK);
	}
	
	@ApiOperation(value="Obtenir l'ensemble des clubs correspondant à la recherche")
	@GetMapping("/clubs/results")
	public ResponseEntity<Page<Club>> searchClubs(@RequestParam(defaultValue="", value="search_query", required=false) String nom, 
			@RequestParam(defaultValue="0", value="page", required=false) int page, 
			@RequestParam(defaultValue="3", value="size", required=false) int size){
		Pageable pageable =  PageRequest.of(page, size);
		Page<Club> listClub = clubService.searchClubs(nom, pageable);
		return new ResponseEntity<>(listClub,HttpStatus.OK);
	}
	
	@ApiOperation(value="Trouver le club correspondant à l'ID")
	@GetMapping("club/{url}")
	public ResponseEntity<Club> getClubByURL(@PathVariable("url") String url) {
		Optional<Club> club = clubService.getClubByURL(url);
		if(club.isPresent()) {
			return new ResponseEntity<>(club.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Ajout d'un nouveau club")
	@PostMapping(value="club")
	public ResponseEntity<Club> addClub(@RequestBody Club club) {
		Club result = new Club(club);
		Set<Ville> villesToAdd = club.getVilles();
		
		// Création du club
		club.setVilles(new HashSet<Ville>());
		Club clubResponse = clubService.addClub(club);
		
		//Ajout des villes
		Set<Ville> villes = new HashSet<Ville>();
		villesToAdd.stream().forEach(ville -> {
			ville.setClubVille(clubResponse);
			villes.add(villeService.addVille(ville));
		});
		result.setVilles(villes);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@ApiOperation(value="Supprimer le club correspondant à l'ID")
	@DeleteMapping("club/{id}")
	public ResponseEntity<Void> deleteClub(@PathVariable("id") Integer id) {
		clubService.deleteClub(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value="modifie le club correspondant à l'ID")
	@PutMapping("club/{id}")
	public ResponseEntity<Club> patchClub(@PathVariable("id") Integer id, @RequestBody Club club) {
		Optional<Club> optionalClub = clubService.getClubById(id);
		if(optionalClub.isPresent()) {
			club.setId(id);
			Club responseClub = clubService.updateClub(club);
			return new ResponseEntity<>(responseClub, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Vérifier URL disponible")
	@GetMapping("club/exist")
	public ResponseEntity<Boolean> existClub(@RequestParam(value="url", required=true) String url) {
		boolean resultat = clubService.existClub(url);
		return new ResponseEntity<>(resultat, HttpStatus.OK);
	}
}

