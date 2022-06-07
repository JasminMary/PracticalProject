package com.qa.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.demo.domain.CharacterInfo;
import com.qa.demo.exceptions.CharacterInfoException;
import com.qa.demo.repo.CharacterInfoRepo;

@Service
public class CharacterInfoService {
	
	private CharacterInfoRepo repo;
	
	
	@Autowired
	public CharacterInfoService(CharacterInfoRepo repo) {
		this.repo = repo;
	}
	
	//create
	public CharacterInfo characterCreate(CharacterInfo character) {
		return this.repo.save(character);
	}
	
	//read
	public List<CharacterInfo> readAll() {
		return this.repo.findAll();
	}
	//read by id
    public CharacterInfo read(Long id) throws CharacterInfoException {
    	return this.repo.findById(id).orElseThrow(CharacterInfoException::new);
    }
    
    //update
    public CharacterInfo updateCharacterInfo(Long id, CharacterInfo character) throws CharacterInfoException {
    	CharacterInfo existing =  this.repo.findById(id).orElseThrow(CharacterInfoException::new);
    	
    	existing.setDatacentre(character.getDatacentre());
    	existing.setFreeCompany(character.getFreeCompany());
    	existing.setGrandCompany(character.getGrandCompany());
    	existing.setRace(character.getRace());
    	existing.setName(character.getName());
    	
    	this.repo.saveAndFlush(existing);
    	return existing;
    }
    
    //delete
    public boolean deleteCharacterInfo(Long id) {
        this.repo.deleteById(id);
        boolean exists = this.repo.existsById(id);
        return !exists;
    }
    
	
	
}
