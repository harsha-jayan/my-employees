package com.sample.myemployees.service;

import com.sample.myemployees.controller.EmployeeController;
import com.sample.myemployees.controller.dto.EmployeeDto;
import com.sample.myemployees.entities.Address;
import com.sample.myemployees.entities.Employee;
import com.sample.myemployees.repositories.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

  private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

  private EmployeeRepository employeeRepository;

  @Autowired
  EmployeeService(EmployeeRepository employeeRepository){this.employeeRepository = employeeRepository;}

  private void create(EmployeeDto employeeDto) throws Exception {
    Employee employee = new Employee();
    employee.setAge(employeeDto.getAge());
    employee.setEmployeeId(employeeDto.getEmployeeId());
    employee.setEmployeeName(employeeDto.getEmployeeName());
    employee.setRole(employeeDto.getRole());
    Address address = new Address();
    address.setAddressLine1(employeeDto.getAddressDto().getAddressLine1());
    address.setAddressLine2(employeeDto.getAddressDto().getAddressLine2());
    address.setCountry(employeeDto.getAddressDto().getCountry());
    address.setZipCode(employeeDto.getAddressDto().getZipCode());
    employee.setAddress(address);
    try {
      employeeRepository.save(employee);
    }catch (Exception ex){
      logger.error("exception while inserting new employee");
      throw new Exception("exception while inserting new employee");
    }
  }
}
