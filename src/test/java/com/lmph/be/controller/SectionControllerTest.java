
package com.lmph.be.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
 
import com.lmph.be.service.SectionService;

/**
 * 
 */
class SectionControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
//	@Test
//	@WithMockUser(username = "user", roles = {"USER"})
//	public void upsertSection_hasUserRoleStatusForbidden() throws Exception {
//						
//		RequestBuilder request = MockMvcRequestBuilders.post("/onboarding/section/post");
//		mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().is(405));
//	}
//	
//	
//	@Test
//	@WithMockUser(username = "user", roles = {"USER"})
//	public void deleteSection_hasUserRoleStatusForbidden() throws Exception {
//		
//		RequestBuilder request = MockMvcRequestBuilders.delete("/onboarding/section/1");
//		mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().is(405));
//	}
	
}
