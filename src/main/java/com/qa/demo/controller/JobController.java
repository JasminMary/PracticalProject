package com.qa.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.demo.domain.Job;
import com.qa.demo.exceptions.JobException;
import com.qa.demo.service.JobService;

@CrossOrigin
@RequestMapping("/job")
@RestController
public class JobController {
	
	private JobService service;
	
	@Autowired
	public JobController(JobService service) {
		this.service = service;
	}
	
	//create 201
	@PostMapping("/create")
	public ResponseEntity<Job> create(@RequestBody Job job) {
		return new ResponseEntity<>(this.service.jobCreate(job), HttpStatus.CREATED);
	}
	//read 200
	@GetMapping("/readAll")
	public ResponseEntity<List<Job>> readAll() {
		return new ResponseEntity<>(this.service.readAll(), HttpStatus.OK);
	}
	//read by id 200
	@GetMapping("/read/{id}")
	public ResponseEntity<Job> read(@PathVariable Long id) throws JobException {
		return new ResponseEntity<>(this.service.read(id), HttpStatus.OK);
	}
	
	//update 202
	@PutMapping("/update/{id}")
	public ResponseEntity<Job> update(@PathVariable Long id, @RequestBody Job job) throws JobException {
		return new ResponseEntity<>(this.service.updateJob(id, job), HttpStatus.ACCEPTED);
	}
	//delete 204
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
		return this.service.deleteJob(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
