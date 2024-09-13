package com.teste.escola.dto;

import com.teste.escola.entities.Employee;

public class EmployeeDTO extends UserDTO {

    public EmployeeDTO(Employee employee) {
        setId(employee.getId());
        setName(employee.getName());
        setEmail(employee.getEmail());
        setPassword(employee.getPassword());
    }
}
