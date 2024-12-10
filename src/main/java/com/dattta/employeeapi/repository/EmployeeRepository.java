package com.dattta.employeeapi.repository;

import com.dattta.employeeapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsByName(String name);
    boolean existsById(Long id);

}