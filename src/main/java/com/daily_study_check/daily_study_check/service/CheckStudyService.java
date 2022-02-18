package com.daily_study_check.daily_study_check.service;

import java.time.LocalDate;

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
	public Long successCheckStudy(Long memberId, LocalDate localDate) {
		CheckStudy checkStudy = new CheckStudy();
		checkStudy.successCheckStudy();
		checkStudy.setDate(localDate);

		Member member = memberRepository.findOne(memberId);
		member.setCheckStudy(checkStudy);
		checkStudyRepository.save(checkStudy);

		return checkStudy.getId();
	}

	@Transactional
	public Long failCheckStudy(Long memberId, LocalDate localDate) {
		CheckStudy checkStudy = new CheckStudy();
		checkStudy.failCheckStudy();
		checkStudy.setDate(localDate);

		Member member = memberRepository.findOne(memberId);
		member.setCheckStudy(checkStudy);
		checkStudyRepository.save(checkStudy);

		return checkStudy.getId();
	}
}
