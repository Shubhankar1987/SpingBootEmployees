package com.example.controller;

import com.example.model.Employees;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/emps")

public class EmployeeController {
    @Autowired
    private EmployeeRepository empRepository;

    @GetMapping
    public List<Employees> getAllUsers() {
        return empRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employees> getUserById(@PathVariable(value = "id") Long empId){

        Employees emp = empRepository.findById(empId)
                .orElseThrow(() -> new NoSuchElementException("Employee not available for Id :" + empId));

        return ResponseEntity.ok().body(emp);
    }
}
