package com.signet.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.s3.model.Bucket;
import com.signet.dto.AreaDto;
import com.signet.handler.AreaHandler;
import com.signet.model.Area;
import com.signet.service.ValidationService;
import com.signet.utilities.StorageService;

@RestController
@RequestMapping("/area")
@CrossOrigin
public class AreaController {

	@Autowired
	private AreaHandler handler;
	@Autowired
	private StorageService service;
	
	@Autowired
	private ValidationService validationService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Area> area(@PathVariable("id") long id) {
		return new ResponseEntity<>(handler.getAreaOne(id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<Iterator<Area>> areaList() {
		return new ResponseEntity<>(handler.getAreas(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Area> saveArea(@RequestBody AreaDto dto) {
		try {
			validationService.validateArea(dto);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(handler.saveArea(dto), HttpStatus.OK);
	}

	@GetMapping(value = "/aws")
	public ResponseEntity<String> aws() {
		List<Bucket> buckets = service.listBuckets();

		if (buckets != null && !buckets.isEmpty()) {
			for (Bucket bucket : buckets) {
				System.out.println(bucket.getName());
			}
		}

		// service.uploadObject();
		service.listObjects();
		try {
			service.downloadObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(service.getResourceURL("csism", "Document/README.md"));
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}

}
