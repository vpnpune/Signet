package com.signet.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.signet.dto.ChannelsDto;
import com.signet.handler.ChannelsHandler;
import com.signet.model.Channels;

@RestController
@RequestMapping("/channels")
public class ChannelsController {

	@Autowired
	private ChannelsHandler handler;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Channels> channel(@PathVariable("id") long id) {
		return new ResponseEntity<>(handler.getChannelsOne(id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<Iterator<Channels>> channelsList() {
		return new ResponseEntity<>(handler.getchannels(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Channels> saveChannel(@RequestBody ChannelsDto channelsDto) {
		return new ResponseEntity<>(handler.saveChannel(channelsDto), HttpStatus.OK);
	}
}
