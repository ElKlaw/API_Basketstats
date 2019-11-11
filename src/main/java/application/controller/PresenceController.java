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

import application.bean.Presence;
import application.service.IPresenceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = {"Presence"})
public class PresenceController {
	@Autowired
	private IPresenceService presenceService;
	
	@ApiOperation(value="Trouver la presence correspondant à l'ID")
	@GetMapping("presence/{id}")
	public ResponseEntity<Presence> getPresenceById(@PathVariable("id") Integer id) {
		Optional<Presence> joueur = presenceService.getPresenceById(id);
		if(joueur.isPresent()) {
			return new ResponseEntity<>(joueur.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Ajout d'une nouvelle presence")
	@PostMapping("presence")
	public ResponseEntity<Presence> addPresence(@RequestBody Presence presence) {
		Presence presenceResponse = presenceService.addPresence(presence);
		return new ResponseEntity<>(presenceResponse, HttpStatus.OK);
	}
	
	@ApiOperation(value="Modifier une presence")
	@PutMapping("presence")
	public ResponseEntity<Presence> updatePresence(@RequestBody Presence presence) {
		Presence presenceResponse = presenceService.updatePresence(presence);
		return new ResponseEntity<>(presenceResponse, HttpStatus.OK);
	}
	
	@ApiOperation(value="Supprimer la presence correspondant à l'ID")
	@DeleteMapping("presence/{id}")
	public ResponseEntity<Void> deletePresence(@PathVariable("id") Integer id) {
		presenceService.deletePresence(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
