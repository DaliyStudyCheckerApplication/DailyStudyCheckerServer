package com.daily_study_check.daily_study_check.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daily_study_check.daily_study_check.domain.check_study.CheckStudy;
import com.daily_study_check.daily_study_check.domain.member.Member;
import com.daily_study_check.daily_study_check.domain.team.Team;
import com.daily_study_check.daily_study_check.repository.CheckStudyRepository;
import com.daily_study_check.daily_study_check.repository.MemberRepository;
import com.daily_study_check.daily_study_check.repository.RuleRepository;
import com.daily_study_check.daily_study_check.repository.TeamRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
//Autowired 보다 생성자 주입을 권장
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	private final RuleRepository ruleRepository;
	private final TeamRepository teamRepository;
	private final CheckStudyRepository checkStudyRepository;

	/**
	 * 회원가입
	 * 아직 정확한 비즈니스 로직이 나오질 않았기 때문에,
	 * validation은 아직 하지 않는다. 추후 개발 예정
	 * TODO : 비즈니스 로직이 나온 이후에는 db 에 unique 제약 조건을 걸어 두자!!
	 * @param member
	 * @return
	 */
	@Transactional
	public Long join(Member member) {
		memberRepository.save(member);
		return member.getId();
	}

	/**
	 * 전체 회원 조회
	 * @return
	 */
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}

	/**
	 * 회원 한 명 조회
	 * @param memberId
	 * @return
	 */
	public Member getMemberInfos(Long memberId) {
		return memberRepository.findOne(memberId);
	}

}
