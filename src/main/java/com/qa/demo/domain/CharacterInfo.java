package com.qa.demo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "character_information")
public class CharacterInfo {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String race;
	
	private String grandCompany;
	
	private String freeCompany;
	
	private String datacentre;
	
	@OneToMany(mappedBy = "Id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Job> jobs = new ArrayList<>();

	//constructor for testing
	public CharacterInfo(Long id, String race, String grandCompany, String freeCompany, String datacentre,
			List<Job> jobs) {
		super();
		this.id = id;
		this.race = race;
		this.grandCompany = grandCompany;
		this.freeCompany = freeCompany;
		this.datacentre = datacentre;
		this.jobs = jobs;
	}



}
