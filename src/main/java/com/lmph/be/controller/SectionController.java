package com.lmph.be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

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
	 
	
	@MutationMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public SectionInfo upsertSection(@Valid @Argument SectionForm form) throws ConstraintViolationException {
		return this.sectionService.upsert(form);	
	}
	
	@MutationMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Boolean deleteSection(@Argument Long section_id) {
		this.sectionService.delete(section_id);
		return true;
	}
}
