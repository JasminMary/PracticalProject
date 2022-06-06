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
	
	@OneToMany(mappedBy = "jobs")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Job> jobs = new ArrayList<>();
	
	

}
