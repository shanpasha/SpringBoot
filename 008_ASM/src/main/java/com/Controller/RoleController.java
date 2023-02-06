package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.Role;
import com.service.RoleServiceImpl;
@Controller
public class RoleController {
	
	@Autowired
	RoleServiceImpl serv;
	
	@GetMapping("/addRole")
	public String addRole() {
		return "Addrole";
	}
	@PostMapping("/saveRole")
	public String saveRole(Role role) {
		
		serv.save(role);
		return "redirect:/getAllroles";
	}
	
	@GetMapping("/getAllroles")
	public ModelAndView getRoles() {
		return new ModelAndView("getRoles", "roles", serv.getAllRoles());
	}
	
	
	@GetMapping("/update")
	public String updateRole(@RequestParam("id") Integer id,Model model) {
		Role rol=serv.getByRoleID(id);
		model.addAttribute("role", rol);
		return "UpdateRole";
		
	}
	
	@PostMapping("/update")
	public String update (Role role) {
		serv.save(role);
		return  "redirect:/getAllroles";
	}
	
	
	@GetMapping("/delete")
	public String deleteRole(@RequestParam("id") Integer id) {
		serv.delete(id);
		return "redirect:/getAllroles";
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
