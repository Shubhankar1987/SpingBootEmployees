package com.example;
import com.example.model.Employees;
import com.example.repository.EmployeeRepository;
import com.example.util.EmployeeType;
import org.hibernate.usertype.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class SpringBootH2DatabaseExampleApplication {

    @Autowired
    private EmployeeRepository empRepository;

    public static void main(String[] args)
    {
        SpringApplication.run(SpringBootH2DatabaseExampleApplication.class, args);
    }

    @PostConstruct
    private void initDb() throws ParseException {
        Employees employees = new Employees();
        employees.setEmpType(EmployeeType.H);
        employees.setEmpName("Nupur D");
        employees.setPassword("ABC123abc*");
        employees.setDateofBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1968-09-01"));
        employees.setCreationTime(new Date());
        employees.setUpdatedTime(new Date());
        employees.setDateOfBirthString("Love You!");
        empRepository.save(employees);
    }
}