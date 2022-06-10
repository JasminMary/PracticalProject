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
	//read by id
    public Job read(Long id) throws JobException {
    	return this.repo.findById(id).orElseThrow(JobException::new);
    }
    //update
    public Job updateJob(Long id, Job job) throws JobException {
    	Job existing = this.repo.findById(id).orElseThrow(JobException :: new);
    	
    	existing.setJobLevel(job.getJobLevel());
    	existing.setJobName(job.getJobName());
    	existing.setCharacter(job.getCharacter());
    	
    	this.repo.saveAndFlush(existing);
    	return existing;	
    }
    
    //delete
    public boolean deleteJob(Long id) {
        this.repo.deleteById(id);
        boolean exists = this.repo.existsById(id);
        return !exists;
    }

}
