package org.example.webfluxapi.Mapper;

import org.example.webfluxapi.Dto.EmployeeDto;
import org.example.webfluxapi.Entity.Employee;

public class EmployeeMapper {
    // Map
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}

