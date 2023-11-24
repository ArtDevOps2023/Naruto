package com.lmph.be.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Subsection Entity
 * @author Ryan Valmoria
 */
@Data
@Entity
@Table(name = "subsection")
public class Subsection {

	/**
	 * primary key : subsection_id
	 */
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long subsection_id;
			
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
	
	/**
	 * sort_order
	 */
	private int sort_order;
	
	/**
	 * Section
	 */
//	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="section_id")
//	private Section section;
}
