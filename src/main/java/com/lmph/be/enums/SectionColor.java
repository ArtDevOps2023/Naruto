package com.lmph.be.enums;

/**
 * Section Color Enums
 * @author Ryan Valmoria
 */
public enum SectionColor {
	
	/*
	 * Blue - means the section has to be customized / reviewed per team
	 * Green - means the section is generic, common for all roles and can be used by all teams
	 * Yellow - means the section is managed or co-managed by the practice lead
	 * 
	 */
	B("Blue"), 
	G("Green"),
	Y("Yellow");
	
	private String color;
	
	SectionColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return this.color;
	}
	
	
}
