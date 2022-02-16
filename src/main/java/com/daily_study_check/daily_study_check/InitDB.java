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
			Rule rule1 = Rule.createRule(
				true,
				LocalTime.now(),
				4,
				4000
			);
			em.persist(rule1);
			Team team1 = Team.createTeam(
				"team1",
				"0000",
				rule1,
				member1
			);
			em.persist(team1);
		}
	}
}
