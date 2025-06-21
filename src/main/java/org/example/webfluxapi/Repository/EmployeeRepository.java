package org.example.webfluxapi.Repository;

import org.example.webfluxapi.Entity.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee, String> {

}
