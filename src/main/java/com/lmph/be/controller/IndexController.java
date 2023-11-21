package com.lmph.be.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.lmph.be.form.EmployeeForm;

/**
 * Index Controller class
 * @author Jhun Tiballa
 */
@Controller
public class IndexController {

	private boolean isAuthenticated() {
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    if (authentication == null || AnonymousAuthenticationToken.class.
	      isAssignableFrom(authentication.getClass())) {
	        return false;
	    }
	    return authentication.isAuthenticated();
	}
	
	/**
	 * Login page
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/login")
	public String login() throws Exception {
				
		if(this.isAuthenticated()) {
			return "redirect:/home";
		}
		
		return "login";
	}
	
	/**
	 * Home page
	 * @return
	 */
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	/**
	 * Employees list page
	 * @return
	 */
	@GetMapping("/employees")
	public String index() {
		return "employees";
	}
	
	/**
	 * Add employee form
	 * @param form
	 * @return
	 */
	@SuppressWarnings("unused")
	@GetMapping("/employees/add")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String form(@ModelAttribute("form") EmployeeForm form) {
		return "employee_form";
	}
	
	/**
	 * Employee View/Edit form
	 * @param id
	 * @param form
	 * @return
	 */
	@GetMapping("/employees/{id}")
	public String form(@PathVariable Long id, @ModelAttribute("form") EmployeeForm form) {
		form.setId(id);		
		return "employee_form";
	}
}
