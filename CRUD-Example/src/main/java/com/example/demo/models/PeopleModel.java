package com.example.demo.models;

import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class PeopleModel {
	
	@ApiModelProperty(notes = "Person ID's", name="id", required = true, value = "Person ID's")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ApiModelProperty(notes = "Person name's", name="name", required = true, value = "Person name's")
	@Column(nullable = false)
	private String name;
	
	@ApiModelProperty(notes = "Person age's", name="age", required = true, value = "Person age's")
	@Column(nullable = false)
	private Integer age;
	
	@ApiModelProperty(notes = "Person city's", name="city", required = true, value = "Person city's")
	@Column(nullable = false)
	private String city;
	
	@ApiModelProperty(notes = "Person mother's", name="motherName", required = true, value = "Person mother name's")
	@Column(nullable = false)
	private String motherName;
	
	@ApiModelProperty(notes = "Person father's", name="fatherName", required = true, value = "Person father name's")
	@Column(nullable = false)	
	private String fatherName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	
	
}
