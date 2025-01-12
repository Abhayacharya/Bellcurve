package com.springboot.bellcurve.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bellcurve.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}