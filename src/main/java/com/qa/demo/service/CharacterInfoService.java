package com.qa.demo.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.demo.domain.CharacterInfo;
import com.qa.demo.exceptions.CharacterInfoException;
import com.qa.demo.repo.CharacterInfoRepo;

@Service
public class CharacterInfoService {
	
	private CharacterInfoRepo repo;
	
	private ModelMapper mapper;
	
	@Autowired
	public CharacterInfoService(CharacterInfoRepo repo, ModelMapper mapper) {
		this.repo = repo;
		this.mapper = mapper;
	}
	
	//create
	public CharacterInfo characterCreate(CharacterInfo character) {
		return this.repo.save(character);
	}
	
	//read
	public List<CharacterInfo> readAll() {
		return this.repo.findAll();
	}
	
    public CharacterInfo read(Long id) throws CharacterInfoException {
    	return this.repo.findById(id).orElseThrow(CharacterInfoException::new);
    }
    
    public CharacterInfo updateCharacterInfo(Long id, CharacterInfo character) throws CharacterInfoException {
    	//Optional<CharacterInfo> existingOptional = this.repo.findById(id);
    	CharacterInfo existing =  this.repo.findById(id).orElseThrow(CharacterInfoException::new);
    	
    	existing.setDatacentre(character.getDatacentre());
    	existing.setFreeCompany(character.getFreeCompany());
    	existing.setGrandCompany(character.getGrandCompany());
    	existing.setRace(character.getRace());
    	
    	return this.repo.saveAndFlush(existing);
    }
	
	
	//mapping
//	private CharacterInfoDTO mapToDTO(CharacterInfo character) {
//		return this.mapper.map(character, CharacterInfoDTO.class);
//	}
}
