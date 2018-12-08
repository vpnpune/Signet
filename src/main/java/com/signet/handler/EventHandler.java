package com.signet.handler;

import java.util.Iterator;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signet.dto.EventDto;
import com.signet.exception.NotFoundException;
import com.signet.model.Event;
import com.signet.repository.EventRepository;

@Service
public class EventHandler {

	@Autowired
	private EventRepository repository;

	public Event getEventOne(Long id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException("eventId", String.valueOf(id)));
	}

	public Iterator<Event> getEvents() {
		return repository.findAll().iterator();
	}

	public Event saveEvent(EventDto EventDto) {
		Event event = new Event();
		BeanUtils.copyProperties(EventDto, event);
		return repository.save(event);
	}

	public Event updateEvent(long id, EventDto eventDto) {
		Event event = getEventOne(id);
		
		event.setEventStartTime(eventDto.getEventStartTime());
		event.setCompleted(eventDto.isCompleted());
		event.setEndTime(eventDto.getEndTime());
		event.setEventDetails(eventDto.getEventDetails());
		event.setEventTitle(eventDto.getEventTitle());
		event.setStreamingURL(eventDto.getStreamingURL());
		
		return repository.save(event);
	}

	public boolean deleteEvent(Long id) {
		Event event = getEventOne(id);
		repository.delete(event);
		return true;
	}

}
