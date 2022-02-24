// package com.daily_study_check.daily_study_check.service;
//
// import static org.junit.Assert.*;
//
// import java.time.LocalTime;
//
// import org.junit.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.context.junit.jupiter.SpringExtension;
// import org.springframework.test.context.junit4.SpringRunner;
// import org.springframework.transaction.annotation.Transactional;
//
// import com.daily_study_check.daily_study_check.domain.member.Discrimination;
// import com.daily_study_check.daily_study_check.domain.member.Location;
// import com.daily_study_check.daily_study_check.domain.member.Member;
// import com.daily_study_check.daily_study_check.domain.rule.Rule;
// import com.daily_study_check.daily_study_check.domain.team.Team;
// import com.daily_study_check.daily_study_check.repository.MemberRepository;
// import com.daily_study_check.daily_study_check.repository.TeamRepository;
//
// @ExtendWith(SpringExtension.class)
// @SpringBootTest
// @Transactional
// public class TeamServiceTestWithoutMock {
// 	@Autowired
// 	MemberService memberService;
// 	@Autowired
// 	MemberRepository memberRepository;
//
// 	@Autowired
// 	TeamRepository teamRepository;
//
// 	@Autowired
// 	TeamService teamService;
//
// 	@Test
// 	public void team_test() throws Exception {
// 		//given
// 		Member testMember = Member.createMember(
// 			"test name",
// 			"test email",
// 			"test phone number",
// 			Discrimination.MEMBER,
// 			new Location(0.0, 0.0, "test location")
// 		);
//
// 		Member testMember2 = Member.createMember(
// 			"test name2",
// 			"test email2",
// 			"test phone number2",
// 			Discrimination.MEMBER,
// 			new Location(0.0, 0.0, "test location2")
// 		);
//
//
// 		Rule testRule = Rule.createRule(
// 			true,
// 			LocalTime.of(9, 0, 0),
// 			5,
// 			3000
// 		);
//
// 		Team testTeam = Team.createTeam(
// 			"test team",
// 			"123456",
// 			testRule
// 		);
//
// 		testTeam.addMember(testMember);
// 		testTeam.addMember(testMember2);
//
// 		//Long id = teamService.join(testTeam);
//
// 		Long join = memberService.join(testMember);
//
// 		System.out.println("id : " + join);
//
// 		assertEquals(join, join);
// 	}
//
// }
