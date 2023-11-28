package com.lmph.be.dto;
 
 
import java.util.ArrayList;
import java.util.List;

import com.lmph.be.entity.Subsection;

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
	private Long sectionId;
		
	/**
	 * Name
	 */
	private String name;
	
	/**
	 * Color
	 */
	private String color;
	
	/**
	 * Color description
	 */
	private String colorDescription;

	/**
	 * Subsections per Section
	 */
	private List<Subsection> subsectionList = new ArrayList<>();
	 
}
