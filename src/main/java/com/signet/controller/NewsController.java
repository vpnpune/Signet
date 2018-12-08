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

import com.signet.dto.NewsDto;
import com.signet.handler.NewsHandler;
import com.signet.model.News;

@RestController
@RequestMapping("/news")
@CrossOrigin
public class NewsController {

	@Autowired
	private NewsHandler handler;

	@GetMapping(value = "/{id}")
	public ResponseEntity<News> getNews(@PathVariable("id") long id) {
		return new ResponseEntity<>(handler.getNewsOne(id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<Iterator<News>> newsList() {
		return new ResponseEntity<>(handler.getNewss(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<News> saveNews(@RequestBody NewsDto dto) {
		return new ResponseEntity<>(handler.saveNews(dto), HttpStatus.OK);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<News> updateNews(@PathVariable(value = "id") Long id,
            @RequestBody NewsDto newsDto) {
		return new ResponseEntity<>(handler.updateNews(id, newsDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteNews(@PathVariable(value = "id") Long id) {
		return new ResponseEntity<>(handler.deleteNews(id), HttpStatus.OK);
	}
}
