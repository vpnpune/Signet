package com.signet.controller;

import java.util.Iterator;

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

import com.signet.dto.ChannelCategoryDto;
import com.signet.handler.ChannelCategoryHandler;
import com.signet.model.ChannelCategory;

@RestController
@RequestMapping("/channelCategory")
@CrossOrigin
public class ChannelCategoryController {

	@Autowired
	private ChannelCategoryHandler handler;

	@GetMapping(value = "/{id}")
	public ResponseEntity<ChannelCategory> getChannelCategory(@PathVariable("id") long id) {
		return new ResponseEntity<>(handler.getChannelCategoryOne(id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<Iterator<ChannelCategory>> channelCategoryList() {
		return new ResponseEntity<>(handler.getChannelCategory(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ChannelCategory> saveChannelCategory(@RequestBody ChannelCategoryDto channelCategoryDto) {
		return new ResponseEntity<>(handler.saveChannelCategory(channelCategoryDto), HttpStatus.OK);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<ChannelCategory> updateChannelCategory(@PathVariable(value = "id") Long id,
            @RequestBody ChannelCategoryDto channelCategoryDto) {
		return new ResponseEntity<>(handler.updateChannelCategory(id, channelCategoryDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteChannelCategory(@PathVariable(value = "id") Long id) {
		return new ResponseEntity<>(handler.deleteChannelCategory(id), HttpStatus.OK);
	}
}
