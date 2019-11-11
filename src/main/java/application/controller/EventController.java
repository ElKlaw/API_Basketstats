package application.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;

import application.bean.Event;
import application.service.IEventService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = {"Event"})
public class EventController {
	@Autowired
	private IEventService eventService;
	
	@ApiOperation(value="Trouver les events de l'équipe correspondant à l'ID")
	@GetMapping("equipe/{id}/events")
	public ResponseEntity<List<Event>> getEventsEquipe(@PathVariable("id") Integer id) {
		List<Event> listEvent = eventService.getEventsEquipe(id);
		return new ResponseEntity<>(listEvent,HttpStatus.OK);
	}
	
	@ApiOperation(value="Trouver les events du club correspondant à l'ID")
	@GetMapping("club/{id}/events")
	public ResponseEntity<List<Event>> getEventsClub(@PathVariable("id") Integer id) {
		List<Event> listEvent = eventService.getEventsClub(id);
		return new ResponseEntity<>(listEvent,HttpStatus.OK);
	}
	
	@ApiOperation(value="Trouver les events du joueur correspondant à l'ID")
	@GetMapping("joueur/{id}/events")
	public ResponseEntity<List<Event>> getEventsJoueur(@PathVariable("id") Integer id) {
		List<Event> listEvent = eventService.getEventsJoueur(id);
		return new ResponseEntity<>(listEvent,HttpStatus.OK);
	}
	
	@ApiOperation(value="Trouver l'event correspondant à l'ID")
	@GetMapping("event/{id}")
	public ResponseEntity<Event> getEventById(@PathVariable("id") Integer id) {
		Optional<Event> event = eventService.getEventById(id);
		if(event.isPresent()) {
			return new ResponseEntity<>(event.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Ajout d'un event")
	@PostMapping("event")
	public ResponseEntity<Event> addEvent(@RequestBody Event event) {
		Event eventResponse = eventService.addEvent(event);
		return new ResponseEntity<>(eventResponse, HttpStatus.OK);
	}
	
	@ApiOperation(value="Modifier un event")
	@PutMapping("event")
	public ResponseEntity<Event> updateEvent(@RequestBody Event event) {
		Event eventResponse = eventService.updateEvent(event);
		return new ResponseEntity<>(eventResponse, HttpStatus.OK);
	}
	
	@ApiOperation(value="Supprimer l'event correspondant à l'ID")
	@DeleteMapping("event/{id}")
	public ResponseEntity<Void> deleteEvent(@PathVariable("id") Integer id) {
		eventService.deleteEvent(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value="Trouver mes events")
	@GetMapping("mesevents")
	public ResponseEntity<List<Event>> getMesEvents() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		List<Event> listEvent = eventService.getEventsJoueur(Integer.parseInt((String) authentication.getPrincipal()));
		return new ResponseEntity<>(listEvent,HttpStatus.OK);
	}
	
	
}
