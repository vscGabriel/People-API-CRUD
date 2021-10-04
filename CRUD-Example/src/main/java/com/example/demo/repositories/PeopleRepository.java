package com.example.demo.repositories;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.PeopleModel;

public interface PeopleRepository extends JpaRepository<Id,Long> {


}
