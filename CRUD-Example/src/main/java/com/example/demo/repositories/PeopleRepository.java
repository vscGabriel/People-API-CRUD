package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.PeopleModel;

@Repository
public interface PeopleRepository extends JpaRepository<PeopleModel, Long>{

}
