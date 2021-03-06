package com.qa.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.demo.domain.CharacterInfo;

@Repository
public interface CharacterInfoRepo extends JpaRepository<CharacterInfo, Long> {
	

}
