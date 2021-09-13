package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.PeopleModel;
import com.example.demo.repositories.PeopleRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Api(value = "Swagger2RestController", description = "API Rest for people registration ")
@RestController
public class PeopleController {
	
	@Autowired
	private PeopleRepository repo;
	
	@ApiOperation(value = "Return people registered", response = Iterable.class, tags = "getPeople")
	@GetMapping
	public List<PeopleModel> getPeople(){
		return repo.findAll();		
	}
	
	@ApiOperation(value = "Return person registered by id", response = Iterable.class, tags = "getPerson")
	@GetMapping("/{id}")
	public Optional<PeopleModel> getPerson(@PathVariable Long id){
		return repo.findById(id);
	}
	
	@ApiOperation(value = "Delete person by id", response = Iterable.class, tags="deletePerson")
	@DeleteMapping("/id")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePerson(@PathVariable Long id) {
		repo.deleteById(id);
	}
	
	@ApiOperation(value = "Update person by id", response = Iterable.class, tags="upPerson")
	@PutMapping("/{id}")
	public PeopleModel upPerson(@RequestBody PeopleModel person, @PathVariable Long id) {
		PeopleModel p = repo.getOne(id);
		
		if(p == null) {
			return null;
		}
		p.setName(person.getName());
		p.setAge(person.getAge());
		p.setCity(person.getCity());
		p.setMotherName(person.getMotherName());
		p.setFatherName(person.getFatherName());
		
		return repo.save(p);
	}
	
	@ApiOperation(value = "Register new person", response = Iterable.class, tags = "newPerson")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PeopleModel newPerson(@RequestBody PeopleModel person) {
		return repo.save(person);
	}
	
	
	
	
}

