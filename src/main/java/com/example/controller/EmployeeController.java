package com.example.controller;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Employees;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/")
public class EmployeeController {
    @Autowired
    private EmployeeRepository empRepository;

    @GetMapping("emps")
    public List<Employees> getAll() {
        return empRepository.findAll();
    }

    @GetMapping("emps/{id}")
    public ResponseEntity<Employees> getEmpById(@PathVariable(value = "id") Long empId){
        Employees emp = empRepository.findById(empId)
                .orElseThrow(() -> new NoSuchElementException("Employee not available for Id : " + empId));

        return ResponseEntity.ok().body(emp);
    }

    @PostMapping(path = "emps", consumes = MediaType.APPLICATION_JSON_VALUE,
                                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employees> create(@RequestBody Employees newEmp) throws Exception {
        Employees emp = empRepository.save(newEmp);
        if (emp == null) {
            throw new ServerException("Not able to add record");
        } else {
            return new ResponseEntity<>(emp, HttpStatus.CREATED);
        }
    }

    @PutMapping("emps/{id}")
    public ResponseEntity<Employees> updateEmployee(@PathVariable long id,
                                                    @RequestBody Employees employeeDetails) throws Exception {
        Employees updateEmployee = empRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        updateEmployee.setEmpName(employeeDetails.getEmpName());
        updateEmployee.setEmpType(employeeDetails.getEmpType());
        updateEmployee.setDateofBirth(employeeDetails.getDateofBirth());
        updateEmployee.setUpdatedTime(employeeDetails.getUpdatedTime());
        updateEmployee.setPassword(employeeDetails.getPassword());
        updateEmployee.setCreationTime(employeeDetails.getCreationTime());

        empRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }

    @DeleteMapping("emps/{id}")
    public HttpStatus deleteEmployee(@PathVariable long id) {
        try {
            empRepository.deleteById(id);
        } catch(Exception ex) {
            throw new ResourceNotFoundException("Employee not exist with id: " + id);
        }
        return HttpStatus.OK;
    }

}