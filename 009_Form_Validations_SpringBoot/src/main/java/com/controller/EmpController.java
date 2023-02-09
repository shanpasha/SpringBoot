package com.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dao.EmployeeRepo;
import com.model.Employee;

@Controller
public class EmpController {
	
	@Autowired
    EmployeeRepo repo;
	

	@GetMapping("/saveEmp")
	public String addEmp(Model m){
		m.addAttribute("emps",new Employee());
	
		return "AddEmp";
	}
	
	
	@PostMapping("/saveEmp")
	public String saveEmp( @Valid @ModelAttribute("emps")Employee employee,BindingResult result) {
		
		System.out.println("Employee:"+employee);
		System.out.println(result.hasErrors());
		if(result.hasErrors()) {
			return "AddEmp";
		}else {
			repo.save(employee);
			return "redirect:/getEmps";
		}
	
	

}
	
	@GetMapping("/getEmps")
	public ModelAndView getAllEmp() {
		return new ModelAndView("AllEmployees", "getEmps", repo.findAll());
		
		
	}
}
