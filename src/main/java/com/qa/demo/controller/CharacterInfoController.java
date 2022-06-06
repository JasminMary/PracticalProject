package com.qa.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.demo.domain.CharacterInfo;
import com.qa.demo.dto.CharacterInfoDTO;
import com.qa.demo.service.CharacterInfoService;

@RequestMapping("/character")
@RestController
public class CharacterInfoController {

	private CharacterInfoService service;
	
	@Autowired
	public CharacterInfoController(CharacterInfoService service) {
		this.service = service;
	}
	//create 201
	@PostMapping("/create")
	public ResponseEntity<CharacterInfo> create(@RequestBody CharacterInfo character) {
		return new ResponseEntity<CharacterInfo>(this.service.characterCreate(character), HttpStatus.CREATED);
	}
}
