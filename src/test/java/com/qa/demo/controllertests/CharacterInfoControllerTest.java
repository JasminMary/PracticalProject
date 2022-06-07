package com.qa.demo.controllertests;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.demo.domain.CharacterInfo;
import com.qa.demo.domain.Job;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc // sets up the MockMVC object
@Sql(scripts = { "classpath:test-schema.sql",
"classpath:test-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class CharacterInfoControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired 
	ObjectMapper mapper; 
	
	@Test
	void testCreate() throws Exception {
		//List<Job> jobs = new ArrayList<>();
		final CharacterInfo CharacterInfo = new CharacterInfo(1L, "hyur", "twin adder", "name", "chaos", null);
		String testCharacterInfoAsJson = this.mapper.writeValueAsString(CharacterInfo);
		
		final CharacterInfo savedCharacterInfo = new CharacterInfo(1L, "hyur", "twin adder", "name", "chaos", null);
		String savedCharacterInfoAsJson = this.mapper.writeValueAsString(savedCharacterInfo); 
		
		RequestBuilder request = post("/character/create").contentType(MediaType.APPLICATION_JSON).content(testCharacterInfoAsJson);
		
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkContent = content().json(savedCharacterInfoAsJson);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent); 
	}
	
	@Test
	void testReadAll() throws Exception {
		List<Job> jobs = new ArrayList<>();
		Job test = new Job(1L, "Bard", 90, null);
		jobs.add(test);
		final CharacterInfo character = new CharacterInfo(1L, "hyur", "twin adder", "guild", "chaos", jobs);
		String testCharacterInfoAsJson = this.mapper.writeValueAsString(List.of(character));
		
		RequestBuilder requestGet = get("/character/readAll"); 
	
		ResultMatcher checkStatusGet = status().isOk();
		ResultMatcher checkContentGet = content().json(testCharacterInfoAsJson);
		
		this.mvc.perform(requestGet).andExpect(checkStatusGet).andExpect(checkContentGet); 
	}
	
	@Test
	void testReadById() throws Exception {
		List<Job> jobs = new ArrayList<>();
		Job test = new Job(1L, "Bard", 90, null);
		jobs.add(test);
		final CharacterInfo character = new CharacterInfo(1L, "hyur", "twin adder", "guild", "chaos", jobs);
		String savedCharacterInfoAsJSON = this.mapper.writeValueAsString(character);

		RequestBuilder request = get("/character/read/1");

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkContent = content().json(savedCharacterInfoAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent);
	}
	
	@Test
	void testUpdate() throws Exception {
		List<Job> jobs = new ArrayList<>();
		Job test = new Job(1L, "Bard", 90, null);
		jobs.add(test);
		final CharacterInfo updatedChar = new CharacterInfo(1L, "Elezen", "twin adder", "name", "chaos", jobs);
		String updatedCharAsJson = this.mapper.writeValueAsString(updatedChar);
		
		RequestBuilder requestput = put("/character/update/1").contentType(MediaType.APPLICATION_JSON).content(updatedCharAsJson);
		
		ResultMatcher checkStatusPut = status().isAccepted();
		ResultMatcher checkContentPut = content().json(updatedCharAsJson);
		
		this.mvc.perform(requestput).andExpect(checkStatusPut).andExpect(checkContentPut); 
	}
	
	@Test
	void testDelete() throws Exception {
		this.mvc.perform(delete("/character/delete/1")).andExpect(status().isNoContent());
	}

}
