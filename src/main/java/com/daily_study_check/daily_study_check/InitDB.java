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

			//456
			Member member4 = Member.createMember(
				"userD",
				"userD_email",
				"00000000",
				Discrimination.MEMBER,
				new Location(0, 0, "userD_location"));
			em.persist(member4);
			Member member5 = Member.createMember(
				"userE",
				"userE_email",
				"00000000",
				Discrimination.MEMBER,
				new Location(0, 0, "userE_location"));
			em.persist(member5);

			Member member6 = Member.createMember(
				"userF",
				"userF_email",
				"00000000",
				Discrimination.MEMBER,
				new Location(0, 0, "userF_location"));
			em.persist(member6);

			//789
			Member member7 = Member.createMember(
				"userG",
				"userG_email",
				"00000000",
				Discrimination.MEMBER,
				new Location(0, 0, "userG_location"));
			em.persist(member7);
			Member member8 = Member.createMember(
				"userH",
				"userH_email",
				"00000000",
				Discrimination.MEMBER,
				new Location(0, 0, "userH_location"));
			em.persist(member8);

			Member member9 = Member.createMember(
				"userI",
				"userI_email",
				"00000000",
				Discrimination.MEMBER,
				new Location(0, 0, "userI_location"));
			em.persist(member9);


			Rule rule1 = Rule.createRule(
				true,
				LocalTime.of(9,00),
				4,
				4000
			);
			em.persist(rule1);

			Rule rule2 = Rule.createRule(
				true,
				LocalTime.of(8,30),
				4,
				4000
			);
			em.persist(rule2);

			Rule rule3 = Rule.createRule(
				true,
				LocalTime.of(10,30),
				4,
				4000
			);
			em.persist(rule3);
			Team team1 = Team.createTeam(
				"team1",
				"0000",
				rule1,
				member1,
				member2,
				member3
			);
			em.persist(team1);

			Team team2 = Team.createTeam(
				"team2",
				"0000",
				rule2,
				member4,
				member5,
				member6
			);
			em.persist(team2);

			Team team3 = Team.createTeam(
				"team3",
				"0000",
				rule3,
				member7,
				member8,
				member9
			);
			em.persist(team3);
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
