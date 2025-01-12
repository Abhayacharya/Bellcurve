package com.springboot.bellcurve;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.springboot.bellcurve.model.Employee;
import com.springboot.bellcurve.repository.EmployeeRepository;
import com.springboot.bellcurve.service.EmployeeService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BellcurveApplicationTests {
    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    public BellcurveApplicationTests() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllEmployees() {
        List<Employee> employees = Arrays.asList(
                new Employee(1L, "Harry 1", 'A'),
                new Employee(2L, "Harry 2", 'B')
        );
        when(employeeRepository.findAll()).thenReturn(employees);

        List<Employee> result = employeeService.getAllEmployees();

        assertEquals(2, result.size());
        assertEquals("Harry 1", result.get(0).getName());
    }
}