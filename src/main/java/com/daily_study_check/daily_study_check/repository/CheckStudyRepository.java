package com.daily_study_check.daily_study_check.repository;

import java.util.List;

import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import com.daily_study_check.daily_study_check.domain.check_study.CheckStudy;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CheckStudyRepository {
	private final EntityManager em;

	public Long save(CheckStudy checkStudy) {
		em.persist(checkStudy);
		return checkStudy.getId();
	}

	public CheckStudy findOne(Long id) {
		return em.find(CheckStudy.class, id);
	}

	public List<CheckStudy> findAll() {
		return em.createQuery(
			"select cs"
				+ " from CheckStudy cs",
			CheckStudy.class
		)
			.getResultList();
	}
}
