package application.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.bean.Event;
import application.repository.EventRepository;
import application.service.IEventService;

@Service
public class EventService implements IEventService {

	@Autowired
	private EventRepository eventRepository;
	
	@Override
	public List<Event> getEventsClub(int id) {
		return StreamSupport.stream(eventRepository.getAllEventFromClub(id).spliterator(), false)
                .collect(Collectors.toList());
	}

	@Override
	public List<Event> getEventsEquipe(int id) {
		return StreamSupport.stream(eventRepository.getAllEventFromEquipe(id).spliterator(), false)
                .collect(Collectors.toList());
	}

	@Override
	public List<Event> getEventsJoueur(int id) {
		return StreamSupport.stream(eventRepository.getAllEventFromJoueur(id).spliterator(), false)
                .collect(Collectors.toList());
	}

	@Override
	public Optional<Event> getEventById(int id) {
		return eventRepository.findById(id);
	}

	@Override
	public Event addEvent(Event event) {
		eventRepository.save(event);
		return event;
	}

	@Override
	public Event updateEvent(Event event) {
		eventRepository.save(event);
		return event;
	}

	@Override
	public boolean deleteEvent(int id) {
		Optional<Event> event = getEventById(id);
		if(event.isPresent()) {
			eventRepository.delete(event.get());
			return true;
		}else {
			return false;
		}
	}

}
