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

import com.signet.dto.AreaDto;
import com.signet.dto.CustomerDto;
import com.signet.handler.AreaHandler;
import com.signet.handler.CustomerHandler;
import com.signet.model.Area;
import com.signet.model.Customer;

@RestController
@RequestMapping("/area")
public class AreaController {

	@Autowired
	private AreaHandler handler;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Area> customer(@PathVariable("id") long id) {
		return new ResponseEntity<>(handler.getAreaOne(id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<Iterator<Area>> customerList() {
		return new ResponseEntity<>(handler.getAreas(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Area> saveCustomer(@RequestBody AreaDto dto) {
		return new ResponseEntity<>(handler.saveArea(dto), HttpStatus.OK);
	}
}
