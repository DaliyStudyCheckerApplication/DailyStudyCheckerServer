package com.daily_study_check.daily_study_check.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daily_study_check.daily_study_check.domain.member.Member;
import com.daily_study_check.daily_study_check.domain.team.Team;
import com.daily_study_check.daily_study_check.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;

	public Member getMemberInfos(Long memberId) {
		return memberRepository.findOne(memberId);
	}

}
