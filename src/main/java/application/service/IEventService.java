package application.service;

import java.util.List;
import java.util.Optional;

import application.bean.Event;

public interface IEventService {
	List<Event>  getEventsClub(int id);
	List<Event>  getEventsEquipe(int id);
	List<Event>  getEventsJoueur(int id);
	
	// Chemins de base
	Optional<Event> getEventById(int id);
	Event addEvent(Event event);
	Event updateEvent(Event event);
	boolean deleteEvent(int id);
}
