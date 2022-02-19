package com.daily_study_check.daily_study_check.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daily_study_check.daily_study_check.controller.DTO.request.CheckStudyTodayRequestDTO;
import com.daily_study_check.daily_study_check.controller.DTO.response.ResponseDTO;
import com.daily_study_check.daily_study_check.domain.check_study.CheckStudy;
import com.daily_study_check.daily_study_check.domain.member.Member;
import com.daily_study_check.daily_study_check.repository.MemberRepository;
import com.daily_study_check.daily_study_check.service.CheckStudyService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CheckStudyApiController {
	private final CheckStudyService checkStudyService;
	private final MemberRepository memberRepository;

	@PostMapping("/api/v1/check_study")
	@ResponseBody
	public ResponseDTO successCheckStudyToday (
		@RequestBody CheckStudyTodayRequestDTO checkStudyTodayRequestDTO
	) {
		Member member = memberRepository.findOne(checkStudyTodayRequestDTO.getMemberId());
		CheckStudy checkStudy = new CheckStudy();
		// checkStudy.successCheckStudy();
		// member.setCheckStudy();
		return null;
	}
}
