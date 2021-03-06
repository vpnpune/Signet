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

import com.signet.dto.PackagesDto;
import com.signet.handler.PackagesHandler;
import com.signet.model.Package;

@RestController
@RequestMapping("/packages")
@CrossOrigin
public class PackagesController {

	@Autowired
	private PackagesHandler handler;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Package> getPackages(@PathVariable("id") long id) {
		return new ResponseEntity<>(handler.getPackagesOne(id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<Iterator<Package>> packagesList() {
		return new ResponseEntity<>(handler.getPackages(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Package> savePackages(@RequestBody PackagesDto packagesDto) {
		return new ResponseEntity<>(handler.savePackages(packagesDto), HttpStatus.OK);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Package> updatePackages(@PathVariable(value = "id") Long id,
            @RequestBody PackagesDto packagesDto) {
		return new ResponseEntity<>(handler.updatePackages(id, packagesDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deletePackages(@PathVariable(value = "id") Long id) {
		return new ResponseEntity<>(handler.deletePackages(id), HttpStatus.OK);
	}
}
