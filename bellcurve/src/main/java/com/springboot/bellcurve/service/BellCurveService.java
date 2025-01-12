package com.springboot.bellcurve.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bellcurve.model.Category;
import com.springboot.bellcurve.model.Employee;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BellCurveService {
    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private CategoryService categoryService;

    public Map<Character, Long> calculateActualPercentage() {
        List<Employee> employees = employeeService.getAllEmployees();
        long totalEmployees = employees.size();

        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getRating, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100) / totalEmployees
                ));
    }

    public Map<Character, BigDecimal> calculateDeviation(Map<Character, Long> actualPercentage) {
        List<Category> categories = categoryService.getAllCategories();
        return categories.stream()
                .collect(Collectors.toMap(
                        Category::getRating,
                        category -> {
                            long actual = actualPercentage.getOrDefault(category.getRating(), 0L);
                            return BigDecimal.valueOf(actual).subtract(category.getStandardPercentage());
                        }
                ));
    }

    
}