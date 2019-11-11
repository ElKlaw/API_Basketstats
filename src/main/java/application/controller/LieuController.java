package application.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import application.bean.Lieu;
import application.service.ILieuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = {"Lieu"})
public class LieuController {
	@Autowired
	private ILieuService lieuService;
	
	@ApiOperation(value="Trouver tous les  salles")
	@GetMapping("/salles")
	public ResponseEntity<List<Lieu>> getSalles(@RequestParam(value="search_query") String nom) {
		List<Lieu> lieux = lieuService.getSalles(nom);
		return new ResponseEntity<>(lieux, HttpStatus.OK);
	}
	
	@ApiOperation(value="Trouver les salles d'un club")
	@GetMapping("club/{id}/salles")
	public ResponseEntity<List<Lieu>> getSallesFromClub(@PathVariable("id") Integer id) {
		List<Lieu> lieux = lieuService.getSallesClub(id);
		return new ResponseEntity<>(lieux, HttpStatus.OK);
	}
	
	@ApiOperation(value="Trouver le lieu correspondant à l'ID")
	@GetMapping("lieu/{id}")
	public ResponseEntity<Lieu> getLieuById(@PathVariable("id") Integer id) {
		Optional<Lieu> lieu = lieuService.getLieuById(id);
		if(lieu.isPresent()) {
			return new ResponseEntity<>(lieu.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Ajout d'un nouveau lieu")
	@PostMapping("lieu")
	public ResponseEntity<Lieu> addLieu(@RequestBody Lieu lieu) {
		Lieu lieuResponse = lieuService.addLieu(lieu);
		return new ResponseEntity<>(lieuResponse, HttpStatus.OK);
	}
	
	@ApiOperation(value="Modifier un lieu")
	@PutMapping("lieu")
	public ResponseEntity<Lieu> updateLieu(@RequestBody Lieu lieu) {
		Lieu lieuResponse = lieuService.updateLieu(lieu);
		return new ResponseEntity<>(lieuResponse, HttpStatus.OK);
	}
	
	@ApiOperation(value="Supprimer le lieu correspondant à l'ID")
	@DeleteMapping("lieu/{id}")
	public ResponseEntity<Void> deleteLieu(@PathVariable("id") Integer id) {
		lieuService.deleteLieu(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
