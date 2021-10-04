package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
	
	public PeopleModel update(final Long id, final PeopleModel person) {
		PeopleModel p = repo.getOne(id);
		
		if(p == null) {
			return null;
		}
		p.setName(person.getName());
		p.setAge(person.getAge());
		p.setCity(person.getCity());
		
		return repo.save(p);
	}

	public PeopleModel save(PeopleModel person) {
		
		return repo.save(person);
	}
	
	
	
}
