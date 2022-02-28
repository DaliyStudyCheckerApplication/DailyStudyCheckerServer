package com.daily_study_check.daily_study_check.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.daily_study_check.daily_study_check.domain.member.Member;
import com.daily_study_check.daily_study_check.domain.team.Team;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class TeamRepository {
	private final EntityManager em;

	public Long save(Team team) {
		em.persist(team);
		return team.getId();
	}

	public Team findOne(Long id) {
		return em.find(Team.class, id);
	}

	public List<Team> findAll() {
		return em.createQuery(
			"select t"
				+ " from Team t",
			Team.class
		)
			.getResultList();
	}

	public List<Team> findByTeamName(String teamName) {
		return em.createQuery(
			"select t"
				+ " from Team t"
				+ " where t.teamName=:teamName",
			Team.class
		)
			.setParameter("teamName", teamName)
			.getResultList();
	}

	public Team findByMemberId(Long memberId) {
		return em.createQuery(
			"select t"
				+ " from Team t"
				+ " join fetch Member m"
				+ " where m.team.id =:memberId",
			Team.class
		)
			.setParameter("memberId", memberId)
			.getSingleResult();
	}

	public Team findByInvitingCode(String invitingCode) {
		return em.createQuery(
			"select t"
				+ " from Team t"
				+ " where t.invitingCode =:invitingCode",
			Team.class
		)
			.setParameter("invitingCode", invitingCode)
			.getSingleResult();
	}

	public boolean validateDuplicationOfInvitingCode(String invitingCode) {
		Team validate = em.createQuery(
				"select count(t.invitingCode)"
					+ " from Team t"
					+ " where t.invitingCode =:invitingCode"
				, Team.class
			)
			.setParameter("invitingCode", invitingCode)
			.getSingleResult();
		if (validate == null) return true;
		return false;
	}

	// public List<Member> findAllMembers() {
	// 	return em.createQuery(
	// 		"select m"
	// 			+ " from Member m "
	// 			+ " join fetch Team t"
	// 			+ " "
	// 	)
	// }
}
