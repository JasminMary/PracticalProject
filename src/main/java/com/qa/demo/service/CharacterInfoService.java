package com.qa.demo.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.qa.demo.domain.CharacterInfo;
import com.qa.demo.dto.CharacterInfoDTO;
import com.qa.demo.repo.CharacterInfoRepo;

@Service
public class CharacterInfoService {
	
	private CharacterInfoRepo repo;
	
	//private ModelMapper mapper;
	
	public CharacterInfoService(CharacterInfoRepo repo, ModelMapper mapper) {
		this.repo = repo;
		//this.mapper = mapper;
	}
	
	//create
	public CharacterInfo characterCreate(CharacterInfo character) {
		return this.repo.save(character);
	}
	
	
	//mapping
//	private CharacterInfoDTO mapToDTO(CharacterInfo character) {
//		return this.mapper.map(character, CharacterInfoDTO.class);
//	}
}
