package com.daily_study_check.daily_study_check.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.daily_study_check.daily_study_check.domain.member.Member;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
	private final EntityManager em;

	public Long save(Member member) {
		em.persist(member);
		return member.getId();
	}

	public Member findOne(Long id) {
		return em.find(Member.class, id);
	}

	public List<Member> findAll() {
		return em.createQuery(
			"select m from Member m",
			Member.class
		).getResultList();
	}

	public List<Member> findByMemberName(String memberName) {
		return em.createQuery(
			"select m "
				+ " from Member m"
				+ " where m.memberName=:memberName",
				Member.class
		)
			.setParameter("memberName", memberName)
			.getResultList();
	}

	public Member findByEmail(String email) {
		return em.createQuery(
			"select distinct m"
				+ " from Member m"
				+ " where m.email=:email",
			Member.class
		)
			.setParameter("email", email)
			.getSingleResult();
	}
}
