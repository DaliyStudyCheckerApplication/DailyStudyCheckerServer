package com.daily_study_check.daily_study_check.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daily_study_check.daily_study_check.domain.check_study.CheckStudy;
import com.daily_study_check.daily_study_check.domain.member.Member;
import com.daily_study_check.daily_study_check.repository.CheckStudyRepository;
import com.daily_study_check.daily_study_check.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CheckStudyService {
	private final CheckStudyRepository checkStudyRepository;
	private final MemberRepository memberRepository;

	@Transactional
	public Long successCheckStudy(Long memberId, LocalDateTime localDateTime) {
		CheckStudy checkStudy = new CheckStudy();
		checkStudy.successCheckStudy();
		checkStudy.setDateTime(localDateTime);

		Member member = memberRepository.findOne(memberId);
		member.addCheckStudy(checkStudy);
		checkStudyRepository.save(checkStudy);
		memberRepository.save(member);
		return checkStudy.getId();
	}

	@Transactional
	public Long failCheckStudy(Long memberId, LocalDateTime localDateTime) {
		CheckStudy checkStudy = new CheckStudy();
		checkStudy.failCheckStudy();
		checkStudy.setDateTime(localDateTime);

		Member member = memberRepository.findOne(memberId);
		member.addCheckStudy(checkStudy);
		checkStudyRepository.save(checkStudy);
		memberRepository.save(member);
		return checkStudy.getId();
	}
}
