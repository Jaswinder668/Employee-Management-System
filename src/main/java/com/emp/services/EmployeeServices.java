package com.emp.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.emp.Entity.Employee;
import com.emp.repository.EmployeeRepository;

@Service
public class EmployeeServices  implements EmployeeServiceInterface{
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> employees() {
		// TODO Auto-generated method stub
		List<Employee> employees=employeeRepository.findAll();
		return employees;
	}

	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		 employeeRepository.save(employee);
		 
	}

	
	

	@Override
	public Optional<Employee> findByid(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> employee=employeeRepository.findById(id);
		return  employee;
	}

	 @Override
	    public Employee updateEmployee(Employee employee) {
		
	        return employeeRepository.save(employee);
	    }

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
		
	}

}
