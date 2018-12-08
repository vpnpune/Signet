package com.signet.controller;

import java.io.IOException;
import java.util.Iterator;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.signet.dto.EventDto;
import com.signet.handler.EventHandler;
import com.signet.model.Event;
import com.signet.service.ValidationService;

@RestController
@RequestMapping("/event")
@CrossOrigin
public class EventController {

	@Autowired
	private EventHandler handler;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Event> getEvent(@PathVariable("id") long id) {
		return new ResponseEntity<>(handler.getEventOne(id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<Iterator<Event>> eventList() {
		return new ResponseEntity<>(handler.getEvents(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Event> saveEvent(@RequestBody EventDto eventDto) {
		return new ResponseEntity<>(handler.saveEvent(eventDto), HttpStatus.OK);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Event> updateEvent(@PathVariable(value = "id") Long id,
            @RequestBody EventDto eventDto) {
		return new ResponseEntity<>(handler.updateEvent(id, eventDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteEvent(@PathVariable(value = "id") Long id) {
		return new ResponseEntity<>(handler.deleteEvent(id), HttpStatus.OK);
	}

}
