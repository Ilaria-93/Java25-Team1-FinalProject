package com.example.team_project.services;

import com.example.team_project.repositories.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createNewEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> listEmployees() {
        return employeeRepository.findAll();
    }
}
