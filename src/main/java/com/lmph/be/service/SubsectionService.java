package com.lmph.be.service;
 

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmph.be.dao.SubsectionDao;
import com.lmph.be.dto.SubsectionInfo;
import com.lmph.be.entity.Section;
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
	 * Fetch a particular subsection by subsectionId
	 * @param subsectionId
	 * @return SubsectionInfo
	 */
	public SubsectionInfo getSubsectionBySubsectionId(Long subsectionId) {		
			 		
		Optional<Subsection> optSubsection = this.subsectionDao.findById(subsectionId);
					
		if (optSubsection.isPresent()) {
			SubsectionInfo subsectionInfo = new SubsectionInfo();
			Subsection subsection = this.subsectionDao.findById(subsectionId).get();
			BeanUtils.copyProperties(subsection, subsectionInfo);
			return subsectionInfo;	
		} else {
			return null;
		}				
	}
	
	/**
	 * Fetch all subections
	 * @return List<SubsectionInfo>
	 */
	public List<SubsectionInfo> getAllSubsections() {		
		List<Subsection> subsectionList = this.subsectionDao.findAll();
					
		return subsectionList.stream().map( subsection -> {
			SubsectionInfo subsectionInfo = new SubsectionInfo();
			BeanUtils.copyProperties(subsection, subsectionInfo);
			return subsectionInfo;
		})
		.collect(Collectors.toList());
	}
	
	/**
	 * Upsert
	 * @param form
	 * @return
	 */
	public SubsectionInfo upsert(SubsectionForm form) {
		
		SubsectionInfo subsectionInfo = new SubsectionInfo();
		Subsection subsection = new Subsection();
		
		BeanUtils.copyProperties(form, subsection);
		
		Section section = new Section();
		section.setSectionId(form.getSectionId());
		subsection.setSection(section);
		
		subsection = this.subsectionDao.saveAndFlush(subsection);
		
		BeanUtils.copyProperties(subsection, subsectionInfo);
		
		return subsectionInfo;
	}
		
	/**
	 * Delete a particular subsection
	 * @param subsectionId
	 */
	public void deleteSubsection(Long subsectionId)  {
		this.subsectionDao.deleteById(subsectionId);
	}
}
