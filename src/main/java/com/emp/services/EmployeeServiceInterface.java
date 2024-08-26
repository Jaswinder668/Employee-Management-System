package com.emp.services;

import java.util.List;
import java.util.Optional;


import com.emp.Entity.Employee;

public interface EmployeeServiceInterface {
	
      List<Employee> employees();	
      void saveEmployee(Employee employee);
      void deleteEmployee(int id);
      Optional<Employee> findByid(int id);
      Employee updateEmployee(Employee employee);
	

}
