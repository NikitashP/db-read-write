package com.github.tiwarivikash.dbreadwrite.controller;

import com.github.tiwarivikash.dbreadwrite.dao.EmployeeRepository;
import com.github.tiwarivikash.dbreadwrite.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public @RestController
class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> getOne(@PathVariable Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return new ResponseEntity<>(employee.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/", method = RequestMethod.POST)
    public ResponseEntity<Employee> save(@RequestBody Employee newEmployee) {
        Employee employee = employeeRepository.save(newEmployee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }
}

