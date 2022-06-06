package com.qa.demo.ServiceTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.demo.domain.Job;
import com.qa.demo.repo.JobRepo;
import com.qa.demo.service.JobService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class JobServiceTest {
	
	@Autowired
	private JobService service;
	
	@MockBean
	private JobRepo repo;
	
	@Test
	void createTest() {
		
		Job test = new Job(1L, "Bard", 90, null);
		
		Mockito.when(this.repo.save(test)).thenReturn(test);
		
		assertEquals(test, this.service.jobCreate(test));
		
		Mockito.verify(this.repo, Mockito.times(1)).save(test);
		
	}

}
