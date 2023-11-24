package com.lmph.be.service;
 

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmph.be.dao.SubsectionDao;
import com.lmph.be.dto.SubsectionInfo;
import com.lmph.be.entity.Subsection;
import com.lmph.be.form.SubsectionForm;


/**
 * Subsection Service class
 * @author Ryan Valmoria
 */
@Service
public class SubsectionService {

	@Autowired
	private SubsectionDao subsectionDao;
	 
	/**
	 * Upsert
	 * @param form
	 * @return
	 */
	public SubsectionInfo upsert(SubsectionForm form) {
		
		SubsectionInfo subsectionInfo = new SubsectionInfo();
		Subsection subsection = new Subsection();
		
		BeanUtils.copyProperties(form, subsection);
		  
		
		subsection = this.subsectionDao.saveAndFlush(subsection);
		
		BeanUtils.copyProperties(subsection, subsectionInfo);
		
		return subsectionInfo;
	}
		
	/**
	 * Delete
	 * @param id
	 */
	public void delete(Long id)  {
		this.subsectionDao.deleteById(id);
	}
}
