package com.lmph.be.controller;

import com.lmph.be.utility.SecurityUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.lmph.be.form.EmployeeForm;
import com.lmph.be.form.SectionForm;
import com.lmph.be.form.SubsectionForm;

/**
 * Index Controller class
 * @author Jhun Tiballa
 */
@Controller
public class IndexController {

	
	/**
	 * Login page
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/login")
	public String login() throws Exception {
				
		if(SecurityUtil.isAuthenticated()) {
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
	
	/**
	 * Onboarding page
	 * @return
	 */
	@GetMapping("/onboarding")
	public String onboarding() {
		return "onboarding";
	}
	
	/**
	 * Display Sections and Add Section form
	 * @param sectionForm
	 * @return
	 */
	@SuppressWarnings("unused")
	@GetMapping("/onboarding/section")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String sectionForm(@ModelAttribute("sectionForm") SectionForm sectionForm) {
		return "section_form";
	}
	
	/**
	 * Edit Section form
	 * @param sectionId
	 * @param sectionForm
	 * @return
	 */
	@GetMapping("/onboarding/section/{sectionId}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String sectionForm(@PathVariable Long sectionId, @ModelAttribute("sectionForm") SectionForm sectionForm) {
		sectionForm.setSectionId(sectionId);	
		return "section_form";
	}
	
	/**
	 * Add Subsection form
	 * @param sectionId
	 * @param subsectionForm
	 * @return
	 */
	@GetMapping("/onboarding/section/{sectionId}/subsection")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String subsectionForm(@PathVariable Long sectionId, @ModelAttribute("subsectionForm") SubsectionForm subsectionForm) {
		subsectionForm.setSectionId(sectionId);		
		return "subsection_form";
	}
	
	/**
	 * Edit Subsection form
	 * @param sectionId
	 * @param subsectionId
	 * @param subsectionForm
	 * @return
	 */
	@GetMapping("/onboarding/section/{sectionId}/subsection/{subsectionId}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String subsectionForm(@PathVariable Long sectionId, @PathVariable Long subsectionId, @ModelAttribute("subsectionForm") SubsectionForm subsectionForm) {
		subsectionForm.setSectionId(sectionId);	
		subsectionForm.setSubsectionId(subsectionId);
		return "subsection_form";
	}
}
