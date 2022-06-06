package com.qa.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.demo.domain.Job;
import com.qa.demo.exceptions.JobException;
import com.qa.demo.service.JobService;

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
		return new ResponseEntity<Job>(this.service.jobCreate(job), HttpStatus.CREATED);
	}
	//read 200
	@GetMapping("/readAll")
	public ResponseEntity<List<Job>> readAll() {
		return new ResponseEntity<List<Job>>(this.service.readAll(), HttpStatus.OK);
	}
	
	@GetMapping("/read/{id}")
	public ResponseEntity<Job> read(@PathVariable Long id) throws JobException {
		return new ResponseEntity<Job>(this.service.read(id), HttpStatus.OK);
	}
}
