package com.dattta.employeeapi.controller;


import com.dattta.employeeapi.model.Employee;
import com.dattta.employeeapi.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;
    @GetMapping("/")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("all is good");
    }

    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable long id) {
        return ResponseEntity.ok(service.getEmployee(id));
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable long id) {
        return ResponseEntity.ok(service.deleteEmployee(id));
    }


    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {

        return ResponseEntity.ok(service.saveEmployee(employee));
    }
    @PostMapping("/updateEmployee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {

        return ResponseEntity.ok(service.updateEmployee(employee));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(service.getAllEmployees());
    }
}
