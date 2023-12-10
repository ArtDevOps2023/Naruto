package com.lmph.be.controller;

import java.util.List;

import com.lmph.be.dto.EmployeeFlowInfo;
import com.lmph.be.entity.EmployeeFlow;
import com.lmph.be.form.EmployeeFlowForm;
import com.lmph.be.service.EmployeeFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;


import com.lmph.be.dto.EmployeeInfo;
import com.lmph.be.form.EmployeeForm;
import com.lmph.be.service.EmployeeService;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;

/**
 * User Controller class
 * @author Jhun Tiballa
 */
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeFlowService employeeFlowService;
	
	/**
	 * GraphQL controller for fetching single employee
	 * @param id
	 * @return
	 */
	@QueryMapping
	public EmployeeInfo employeeById(@Argument Long id) {
		return this.employeeService.getEmployee( id );			
	}
		
	/**
	 * GraphQL for fetching all employees
	 * @return
	 */
	@QueryMapping
	public List<EmployeeInfo> employees() {
		return this.employeeService.getEmployees();
	}
	
	@MutationMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public EmployeeInfo upsertEmployee(@Valid @Argument EmployeeForm form) throws ConstraintViolationException {
		return this.employeeService.upsert(form);	
	}
	
	@MutationMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Boolean deleteEmployee(@Argument Long id) {
		
		this.employeeService.delete(id);
		
		return true;
	}

	//TODO JJJ: create javadoc
	@QueryMapping
	public List<EmployeeFlow> employeeFlowsById(@Argument Long id){
		return this.employeeFlowService.getEmployeeFlowsByEmployeeId(id);
	}

	@MutationMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public EmployeeFlowInfo upsertEmployeeFlow(@Valid @Argument EmployeeFlowForm form){
		try{
			if(form != null)
				return this.employeeFlowService.upsertEmployeeFlow(form);
			else
				throw new Exception("Employee Flow is null.");
		}
		catch(Exception ex){
			return null;
		}
	}


	@MutationMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Boolean deleteEmployeeFlow(@Valid @Argument Long employeeFlowId){
		try {
			if(employeeFlowId != null)
				this.employeeFlowService.deleteEmployeeFlow(employeeFlowId);
			else
				throw new Exception("Employee Flow ID is null.");

			return true;
		} catch (Exception ex) {
			return false;
		}
	}
}
