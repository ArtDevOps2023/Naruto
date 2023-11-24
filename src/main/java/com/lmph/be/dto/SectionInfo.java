package com.lmph.be.dto;
 

import lombok.Data;

/**
 * Section Info DTO
 * @author Ryan Valmoria
 */
@Data
public class SectionInfo  {
	
	/**
	 * Primary key
	 */
	private Long section_id;
		
	/**
	 * Name
	 */
	private String name;
	
	/**
	 * Color
	 */
	private String color;
	 
}
