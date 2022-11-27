package com.daily_study_check.daily_study_check.repository;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.daily_study_check.daily_study_check.domain.member.Member;
import com.daily_study_check.daily_study_check.domain.rule.Rule;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RuleRepository {
	private final EntityManager em;

	public Long save(Rule rule) {
		em.persist(rule);
		return rule.getId();
	}

	public Rule findOne(Long id) {
		return em.find(Rule.class, id);
	}

	public List<Rule> findAll() {
		return em.createQuery(
			"select r"
				+ " from Rule r",
			Rule.class
		).getResultList();
	}

	public List<Member> findByTime(String localDateTime) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime localTime = LocalTime.parse(localDateTime, dateTimeFormatter);
		return em.createQuery(
			"select m"
				+ " from Rule r"
				+ " join Team t"
				+ " on r.id = t.rule.id"
				+ " and r.startTime =:dTime"
				+ " join Member m"
				+ " on m.team.id = t.id"
				,
			Member.class
		)
			.setParameter("dTime", localTime)
			.getResultList();
	}

	// public Rule findRuleByMember(Member member) {
	// 	return em.createQuery(
	// 		"select r"
	// 			+ " from Rule r"
	// 			+ " join fetch Member m"
	// 			+ " join fetch Team t "
	// 			+ "on m.team.id= t.id "
	// 			+ "  "
	// 	)
	//
	// }
}
