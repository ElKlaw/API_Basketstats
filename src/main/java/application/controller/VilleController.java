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
import org.springframework.web.bind.annotation.RestController;

import application.bean.Ville;
import application.service.IVilleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = {"Ville"})
public class VilleController {
	@Autowired
	private IVilleService villeService;
	
	@ApiOperation(value="Trouver les villes du club correspondant à l'ID")
	@GetMapping("club/{id}/villes")
	public ResponseEntity<List<Ville>> getVilleById(@PathVariable("id") Integer id) {
		List<Ville> listVille = villeService.getVillesClub(id);
		return new ResponseEntity<>(listVille,HttpStatus.OK);
	}
	
	@ApiOperation(value="Ajout d'une nouvelle ville")
	@PostMapping("ville")
	public ResponseEntity<Ville> addVille(@RequestBody Ville ville) {
		Ville villeResponse = villeService.addVille(ville);
		return new ResponseEntity<>(villeResponse, HttpStatus.OK);
	}
	
	@ApiOperation(value="Modifier une ville")
	@PutMapping("ville/{id}")
	public ResponseEntity<Ville> updateVille(@PathVariable("id") Integer id, @RequestBody Ville ville) {
		Optional<Ville> optionalVille = villeService.getVilleById(id);
		if(optionalVille.isPresent()) {
			ville.setId(id);
			Ville villeResponse = villeService.updateVille(ville);
			return new ResponseEntity<>(villeResponse, HttpStatus.OK);	
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@ApiOperation(value="Supprimer la ville correspondant à l'ID")
	@DeleteMapping("ville/{id}")
	public ResponseEntity<Ville> deleteVille(@PathVariable("id") Integer id) {
		Optional<Ville> optionalVille = villeService.getVilleById(id);
		if(optionalVille.isPresent()) {
			villeService.deleteVille(id);
			return new ResponseEntity<>(optionalVille.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
