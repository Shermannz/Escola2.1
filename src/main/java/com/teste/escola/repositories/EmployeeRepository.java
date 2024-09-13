package com.teste.escola.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.escola.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmail(String email);
}
