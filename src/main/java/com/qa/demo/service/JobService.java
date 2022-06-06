package com.qa.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.demo.domain.Job;
import com.qa.demo.repo.JobRepo;

@Service
public class JobService {
	
	private JobRepo repo;
	
	public JobService(JobRepo repo) {
		this.repo =repo;
		
	}
	//create
	public Job jobCreate(Job job) {
		return this.repo.save(job);
	}
	//read
	public List<Job> readAll() {
		return this.repo.findAll();
	}

}
