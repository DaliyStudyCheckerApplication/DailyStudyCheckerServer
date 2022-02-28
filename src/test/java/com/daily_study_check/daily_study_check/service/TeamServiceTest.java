package com.daily_study_check.daily_study_check.service;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import com.daily_study_check.daily_study_check.domain.member.Discrimination;
import com.daily_study_check.daily_study_check.domain.member.Location;
import com.daily_study_check.daily_study_check.domain.member.Member;
import com.daily_study_check.daily_study_check.domain.rule.Rule;
import com.daily_study_check.daily_study_check.domain.team.Team;
import com.daily_study_check.daily_study_check.repository.MemberRepository;
import com.daily_study_check.daily_study_check.repository.TeamRepository;

@ExtendWith(MockitoExtension.class)
class TeamServiceTest {
	@InjectMocks
	private TeamService teamService;

	@Mock
	private TeamRepository teamRepository;

	@Mock
	private MemberRepository memberRepository;

	@Test
	public void findTeam_test() throws Exception {
		//given
		Member testMember = Member.createMember(
			"test name",
			"test email",
			"test phone number",
			Discrimination.MEMBER,
			new Location(0.0, 0.0, "test location")
		);

		Member testMember2 = Member.createMember(
			"test name2",
			"test email2",
			"test phone number2",
			Discrimination.MEMBER,
			new Location(0.0, 0.0, "test location2")
		);


		Rule testRule = Rule.createRule(
			true,
			LocalTime.of(9, 0, 0),
			5,
			3000
		);

		Team testTeam = Team.createTeam(
			"test team",
			"123456",
			testRule
		);

		testTeam.addMember(testMember);
		testTeam.addMember(testMember2);

		Long fakeTeamId = 3l;
		ReflectionTestUtils
			.setField(
				testTeam,
				"id",
				fakeTeamId
			);
		Long fakeMemberId = 4l;
		ReflectionTestUtils
			.setField(
				testMember,
				"id",
				fakeMemberId
			);

		given(
			teamRepository.findOne(any())
		)
			.willReturn(testTeam);

		//when
		Team findTeam = teamService.find(fakeTeamId);
		System.out.println("id : " + findTeam.getId());

		//then
		assertEquals(
			findTeam.getId(), fakeTeamId
		);
	}

}