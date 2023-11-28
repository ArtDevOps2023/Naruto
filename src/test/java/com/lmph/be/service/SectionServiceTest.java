package com.lmph.be.service;

import static org.assertj.core.api.Assertions.assertThat;
 
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import com.lmph.be.dto.EmployeeInfo;
import com.lmph.be.dto.SectionInfo;
 

/**
 * Section Service Unit Test
 * @author Ryan Valmoria
 */
@SpringBootTest
@Transactional
class SectionServiceTest {

	@Autowired
	private SectionService sectionService;
	
	/**
	 * @Arrangements 
	 * 	truncate table
	 * 	use 1L as sectionId
	 * @Act 
	 * 	  get a single section
	 * @Asserts
     *     Should return null
	 */
//	@Test
//	@Sql("classpath:sql/truncate.sql")
//	public void getSectionBySectionId_returnsNull() {
//		
//		SectionInfo actual = this.sectionService.getSectionBySectionId(1L);		
//		assertThat(actual).isNull();
//		
//	}
	
	/**
	 * @Arrangements 
	 * 	 truncate table
	 * 	 use 1L as sectionId
	 * @Act 
	 * 	  get single section
	 * 	  call getSectionBySectionId
	 * @Asserts
     *     Should return instance of SectionInfo
	 */
//	@Test
//	@Sql( scripts = {"classpath:sql/truncate.sql", "classpath:sql/insert_record.sql"})
//	public void getSectionBySectionId_returnsSectionInfo() {
//		
//		SectionInfo actual = this.sectionService.getSectionBySectionId(1L);		
//		assertThat(actual).isInstanceOf(SectionInfo.class);
//	}
	
	
	
	/**
	 * @Arrangements 
	 * 	 truncate table
	 * 	 insert record
	 * @Act 
	 * 	  get the first section
	 * 	  call delete
	 * @Asserts
     *     assert the deleted record does not exists anymore
	 */
//	@Test
//	@Sql( scripts = { "classpath:sql/truncate.sql", "classpath:sql/insert_record.sql" })
//	public void deleteSection_success() {
//		
//		List<SectionInfo> sectionList = this.sectionService.getAllSections();
//		SectionInfo sectionInfo = sectionList.get(0);
//		
//		this.sectionService.deleteSection(sectionInfo.getSectionId());
//		
//		SectionInfo actual = this.sectionService.getSectionBySectionId(sectionInfo.getSectionId());
//		
//		assertThat(actual).isNull();
//	}

}
