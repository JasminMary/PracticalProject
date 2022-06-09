package com.qa.demo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "character_information")
public class CharacterInfo {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String race;
	
	private String grandCompany;
	
	private String freeCompany;
	
	private String datacentre;
	
	@JsonIgnore
	@OneToMany(mappedBy = "character")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Job> jobs = new ArrayList<>();

	public CharacterInfo(Long id, String name, String race, String grandCompany, String freeCompany, String datacentre,
			List<Job> jobs) {
		super();
		this.id = id;
		this.name = name;
		this.race = race;
		this.grandCompany = grandCompany;
		this.freeCompany = freeCompany;
		this.datacentre = datacentre;
		this.jobs = jobs;
	}
	
	public CharacterInfo() {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "CharacterInfo [id=" + id + ", name=" + name + ", race=" + race + ", grandCompany=" + grandCompany
				+ ", freeCompany=" + freeCompany + ", datacentre=" + datacentre + ", jobs=" + jobs + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(datacentre, freeCompany, grandCompany, id, jobs, name, race);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CharacterInfo other = (CharacterInfo) obj;
		return Objects.equals(datacentre, other.datacentre) && Objects.equals(freeCompany, other.freeCompany)
				&& Objects.equals(grandCompany, other.grandCompany) && Objects.equals(id, other.id)
				&& Objects.equals(jobs, other.jobs) && Objects.equals(name, other.name)
				&& Objects.equals(race, other.race);
	}


	
	
	



}
