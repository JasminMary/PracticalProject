package com.qa.demo.ServiceTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.demo.domain.Job;
import com.qa.demo.domain.Job;
import com.qa.demo.exceptions.JobException;
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
	
	@Test
	void readAlltest () {
		final List<Job> job = List.of(new Job(1L, "Bard", 90, null),
				new Job(2L, "reaper", 80, null));

		Mockito.when(this.repo.findAll()).thenReturn(job);

		assertThat(this.service.readAll()).isEqualTo(job);

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	@Test
	void testReadById() throws JobException {
		final Long id = 1L;
		final Job test = new Job(1L, "Bard", 90, null);
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(test));

		assertThat(this.service.read(id)).isEqualTo(test);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
	}

}
