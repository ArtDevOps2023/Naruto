package com.lmph.be.service;
 

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmph.be.dao.SectionDao;
import com.lmph.be.dto.SectionInfo;
import com.lmph.be.entity.Section;
import com.lmph.be.form.SectionForm;


/**
 * Section Service class
 * @author Ryan Valmoria
 */
@Service
public class SectionService {

	@Autowired
	private SectionDao sectionDao;
	 
	/**
	 * Upsert
	 * @param form
	 * @return
	 */
	public SectionInfo upsert(SectionForm form) {
		
		SectionInfo sectionInfo = new SectionInfo();
		Section section = new Section();
		
		BeanUtils.copyProperties(form, section);
		  
		
		section = this.sectionDao.saveAndFlush(section);
		
		BeanUtils.copyProperties(section, sectionInfo);
		
		return sectionInfo;
	}
		
	/**
	 * Delete
	 * @param id
	 */
	public void delete(Long id)  {
		this.sectionDao.deleteById(id);
	}
}
