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

import application.bean.Salle;
import application.service.ISalleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = {"Salle"})
public class SalleController {
	@Autowired
	private ISalleService salleService;
	
	@ApiOperation(value="Trouver les salles du club correspondant à l'ID")
	@GetMapping("club/{id}/salle")
	public ResponseEntity<List<Salle>> getSalleById(@PathVariable("id") Integer id) {
		List<Salle> list = salleService.getSallesClub(id);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@ApiOperation(value="Ajout d'une nouvelle salle")
	@PostMapping("salle")
	public ResponseEntity<Salle> addSalle(@RequestBody Salle salle) {
		Salle response = salleService.addSalle(salle);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value="Modifier une salle")
	@PutMapping("salle/{id}")
	public ResponseEntity<Salle> updateSalle(@PathVariable("id") Integer id, @RequestBody Salle salle) {
		Optional<Salle> optional = salleService.getSalleById(id);
		if(optional.isPresent()) {
			salle.setId(id);
			Salle response = salleService.updateSalle(salle);
			return new ResponseEntity<>(response, HttpStatus.OK);	
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@ApiOperation(value="Supprimer la salle correspondant à l'ID")
	@DeleteMapping("salle/{id}")
	public ResponseEntity<Salle> deleteSalle(@PathVariable("id") Integer id) {
		Optional<Salle> optionalSalle = salleService.getSalleById(id);
		if(optionalSalle.isPresent()) {
			salleService.deleteSalle(id);
			return new ResponseEntity<>(optionalSalle.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
