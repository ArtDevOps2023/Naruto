package com.lmph.be.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import com.lmph.be.dto.SectionInfo;
import com.lmph.be.dto.SubsectionInfo;
import com.lmph.be.form.SubsectionForm;
import com.lmph.be.service.SubsectionService;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;

/**
 * Subsection Controller class
 * @author Ryan Valmoria
 */
@Controller
public class SubsectionController {

	@Autowired
	private SubsectionService subsectionService;
	 
	
	/**
	 * GraphQL for fetching all subsections
	 * @return
	 */
	@QueryMapping
	public List<SubsectionInfo> subsection() {
		return this.subsectionService.getAllSubsections();
	}
	
	@MutationMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public SubsectionInfo upsertSubsection(@Valid @Argument SubsectionForm form) throws ConstraintViolationException {
		return this.subsectionService.upsert(form);	
	}
	
	@MutationMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Boolean deleteSubsection(@Argument Long subsectionId) {
		this.subsectionService.deleteSubsection(subsectionId);
		return true;
	}
}
