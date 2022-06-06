package com.qa.demo.ServiceTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.demo.repo.CharacterInfoRepo;
import com.qa.demo.service.CharacterInfoService;
import com.qa.demo.domain.CharacterInfo;
import com.qa.demo.domain.Job;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CharacterInfoServiceTests {
	
	@Autowired
	private CharacterInfoService service;
	
	@MockBean
	private CharacterInfoRepo repo;
	
	
	@Test
	void createTest() {
		List<Job> jobs = new ArrayList<>();
		
		CharacterInfo chara = new CharacterInfo(1L, "hyur", "twin adder", "name", "chaos", jobs);
		Job test = new Job(1L, "Bard", 90);
		jobs.add(test);
		
		Mockito.when(this.repo.save(chara)).thenReturn(chara);
		
		assertEquals(chara, this.service.characterCreate(chara));
		
		Mockito.verify(this.repo, Mockito.times(1)).save(chara);
	}
	

}
