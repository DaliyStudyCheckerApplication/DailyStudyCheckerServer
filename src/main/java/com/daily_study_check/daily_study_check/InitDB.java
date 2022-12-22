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

			//10 11 12
			Member member10 = Member.createMember(
				"Oh",
				"userG_email",
				"01055936691",
				Discrimination.MEMBER,
				new Location(0, 0, "userG_location"));
			em.persist(member10);
			Member member11 = Member.createMember(
				"Lee",
				"userH_email",
				"01026287817",
				Discrimination.MEMBER,
				new Location(0, 0, "userH_location"));
			em.persist(member11);

			Member member12 = Member.createMember(
				"Ki",
				"userI_email",
				"01041260069",
				Discrimination.MEMBER,
				new Location(0, 0, "userI_location"));
			em.persist(member12);

			Rule rule1 = Rule.createRule(
				true,
				LocalTime.of(0,0),
				4,
				4000
			);
			em.persist(rule1);

			Rule rule2 = Rule.createRule(
				true,
				LocalTime.of(0,30),
				4,
				4000
			);
			em.persist(rule2);

			Rule rule3 = Rule.createRule(
				true,
				LocalTime.of(1,0),
				4,
				4000
			);
			em.persist(rule3);

			Rule rule4 = Rule.createRule(
				true,
				LocalTime.of(1,30),
				4,
				4000
			);
			em.persist(rule4);

			Rule rule5 = Rule.createRule(
				true,
				LocalTime.of(2,0),
				4,
				4000
			);
			em.persist(rule5);

			Rule rule6 = Rule.createRule(
				true,
				LocalTime.of(2,30),
				4,
				4000
			);
			em.persist(rule6);

			Rule rule7 = Rule.createRule(
				true,
				LocalTime.of(3,0),
				4,
				4000
			);
			em.persist(rule7);

			Rule rule8 = Rule.createRule(
				true,
				LocalTime.of(3,30),
				4,
				4000
			);
			em.persist(rule8);

			Rule rule9 = Rule.createRule(
				true,
				LocalTime.of(4,0),
				4,
				4000
			);
			em.persist(rule9);

			Rule rule10 = Rule.createRule(
				true,
				LocalTime.of(4,30),
				4,
				4000
			);
			em.persist(rule10);

			Rule rule11 = Rule.createRule(
				true,
				LocalTime.of(4,0),
				4,
				4000
			);
			em.persist(rule11);

			Rule rule12 = Rule.createRule(
				true,
				LocalTime.of(4,30),
				4,
				4000
			);
			em.persist(rule12);

			Rule rule13 = Rule.createRule(
				true,
				LocalTime.of(5,0),
				4,
				4000
			);
			em.persist(rule13);

			Rule rule14 = Rule.createRule(
				true,
				LocalTime.of(5,30),
				4,
				4000
			);
			em.persist(rule14);

			Rule rule15 = Rule.createRule(
				true,
				LocalTime.of(6,0),
				4,
				4000
			);
			em.persist(rule15);

			Rule rule16 = Rule.createRule(
				true,
				LocalTime.of(6,30),
				4,
				4000
			);
			em.persist(rule16);

			Rule rule17 = Rule.createRule(
				true,
				LocalTime.of(7,0),
				4,
				4000
			);
			em.persist(rule17);

			Rule rule18 = Rule.createRule(
				true,
				LocalTime.of(7,30),
				4,
				4000
			);
			em.persist(rule18);

			Rule rule19 = Rule.createRule(
				true,
				LocalTime.of(8,0),
				4,
				4000
			);
			em.persist(rule19);

			Rule rule20 = Rule.createRule(
				true,
				LocalTime.of(8,30),
				4,
				4000
			);
			em.persist(rule20);

			Rule rule21 = Rule.createRule(
				true,
				LocalTime.of(9,0),
				4,
				4000
			);
			em.persist(rule21);

			Rule rule22 = Rule.createRule(
				true,
				LocalTime.of(9,30),
				4,
				4000
			);
			em.persist(rule22);

			Rule rule23 = Rule.createRule(
				true,
				LocalTime.of(10,0),
				4,
				4000
			);
			em.persist(rule23);

			Rule rule24 = Rule.createRule(
				true,
				LocalTime.of(10,30),
				4,
				4000
			);
			em.persist(rule24);

			Rule rule25 = Rule.createRule(
				true,
				LocalTime.of(11,0),
				4,
				4000
			);
			em.persist(rule25);

			Rule rule26 = Rule.createRule(
				true,
				LocalTime.of(11,30),
				4,
				4000
			);
			em.persist(rule26);

			Rule rule27 = Rule.createRule(
				true,
				LocalTime.of(12,0),
				4,
				4000
			);
			em.persist(rule27);

			Rule rule28 = Rule.createRule(
				true,
				LocalTime.of(12,30),
				4,
				4000
			);
			em.persist(rule28);

			Rule rule29 = Rule.createRule(
				true,
				LocalTime.of(13,0),
				4,
				4000
			);
			em.persist(rule29);

			Rule rule30 = Rule.createRule(
				true,
				LocalTime.of(13,30),
				4,
				4000
			);
			em.persist(rule30);

			Rule rule31 = Rule.createRule(
				true,
				LocalTime.of(14,0),
				4,
				4000
			);
			em.persist(rule31);

			Rule rule33 = Rule.createRule(
				true,
				LocalTime.of(14,30),
				4,
				4000
			);
			em.persist(rule33);
			Rule rule34 = Rule.createRule(
				true,
				LocalTime.of(15,0),
				4,
				4000
			);
			em.persist(rule34);
			Rule rule35 = Rule.createRule(
				true,
				LocalTime.of(15,30),
				4,
				4000
			);
			em.persist(rule35);
			Rule rule36 = Rule.createRule(
				true,
				LocalTime.of(16,0),
				4,
				4000
			);
			em.persist(rule36);
			Rule rule37 = Rule.createRule(
				true,
				LocalTime.of(16,30),
				4,
				4000
			);
			em.persist(rule37);
			Rule rule38 = Rule.createRule(
				true,
				LocalTime.of(17,0),
				4,
				4000
			);
			em.persist(rule38);
			Rule rule39 = Rule.createRule(
				true,
				LocalTime.of(17,30),
				4,
				4000
			);
			em.persist(rule39);
			Rule rule40 = Rule.createRule(
				true,
				LocalTime.of(18,0),
				4,
				4000
			);
			em.persist(rule40);
			Rule rule41 = Rule.createRule(
				true,
				LocalTime.of(18,30),
				4,
				4000
			);
			em.persist(rule41);
			Rule rule42 = Rule.createRule(
				true,
				LocalTime.of(19,0),
				4,
				4000
			);
			em.persist(rule42);
			Rule rule43 = Rule.createRule(
				true,
				LocalTime.of(19,30),
				4,
				4000
			);
			em.persist(rule43);
			Rule rule44 = Rule.createRule(
				true,
				LocalTime.of(20,0),
				4,
				4000
			);
			em.persist(rule44);
			Rule rule45 = Rule.createRule(
				true,
				LocalTime.of(20,30),
				4,
				4000
			);
			em.persist(rule45);
			Rule rule46 = Rule.createRule(
				true,
				LocalTime.of(21,0),
				4,
				4000
			);
			em.persist(rule46);
			Rule rule47 = Rule.createRule(
				true,
				LocalTime.of(21,30),
				4,
				4000
			);
			em.persist(rule47);
			Rule rule48 = Rule.createRule(
				true,
				LocalTime.of(22,0),
				4,
				4000
			);
			em.persist(rule48);
			Rule rule49 = Rule.createRule(
				true,
				LocalTime.of(22,30),
				4,
				4000
			);
			em.persist(rule49);
			Rule rule50 = Rule.createRule(
				true,
				LocalTime.of(23,0),
				4,
				4000
			);
			em.persist(rule50);
			Rule rule51 = Rule.createRule(
				true,
				LocalTime.of(23,30),
				4,
				4000
			);
			em.persist(rule51);





			Team team1 = Team.createTeam(
				"team1",
				"0000",
				rule1,
				member10,
				member11,
				member12
			);
			em.persist(team1);

			Team team2 = Team.createTeam(
				"team2",
				"0000",
				rule2,
				member10,
				member11,
				member12
			);
			em.persist(team2);

			Team team3 = Team.createTeam(
				"team3",
				"0000",
				rule3,
				member10,
				member11,
				member12
			);
			em.persist(team3);

			Team team4 = Team.createTeam(
				"team4",
				"0000",
				rule4,
				member10,
				member11,
				member12
			);
			em.persist(team4);

			Team team5 = Team.createTeam(
				"team4",
				"0000",
				rule5,
				member10,
				member11,
				member12
			);
			em.persist(team5);

			Team team6 = Team.createTeam(
				"team4",
				"0000",
				rule6,
				member10,
				member11,
				member12
			);
			em.persist(team6);

			Team team7 = Team.createTeam(
				"team4",
				"0000",
				rule7,
				member10,
				member11,
				member12
			);
			em.persist(team7);

			Team team8 = Team.createTeam(
				"team4",
				"0000",
				rule8,
				member10,
				member11,
				member12
			);
			em.persist(team8);
			Team team9 = Team.createTeam(
				"team4",
				"0000",
				rule9,
				member10,
				member11,
				member12
			);
			em.persist(team9);
			Team team10 = Team.createTeam(
				"team4",
				"0000",
				rule10,
				member10,
				member11,
				member12
			);
			em.persist(team10);

			Team team11 = Team.createTeam(
				"team4",
				"0000",
				rule11,
				member10,
				member11,
				member12
			);
			em.persist(team11);

			Team team12 = Team.createTeam(
				"team4",
				"0000",
				rule12,
				member10,
				member11,
				member12
			);
			em.persist(team12);

			Team team13 = Team.createTeam(
				"team4",
				"0000",
				rule13,
				member10,
				member11,
				member12
			);
			em.persist(team13);

			Team team14 = Team.createTeam(
				"team4",
				"0000",
				rule14,
				member10,
				member11,
				member12
			);
			em.persist(team14);

			Team team15 = Team.createTeam(
				"team4",
				"0000",
				rule15,
				member10,
				member11,
				member12
			);
			em.persist(team15);

			Team team16 = Team.createTeam(
				"team4",
				"0000",
				rule16,
				member10,
				member11,
				member12
			);
			em.persist(team16);

			Team team17 = Team.createTeam(
				"team4",
				"0000",
				rule17,
				member10,
				member11,
				member12
			);
			em.persist(team17);

			Team team18 = Team.createTeam(
				"team4",
				"0000",
				rule18,
				member10,
				member11,
				member12
			);
			em.persist(team18);

			Team team19 = Team.createTeam(
				"team4",
				"0000",
				rule19,
				member10,
				member11,
				member12
			);
			em.persist(team19);

			Team team20 = Team.createTeam(
				"team4",
				"0000",
				rule20,
				member10,
				member11,
				member12
			);
			em.persist(team20);

			Team team21 = Team.createTeam(
				"team4",
				"0000",
				rule21,
				member10,
				member11,
				member12
			);
			em.persist(team21);

			Team team22 = Team.createTeam(
				"team4",
				"0000",
				rule22,
				member10,
				member11,
				member12
			);
			em.persist(team22);

			Team team23 = Team.createTeam(
				"team4",
				"0000",
				rule23,
				member10,
				member11,
				member12
			);
			em.persist(team23);

			Team team24 = Team.createTeam(
				"team4",
				"0000",
				rule24,
				member10,
				member11,
				member12
			);
			em.persist(team24);

			Team team25 = Team.createTeam(
				"team4",
				"0000",
				rule25,
				member10,
				member11,
				member12
			);
			em.persist(team25);

			Team team26 = Team.createTeam(
				"team4",
				"0000",
				rule26,
				member10,
				member11,
				member12
			);
			em.persist(team26);

			Team team27 = Team.createTeam(
				"team4",
				"0000",
				rule27,
				member10,
				member11,
				member12
			);
			em.persist(team27);

			Team team28 = Team.createTeam(
				"team4",
				"0000",
				rule28,
				member10,
				member11,
				member12
			);
			em.persist(team28);

			Team team29 = Team.createTeam(
				"team4",
				"0000",
				rule29,
				member10,
				member11,
				member12
			);
			em.persist(team29);

			Team team30 = Team.createTeam(
				"team4",
				"0000",
				rule30,
				member10,
				member11,
				member12
			);
			em.persist(team30);

			Team team31= Team.createTeam(
				"team4",
				"0000",
				rule31,
				member10,
				member11,
				member12
			);
			em.persist(team31);

			// Team team32 = Team.createTeam(
			// 	"team4",
			// 	"0000",
			// 	rule32,
			// 	member10,
			// 	member11,
			// 	member12
			// );
			// em.persist(team32);

			Team team33 = Team.createTeam(
				"team4",
				"0000",
				rule33,
				member10,
				member11,
				member12
			);
			em.persist(team33);

			Team team34 = Team.createTeam(
				"team4",
				"0000",
				rule34,
				member10,
				member11,
				member12
			);
			em.persist(team34);

			Team team35 = Team.createTeam(
				"team4",
				"0000",
				rule35,
				member10,
				member11,
				member12
			);
			em.persist(team35);

			Team team36 = Team.createTeam(
				"team4",
				"0000",
				rule36,
				member10,
				member11,
				member12
			);
			em.persist(team36);

			Team team37 = Team.createTeam(
				"team4",
				"0000",
				rule37,
				member10,
				member11,
				member12
			);
			em.persist(team37);

			Team team38 = Team.createTeam(
				"team4",
				"0000",
				rule38,
				member10,
				member11,
				member12
			);
			em.persist(team38);

			Team team39 = Team.createTeam(
				"team4",
				"0000",
				rule39,
				member10,
				member11,
				member12
			);
			em.persist(team39);

			Team team40 = Team.createTeam(
				"team4",
				"0000",
				rule40,
				member10,
				member11,
				member12
			);
			em.persist(team40);
			Team team41 = Team.createTeam(
				"team4",
				"0000",
				rule41,
				member10,
				member11,
				member12
			);
			em.persist(team41);

			Team team42 = Team.createTeam(
				"team4",
				"0000",
				rule42,
				member10,
				member11,
				member12
			);
			em.persist(team42);

			Team team43 = Team.createTeam(
				"team4",
				"0000",
				rule43,
				member10,
				member11,
				member12
			);
			em.persist(team43);

			Team team44 = Team.createTeam(
				"team4",
				"0000",
				rule44,
				member10,
				member11,
				member12
			);
			em.persist(team44);

			Team team45 = Team.createTeam(
				"team4",
				"0000",
				rule45,
				member10,
				member11,
				member12
			);
			em.persist(team45);

			Team team46 = Team.createTeam(
				"team4",
				"0000",
				rule46,
				member10,
				member11,
				member12
			);
			em.persist(team46);

			Team team47 = Team.createTeam(
				"team4",
				"0000",
				rule47,
				member10,
				member11,
				member12
			);
			em.persist(team47);


			Team team48 = Team.createTeam(
				"team4",
				"0000",
				rule48,
				member10,
				member11,
				member12
			);
			em.persist(team48);

			Team team49 = Team.createTeam(
				"team4",
				"0000",
				rule49,
				member10,
				member11,
				member12
			);
			em.persist(team49);

			Team team50 = Team.createTeam(
				"team4",
				"0000",
				rule50,
				member10,
				member11,
				member12
			);
			em.persist(team50);

			Team team51 = Team.createTeam(
				"team4",
				"0000",
				rule51,
				member10,
				member11,
				member12
			);
			em.persist(team51);

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
