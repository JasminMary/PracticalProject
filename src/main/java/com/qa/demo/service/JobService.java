package com.qa.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.demo.domain.Job;
import com.qa.demo.exceptions.JobException;
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
	
    public Job read(Long id) throws JobException {
    	return this.repo.findById(id).orElseThrow(JobException::new);
    }
    
    public Job updateJob(Long id, Job job) throws JobException {
    	Job existing = this.repo.findById(id).orElseThrow(JobException :: new);
    	
    	existing.setJobLevel(job.getJobLevel());
    	existing.setJobName(job.getJobName());
    	existing.setCharacter(job.getCharacter());
    	
    	return this.repo.saveAndFlush(existing);	
    }

}
