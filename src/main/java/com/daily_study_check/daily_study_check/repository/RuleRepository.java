package com.daily_study_check.daily_study_check.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

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
}
