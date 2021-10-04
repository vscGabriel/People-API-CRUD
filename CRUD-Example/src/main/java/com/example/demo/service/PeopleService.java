package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.PeopleModel;
import com.example.demo.repositories.PeopleRepository;

@Service
public class PeopleService {
	
	@Autowired
	private PeopleRepository repo;
	
	public List<PeopleModel> findAll(){
		return repo.findAll();
	}

	public Optional<PeopleModel> findById(Long id) {
		return repo.findById(id);
	}

	public void deleteById(Long id) {
		return repo.deleteById(id);
	}

	public PeopleModel getOne(Long id) {
		return repo.getOne(id);
	}

	public PeopleModel save(PeopleModel person) {
		
		return repo.save(person);
	}
	
	
	
}
