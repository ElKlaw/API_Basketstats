package application.controller;

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

import application.bean.Adresse;
import application.service.IAdresseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = {"Adresse"})
public class AdresseController {
	@Autowired
	private IAdresseService adresseService;
	
	@ApiOperation(value="Trouver le lieu correspondant à l'ID")
	@GetMapping("adresse/{id}")
	public ResponseEntity<Adresse> getAdresseById(@PathVariable("id") Integer id) {
		Optional<Adresse> adresse = adresseService.getAdresseById(id);
		if(adresse.isPresent()) {
			return new ResponseEntity<>(adresse.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Ajout d'une nouvelle adresse")
	@PostMapping("adresse")
	public ResponseEntity<Adresse> addAdresse(@RequestBody Adresse adresse) {
		Adresse adresseResponse = adresseService.addAdresse(adresse);
		return new ResponseEntity<>(adresseResponse, HttpStatus.OK);
	}
	
	@ApiOperation(value="Modifier une adresse")
	@PutMapping("adresse")
	public ResponseEntity<Adresse> updateAdresse(@RequestBody Adresse adresse) {
		Adresse adresseResponse = adresseService.updateAdresse(adresse);
		return new ResponseEntity<>(adresseResponse, HttpStatus.OK);
	}
	
	@ApiOperation(value="Supprimer l'adresse correspondant à l'ID")
	@DeleteMapping("adresse/{id}")
	public ResponseEntity<Void> deleteAdresse(@PathVariable("id") Integer id) {
		adresseService.deleteAdresse(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
