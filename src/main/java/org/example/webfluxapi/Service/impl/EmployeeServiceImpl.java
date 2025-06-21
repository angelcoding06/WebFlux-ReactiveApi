package org.example.webfluxapi.Service.impl;

import org.example.webfluxapi.Dto.EmployeeDto;
import org.example.webfluxapi.Entity.Employee;
import org.example.webfluxapi.Mapper.EmployeeMapper;
import org.example.webfluxapi.Repository.EmployeeRepository;
import org.example.webfluxapi.Service.EmployeeService;
import org.example.webfluxapi.WebFluxApiApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger log = LoggerFactory.getLogger(WebFluxApiApplication.class);

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto) {
        log.info("EmployeeDto: {}", employeeDto.toString());
        log.info("saveEmployee: EmployeeDto: {}", employeeDto.getEmail());
        // convert EmployeeDTO into Employee Entity
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        log.info("saveEmployee: EmployeeMapper: {}", employee.getEmail());
        Mono<Employee> savedEmployee = employeeRepository.save(employee);
        log.info("Employee saved: {}", employee.getEmail());
        return savedEmployee
                .map((employeeEntity) -> EmployeeMapper.mapToEmployeeDto(employeeEntity));
    }

    @Override
    public Mono<EmployeeDto> getEmployee(String employeeId) {
        Mono<Employee> savedEmployee = employeeRepository.findById(employeeId);
        return savedEmployee
                .map((employee) -> EmployeeMapper.mapToEmployeeDto(employee));
    }

    @Override
    public Flux<EmployeeDto> getAllEmployees() {

        Flux<Employee> employeeFlux = employeeRepository.findAll();

        return employeeFlux
                .map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<EmployeeDto> updateEmployee(EmployeeDto employeeDto, String employeeId) {

        Mono<Employee> employeeMono = employeeRepository.findById(employeeId);

        Mono<Employee> updatedEmployee = employeeMono.flatMap((existingEmployee) -> {
            existingEmployee.setFirstName(employeeDto.getFirstName());
            existingEmployee.setLastName(employeeDto.getLastName());
            existingEmployee.setEmail(employeeDto.getEmail());

            return employeeRepository.save(existingEmployee);
        });
        return updatedEmployee
                .map((employee) -> EmployeeMapper.mapToEmployeeDto(employee));
    }

    @Override
    public Mono<Void> deleteEmployee(String employeeId) {
        return employeeRepository.deleteById(employeeId);
    }
}
