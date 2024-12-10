package com.dattta.employeeapi.service;

import com.dattta.employeeapi.exception.EmployeeAlreadyExistsException;
import com.dattta.employeeapi.exception.EmployeeNotFoundException;
import com.dattta.employeeapi.model.Employee;
import com.dattta.employeeapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Employee saveEmployee(Employee employee) {
        if (repository.existsByName(employee.getName())) {
            throw new EmployeeAlreadyExistsException("Employee  already exists");
        }
        return repository.save(employee);
    }
    public Employee getEmployee(Long id) {
        if (!repository.existsById(id)) {
            throw new EmployeeNotFoundException("Employee Not exists");
        }
        return repository.findById(id).get();
    }

    public Boolean deleteEmployee(Long id) {
        if (!repository.existsById(id)) {
            throw new EmployeeNotFoundException("Employee Not exists");

        }
        Employee employee1=repository.findById(id).get();
        repository.delete(employee1);
        return !repository.existsById(id);
    }

    public Employee updateEmployee(Employee employee) {
        if (!repository.existsById(employee.getId())) {
            throw new EmployeeNotFoundException("Employee Not exists");
        }
        Employee employee1=repository.findById(employee.getId()).get();
        employee1.setDepartment(employee.getDepartment());
        employee1.setName(employee.getName());
        employee1.setSalary(employee.getSalary());
        return repository.save(employee1);
    }
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }
}