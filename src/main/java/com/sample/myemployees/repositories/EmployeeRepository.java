package com.sample.myemployees.repositories;

import com.sample.myemployees.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {}
