package com.lmph.be.form;

import java.io.Serializable;
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
public class SectionForm implements Serializable {
 
	private static final long serialVersionUID = 1L;

	private Long sectionId;

	@NotEmpty( message = "Section Name is required." )
	@Size( max = 100, message = "Section Name must be less than or equal to 100 characters")
	private String name;
	
	@NotBlank( message = "Section Color is required.")
	private String color;
	
	private SectionColor sectionColors = SectionColor.B;
	
}
