package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.models.PeopleModel;
import com.example.demo.service.PeopleService;


@Controller
@RequestMapping("/")
public class PeopleController {
	
	@Autowired
	private PeopleService service;
	
	@GetMapping("/get")
	public List<PeopleModel> getPeople(){
		return service.findAll();		
	}
	
	@GetMapping("/{id}")
	public Optional<PeopleModel> getPerson(@PathVariable Long id){
		return service.findById(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePerson(@PathVariable Long id) {
		service.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PeopleModel> upPerson(@RequestBody PeopleModel person, @PathVariable Long id) {
		return ResponseEntity.ok(service.update(id, person));
		
	}
	
	@PostMapping("/post")
	@ResponseStatus(HttpStatus.CREATED)
	public PeopleModel newPerson(@RequestBody PeopleModel person) {
		return service.save(person);
	}
	
	
	
	
}

