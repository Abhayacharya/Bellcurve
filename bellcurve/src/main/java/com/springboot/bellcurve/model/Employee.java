package com.springboot.bellcurve.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private char rating;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getRating() {
		return rating;
	}
	public void setRating(char rating) {
		this.rating = rating;
	}
	public Employee(Long id, String name, char rating) {
		super();
		this.id = id;
		this.name = name;
		this.rating = rating;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", rating=" + rating + "]";
	}

    
}