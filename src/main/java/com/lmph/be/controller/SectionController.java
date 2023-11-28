package com.lmph.be.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import com.lmph.be.dto.EmployeeInfo;
import com.lmph.be.dto.SectionInfo;
import com.lmph.be.form.SectionForm;
import com.lmph.be.service.SectionService;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;

/**
 * Section Controller class
 * @author Ryan Valmoria
 */
@Controller
public class SectionController {

	@Autowired
	private SectionService sectionService;
	 
	/**
	 * GraphQL controller for fetching a particular section by sectionId
	 * @param id
	 * @return
	 */
	@QueryMapping
	public SectionInfo sectionBySectionId(@Argument Long sectionId) {
		return this.sectionService.getSectionBySectionId(sectionId);			
	}
		
	/**
	 * GraphQL for fetching all sections
	 * @return
	 */
	@QueryMapping
	public List<SectionInfo> section() {
		return this.sectionService.getAllSections();
	}
	
	@MutationMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public SectionInfo upsertSection(@Valid @Argument SectionForm form) throws ConstraintViolationException {
		return this.sectionService.upsert(form);	
	}
	
	@MutationMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Boolean deleteSection(@Argument Long sectionId) {
		this.sectionService.deleteSection(sectionId);
		return true;
	}
}
