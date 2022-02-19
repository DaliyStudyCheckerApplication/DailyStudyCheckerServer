package com.daily_study_check.daily_study_check.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.daily_study_check.daily_study_check.domain.team.Team;

class TeamRepositoryTest {

	@Autowired
	private TeamRepository teamRepository;

	@BeforeEach
	void setUp() {
	}

	@ExtendWith(SpringExtension.class)
	@Test
	void save() {
		Team team = new Team();
	}

	@Test
	void findOne() {
	}

	@Test
	void findAll() {
	}

	@Test
	void findByTeamName() {
	}

	@Test
	void findByMemberId() {
	}
}