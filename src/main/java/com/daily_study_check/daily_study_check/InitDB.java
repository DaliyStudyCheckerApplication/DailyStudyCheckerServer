package com.daily_study_check.daily_study_check;

import java.time.LocalTime;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.daily_study_check.daily_study_check.domain.member.Discrimination;
import com.daily_study_check.daily_study_check.domain.member.Location;
import com.daily_study_check.daily_study_check.domain.member.Member;
import com.daily_study_check.daily_study_check.domain.rule.Rule;
import com.daily_study_check.daily_study_check.domain.team.Team;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitDB {
	private final InitService initService;
	@PostConstruct
	public void init() {
		initService.dbInit1();
		initService.dbInit2();
	}

	@Component
	@Transactional
	@RequiredArgsConstructor
	static class InitService {
		private final EntityManager em;
		public void dbInit1() {
			Member member1 = Member.createMember(
				"userA",
				"userA_email",
				"00000000",
				Discrimination.MEMBER,
				new Location(0, 0, "userA_location"));
			em.persist(member1);
			Member member2 = Member.createMember(
				"userB",
				"userB_email",
				"00000000",
				Discrimination.MEMBER,
				new Location(0, 0, "userB_location"));
			em.persist(member2);

			Member member3 = Member.createMember(
				"userC",
				"userC_email",
				"00000000",
				Discrimination.MEMBER,
				new Location(0, 0, "userC_location"));
			em.persist(member3);
			Rule rule1 = Rule.createRule(
				true,
				LocalTime.of(01,01),
				4,
				4000
			);
			em.persist(rule1);
			Team team1 = Team.createTeam(
				"team1",
				"0000",
				rule1,
				member1,
				member2,
				member3
			);
			em.persist(team1);
		}

		public void dbInit2() {
			Member member1 = Member.createMember(
				"userMakingTeam",
				"user_email",
				"00000000",
				Discrimination.MEMBER,
				new Location(0, 0, "user_location"));
			em.persist(member1);
		}
	}
}
