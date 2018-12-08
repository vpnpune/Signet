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

import com.signet.dto.ChannelsDto;
import com.signet.dto.DistributorDto;
import com.signet.handler.DistributorHandler;
import com.signet.model.Channels;
import com.signet.model.Distributor;

@RestController
@RequestMapping("/distributor")
@CrossOrigin
public class DistributorController {

	@Autowired
	private DistributorHandler handler;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Distributor> getDistributor(@PathVariable("id") long id) {
		return new ResponseEntity<>(handler.getDistributorOne(id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<Iterator<Distributor>> distributorList() {
		return new ResponseEntity<>(handler.getDistributors(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Distributor> saveDistributor(@RequestBody DistributorDto dto) {
		return new ResponseEntity<>(handler.saveDistributor(dto), HttpStatus.OK);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Distributor> updateDistributor(@PathVariable(value = "id") Long id,
            @RequestBody DistributorDto distributorDto) {
		return new ResponseEntity<>(handler.updateDistributor(id, distributorDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteDistributor(@PathVariable(value = "id") Long id) {
		return new ResponseEntity<>(handler.deleteDistributor(id), HttpStatus.OK);
	}
}
