package com.qa.demo.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
//@Data 
public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String jobName;
	
	private int jobLevel;
	
	@ManyToOne(targetEntity = CharacterInfo.class)
	private CharacterInfo character;

	public Job(Long id, String jobName, int jobLevel, CharacterInfo character) {
		super();
		Id = id;
		this.jobName = jobName;
		this.jobLevel = jobLevel;
		this.character = character;
	}
	
	public Job() {
		 
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public int getJobLevel() {
		return jobLevel;
	}

	public void setJobLevel(int jobLevel) {
		this.jobLevel = jobLevel;
	}

	public CharacterInfo getCharacter() {
		return character;
	}

	public void setCharacter(CharacterInfo character) {
		this.character = character;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, character, jobLevel, jobName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Job other = (Job) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(character, other.character) && jobLevel == other.jobLevel
				&& Objects.equals(jobName, other.jobName);
	}
	


}
