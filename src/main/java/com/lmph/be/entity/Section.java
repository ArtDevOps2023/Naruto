package com.lmph.be.entity;

import java.time.LocalDateTime;

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
 * Section Entity
 * @author Ryan Valmoria
 */
@Data
@Entity
@Table(name = "section")
public class Section {

	/**
	 * primary key : section_id
	 */
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long section_id;
			
	/**
	 * name
	 */
	private String name;
	
	/**
	 * color
	 * 
	 * blue - means the section has to be customized / reviewed per team
	 * green - means the section is generic, common for all roles and can be used by all teams
	 * yellow - means the section is managed or co-managed by the practice lead
	 */
	private String color;
	
	/**
	 * created_by
	 */
	private String created_by;
	
	/**
	 * created_date
	 */
	private LocalDateTime created_date;
	 
}
