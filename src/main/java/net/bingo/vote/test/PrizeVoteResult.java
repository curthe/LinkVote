package net.bingo.vote.test;


import java.util.Enumeration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationConetxt*.xml","classpath:springmvc.xml"})
@WebAppConfiguration
public class PrizeVoteResult {

	MockMvc mockMvc;
	@Autowired
	WebApplicationContext webApplicationContext;
	
	@Test
	public void testReturnPrizeVoteResult() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/prizeController/prizeVoteResult").param("key", "01"))
                .andReturn();
		MockHttpServletRequest request = mvcResult.getRequest();
		Enumeration<String> names = request.getAttributeNames();
		
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			System.out.println(name);
		}
		
		
	}

}
