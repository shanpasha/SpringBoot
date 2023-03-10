package com.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.Role;
import com.model.UserInfo;
import com.service.Roles;
import com.service.UserService;

@Controller
//@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService serv;
	@Autowired
	Roles rolerepo;
	

	@GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("errorMsg", "Your username and password are invalid.");

        if (logout != null)
            model.addAttribute("msg", "You have been logged out successfully.");

        return "login";
    }
	
	
	
	@GetMapping("/home")
	public String Home() {
		return "UserHome";
	}
	
	@GetMapping("admin/home")
	public String AdminHome() {
		return "Home";
	}
	
	@GetMapping("/addUser")
	public String addUser(Model model) {
		model.addAttribute("role",rolerepo.getAllRoles());
		System.out.println(rolerepo.getAllRoles());
		return "AddUser";
		
	}
	
	@PostMapping("/saveUser")
	public String saveUser(UserInfo user) {
		List<Role> roles=new ArrayList<Role>();
		for (Role role : user.getRoles()) {
			
		roles.add(rolerepo.getByRoleID(role.getRoleId()));
			
		}
		user.setRoles(roles);
		
		
	System.out.println(user);
		serv.addUser(user);
		return "redirect:/";
		
	}
	
	@GetMapping("/getAllUsers")
	public ModelAndView getAllUsers(Model model) {
		System.out.println(serv.getAllUsers());
		
		model.addAttribute("getroles", rolerepo.getAllRoles());
		return new ModelAndView("getUsers", "users", serv.getAllUsers());
		
		
		
	}
	

}
