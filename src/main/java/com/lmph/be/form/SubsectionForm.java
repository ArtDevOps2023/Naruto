package com.lmph.be.form;

import java.io.Serializable;
import com.lmph.be.enums.MaritalStatus;
import com.lmph.be.enums.SectionColor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Section Form class
 * @author Ryan Valmoria
 */
@Data
public class SubsectionForm implements Serializable {
 
	private static final long serialVersionUID = 1L;

	private Long subsection_id;
	
	private Long section_id;
	
	@NotEmpty( message = "Subsection Name is required." )
	@Size( max = 100, message = "Subsection Name must be less than or equal to 100 characters.")
	private String description;
	
	private String facilitator;
	
	private String details;
	
	private String target_day;
	
	private String target_sprint;
	
}
