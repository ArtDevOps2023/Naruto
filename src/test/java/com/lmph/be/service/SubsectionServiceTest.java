package com.lmph.be.service;

import static org.assertj.core.api.Assertions.assertThat;
 
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import com.lmph.be.dto.SubsectionInfo;

/**
 * Subsection Service Unit Test
 * @author Ryan Valmoria
 */
@SpringBootTest
@Transactional
class SubsectionServiceTest {

	@Autowired
	private SubsectionService subsectionService;
	

	
	/**
	 * @Arrangements 
	 * 	 truncate table
	 * 	 insert record
	 * @Act 
	 * 	  get the first subsection
	 * 	  call delete
	 * @Asserts
     *     assert the deleted record does not exists anymore
	 */
//	@Test
//	@Sql( scripts = { "classpath:sql/truncate.sql", "classpath:sql/insert_record.sql" })
//	public void deleteSubsection_success() {
//		
//		List<SubsectionInfo> subsectionList = this.subsectionService.getAllSubsections();
//		SubsectionInfo subsectionInfo = subsectionList.get(0);
//		
//		this.subsectionService.deleteSubsection(subsectionInfo.getSubsectionId());
//		
//		SubsectionInfo actual = this.subsectionService.getSubsectionBySubsectionId(subsectionInfo.getSubsectionId());
//		
//		assertThat(actual).isNull();
//	}

}
