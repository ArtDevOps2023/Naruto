package com.lmph.be.dto;
 

import lombok.Data;

/**
 * Subsection Info DTO
 * @author Ryan Valmoria
 */
@Data
public class SubsectionInfo  {
	
	/**
	 * Primary key
	 */
	private Long subsection_id;
	
	/**
	 * Foreign key
	 */
	private Long section_id;
	
	/**
	 * description
	 */
	private String description;
	
	/**
	 * facilitator
	 */
	private String facilitator;
	
	/**
	 * details
	 */
	private String details;
	
	/**
	 * target_day
	 */
	private String target_day;
	
	/**
	 * target_sprint
	 */
	private String target_sprint;
	 
}
