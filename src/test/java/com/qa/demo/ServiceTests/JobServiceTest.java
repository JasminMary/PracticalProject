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
import com.qa.demo.exceptions.JobException;
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
	
	@Test
	void testUpdateJob() throws JobException { 
		final Long id = 1L;

		Job oldJob = new Job(id, "Bard", 90, null);
		Job newJob = new Job(id, "Sage", 90, null);

		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(oldJob));
		Mockito.when(this.repo.save(newJob)).thenReturn(newJob);

		assertThat(this.service.updateJob(oldJob.getId(), newJob).equals(newJob));

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(newJob);
	}
	
	@Test
	void testDelete() {
		final Long id = 1L;

		Mockito.when(this.repo.existsById(id)).thenReturn(false);

		assertThat(this.service.deleteJob(id)).isTrue();

		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
	}


}
