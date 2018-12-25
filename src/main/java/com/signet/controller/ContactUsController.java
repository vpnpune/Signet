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

import com.signet.dto.ContactUsDto;
import com.signet.handler.ContactUsHandler;
import com.signet.model.ContactUs;
import com.signet.service.ValidationService;

@RestController
@RequestMapping("/contactus")
@CrossOrigin
public class ContactUsController {

	@Autowired
	private ContactUsHandler handler;
	
	@Autowired
	private ValidationService validationService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<ContactUs> getContactUs(@PathVariable("id") long id) {
		return new ResponseEntity<>(handler.getContactUsOne(id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<Iterator<ContactUs>> contactUsList() {
		return new ResponseEntity<>(handler.getContactUs(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ContactUs> saveContactUs(@RequestBody ContactUsDto dto) {
		return new ResponseEntity<>(handler.saveContactUs(dto), HttpStatus.OK);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<ContactUs> updateContactUs(@PathVariable(value = "id") Long id,
            @RequestBody ContactUsDto contactUsDto) {
		return new ResponseEntity<>(handler.updateContactUs(id, contactUsDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteContactUs(@PathVariable(value = "id") Long id) {
		return new ResponseEntity<>(handler.deleteContactUs(id), HttpStatus.OK);
	}

}
