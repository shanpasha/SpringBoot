package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Service.EmployeeService;
import com.model.Employee;

@Controller
public class EmpContrloller {
	@Autowired
	EmployeeService service;
	
	@GetMapping("/hii")
	public String welcome() {
		return "welcome";
		
		
	}
	
	
	@GetMapping("/getAll")
	public ModelAndView findAll() {
	
	
		return new ModelAndView("FindAllEmp", "empls", service.findAll()) ;     
	}
	
	@GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
		service.deleteById(id);
		return "redirect:/getAll";
		
		
	}
	
	
	@PostMapping("/updateEmp")
    public String Update(Employee employee) {
		service.update(employee);
		return "redirect:/getAll";
		
	}
	
	@GetMapping("/update")
	public String getByid(@RequestParam("id") Integer id ,Model model) {
		
		Employee em=service.findById(id);
		model.addAttribute("employee", em);
		
		return "updateEmployee";
		
		
	}
	
	@GetMapping("/saveEmp")
	public String saveEmp() {
		return"SaveEmp";
		
	}
	
	@PostMapping("/save")
	public String save(Employee employee) {
		try {
			Employee emp=service.findById(employee.getId());
			if(emp==null) {
			service.save(employee);
			}
		} catch (Exception e) {
			service.save(employee);
		}
		
		
		
		return "redirect:/getAll";
		
	}
	
	
}
