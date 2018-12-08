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

import com.signet.dto.AreaDto;
import com.signet.handler.AreaHandler;
import com.signet.model.Area;
import com.signet.service.ValidationService;

@RestController
@RequestMapping("/area")
@CrossOrigin
public class AreaController {

	@Autowired
	private AreaHandler handler;
	
	@Autowired
	private ValidationService validationService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Area> getArea(@PathVariable("id") long id) {
		return new ResponseEntity<>(handler.getAreaOne(id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<Iterator<Area>> areaList() {
		return new ResponseEntity<>(handler.getAreas(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Area> saveArea(@RequestBody AreaDto dto) {
		return new ResponseEntity<>(handler.saveArea(dto), HttpStatus.OK);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Area> updateArea(@PathVariable(value = "id") Long id,
            @RequestBody AreaDto areaDto) {
		return new ResponseEntity<>(handler.updateArea(id, areaDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteArea(@PathVariable(value = "id") Long id) {
		return new ResponseEntity<>(handler.deleteArea(id), HttpStatus.OK);
	}

}
