package com.qa.demo.controllertests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.demo.domain.Job;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc // sets up the MockMVC object
@Sql(scripts = { "classpath:test-schema.sql",
"classpath:test-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class JobControllerTests {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired 
	ObjectMapper mapper; 
	
	@Test
	void testCreate() throws Exception {
		final Job Job = new Job(1L, "Bard", 90, null);
		String testJobAsJson = this.mapper.writeValueAsString(Job);
		
		final Job savedJob = new Job(1L, "Bard", 90, null);
		String savedJobAsJson = this.mapper.writeValueAsString(savedJob); 
		
		RequestBuilder request = post("/job/create").contentType(MediaType.APPLICATION_JSON).content(testJobAsJson);
		
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkContent = content().json(savedJobAsJson);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent); 
	}

}
