package com.daily_study_check.daily_study_check.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daily_study_check.daily_study_check.controller.DTO.member.MemberDTO;
import com.daily_study_check.daily_study_check.controller.DTO.member.MemberQueryDTO;
import com.daily_study_check.daily_study_check.controller.DTO.memberInfo.MemberInfoDTO;
import com.daily_study_check.daily_study_check.domain.member.Member;
import com.daily_study_check.daily_study_check.repository.MemberRepository;
import com.daily_study_check.daily_study_check.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberApiController {
	private final MemberService memberService;
	private final MemberRepository memberRepository;

	@GetMapping(value = "/api/v1/members")
	@ResponseBody
	public MemberQueryDTO members(@RequestParam(value = "id") Long memberId) {
		Member member = memberRepository.findOne(memberId);
		MemberQueryDTO memberQueryDTO = new MemberQueryDTO();
		return memberQueryDTO.createMemberQueryDTO(member);
	}


	//TODO: make using dto
	@GetMapping(value = "/api/v1/member_info")
	@ResponseBody
	public MemberInfoDTO memberInfos(@RequestParam(value = "member_email") String userEmail) {
		Member byEmail = memberRepository.findByEmail(userEmail);
		MemberInfoDTO memberInfoDTO = new MemberInfoDTO();
		return memberInfoDTO.createMemberInfoDTO(byEmail);
	}
}
