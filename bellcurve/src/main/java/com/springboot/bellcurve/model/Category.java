package com.springboot.bellcurve.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Category {
    @Id
    private char rating;
    private BigDecimal standardPercentage;
	public char getRating() {
		return rating;
	}
	public void setRating(char rating) {
		this.rating = rating;
	}
	public BigDecimal getStandardPercentage() {
		return standardPercentage;
	}
	public void setStandardPercentage(BigDecimal standardPercentage) {
		this.standardPercentage = standardPercentage;
	}
	public Category(char rating, BigDecimal standardPercentage) {
		super();
		this.rating = rating;
		this.standardPercentage = standardPercentage;
	}
	public Category() {
		super();
	}
	@Override
	public String toString() {
		return "Category [rating=" + rating + ", standardPercentage=" + standardPercentage + "]";
	}

    
}