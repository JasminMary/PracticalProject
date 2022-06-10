package com.qa.demo.ServiceTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.demo.repo.CharacterInfoRepo;
import com.qa.demo.service.CharacterInfoService;
import com.qa.demo.domain.CharacterInfo;
import com.qa.demo.domain.Job;
import com.qa.demo.exceptions.CharacterInfoException;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class CharacterInfoServiceTests {
	
	@Autowired
	private CharacterInfoService service;
	
	@MockBean
	private CharacterInfoRepo repo;
	
	
	@Test
	void createTest() {
		List<Job> jobs = new ArrayList<>();
		
		CharacterInfo chara = new CharacterInfo(1L,"name" , "hyur", "twin adder", "name", "chaos", jobs);
		Job test = new Job(1L, "Bard", 90, null);
		jobs.add(test);
		
		Mockito.when(this.repo.save(chara)).thenReturn(chara);
		
		assertEquals(chara, this.service.characterCreate(chara));
		
		Mockito.verify(this.repo, Mockito.times(1)).save(chara);
	}
	
	@Test
	void readAlltest () {
		final List<CharacterInfo> characterInfo = List.of(new CharacterInfo(1L, "name", "hyur", "Twin adder", "guild", "light", null),
				new CharacterInfo(2L, "name", "Elezen", "twin adder", "another", "chaos", null));

		Mockito.when(this.repo.findAll()).thenReturn(characterInfo);

		assertThat(this.service.readAll()).isEqualTo(characterInfo);

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	@Test
	void testReadById() throws CharacterInfoException {
		final Long id = 1L;
		final CharacterInfo character = new CharacterInfo(1L, "name", "hyur", "Twin adder", "guild", "light", null);
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(character));

		assertThat(this.service.read(id)).isEqualTo(character);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
	}
	
	@Test
	void testUpdateCharacterInfo() throws CharacterInfoException { 
		final Long id = 1L;

		CharacterInfo oldChar = new CharacterInfo(id, "name", "hyur", "Twin adder", "guild", "light", null);
		CharacterInfo newChar = new CharacterInfo(id, "name", "Elezen", "Twin adder", "guild", "light", null);

		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(oldChar));
		Mockito.when(this.repo.save(newChar)).thenReturn(newChar);

		
		assertThat(this.service.updateCharacterInfo(oldChar.getId(), newChar)).isEqualTo(newChar);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(newChar);

		
	}
	
	@Test
	void testDelete() {
		final Long id = 1L;

		Mockito.when(this.repo.existsById(id)).thenReturn(false);

		assertThat(this.service.deleteCharacterInfo(id)).isTrue();

		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
	}

}
