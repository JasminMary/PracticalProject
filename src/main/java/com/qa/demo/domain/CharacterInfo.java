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
	
	public CharacterInfo() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getGrandCompany() {
		return grandCompany;
	}
	public void setGrandCompany(String grandCompany) {
		this.grandCompany = grandCompany;
	}
	public String getFreeCompany() {
		return freeCompany;
	}
	public void setFreeCompany(String freeCompany) {
		this.freeCompany = freeCompany;
	}
	public String getDatacentre() {
		return datacentre;
	}
	public void setDatacentre(String datacentre) {
		this.datacentre = datacentre;
	}
	public List<Job> getJobs() {
		return jobs;
	}
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	@Override
	public String toString() {
		return "CharacterInfo [id=" + id + ", race=" + race + ", grandCompany=" + grandCompany + ", freeCompany="
				+ freeCompany + ", datacentre=" + datacentre + ", jobs=" + jobs + "]";
	}
	
	
	



}
