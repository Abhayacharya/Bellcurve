package com.springboot.bellcurve.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bellcurve.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Character> {
}