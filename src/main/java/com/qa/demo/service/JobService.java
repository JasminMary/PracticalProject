package com.qa.demo.service;

import org.springframework.stereotype.Service;

import com.qa.demo.domain.Job;
import com.qa.demo.repo.JobRepo;

@Service
public class JobService {
	
	private JobRepo repo;
	
	public JobService(JobRepo repo) {
		this.repo =repo;
		
	}
	public Job jobCreate(Job job) {
		return this.repo.save(job);
	}

}
