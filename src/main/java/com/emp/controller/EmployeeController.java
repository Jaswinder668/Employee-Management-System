package com.emp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.emp.Entity.Employee;
import com.emp.services.EmployeeNotFoundException;
import com.emp.services.EmployeeServices;
import com.fasterxml.jackson.annotation.JacksonInject.Value;

import org.springframework.web.bind.annotation.PutMapping;


@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeServices employeeServices;
	
	
	@GetMapping("/index")
	public String indexPage(Model model){
		List<Employee> employees=  employeeServices.employees();
		model.addAttribute("employees", employees);	
		return "index";
	}
	
	@GetMapping("/addContactPage")
	public String addContactPage(Model model){	
		return "addContact";
	}
	@PostMapping("/saveEmployee")
	public String addEmployee(@ModelAttribute Employee employee)
	{
		employeeServices.saveEmployee(employee);
		return "redirect:/index";
	}
	
	  @GetMapping("/employee/updateForm/{id}")
	    public String showUpdateForm(@PathVariable("id") int id, Model model) {
	        // Retrieve the employee by ID from the database
	         Optional<Employee> employee=  employeeServices.findByid(id);
	        model.addAttribute("employee", employee);
	        return "updateEmployee";
	    }
	
	@PostMapping("/updateEmployee")
	public String saveEmployee(@ModelAttribute Employee employee){
		employeeServices.saveEmployee(employee);
		return "redirect:/index";
	}

	
	@GetMapping("/delete/{id}")
	public String deleteEmployeeByid(@PathVariable int id){
		employeeServices.deleteEmployee(id);
		return "redirect:/index";
	}
	

}
