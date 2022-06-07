package com.qa.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.demo.domain.CharacterInfo;
import com.qa.demo.exceptions.CharacterInfoException;
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
	
	//read 200
	@GetMapping("/readAll")
	public ResponseEntity<List<CharacterInfo>> readAll() {
		return new ResponseEntity<List<CharacterInfo>>(this.service.readAll(), HttpStatus.OK);	
	}
	
	@GetMapping("/read/{id}")
	public ResponseEntity<CharacterInfo> read(@PathVariable Long id) throws CharacterInfoException {
		return new ResponseEntity<CharacterInfo>(this.service.read(id), HttpStatus.OK);
	}
	
	//update 202
	@PutMapping("/update/{id}")
	public ResponseEntity<CharacterInfo> update(@PathVariable Long id, @RequestBody CharacterInfo character) throws CharacterInfoException {
		return new ResponseEntity<CharacterInfo>(this.service.updateCharacterInfo(id, character), HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
		return this.service.deleteCharacterInfo(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
