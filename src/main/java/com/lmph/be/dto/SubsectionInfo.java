package com.lmph.be.dto;
 

import com.lmph.be.entity.Section;

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
	private Long subsectionId;
	
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
	private String targetDay;
	
	/**
	 * target_sprint
	 */
	private String targetSprint;
	
	/**
	 * sort_order
	 */
	private int sortOrder;
	
	/**
	 * section_id foreign key
	 */
	private Section section;
}
