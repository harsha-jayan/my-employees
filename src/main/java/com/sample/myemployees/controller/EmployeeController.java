package com.sample.myemployees.controller;

import com.sample.myemployees.controller.dto.EmployeeDto;
import com.sample.myemployees.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/employees")
public class EmployeeController {

  private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

  EmployeeService employeeService;

  @Autowired
  EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @RequestMapping("/create")
  public String createEmployee(@RequestBody EmployeeDto employee){

    try {

      return "successfully inserted record";

    } catch (Exception ex) {
      logger.debug("Some error occurred while creating new employee", ex);
      return "Exception while creating new employee";
    }

  }
}
