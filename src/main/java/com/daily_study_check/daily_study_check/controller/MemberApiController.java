package com.daily_study_check.daily_study_check.controller;

import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daily_study_check.daily_study_check.domain.member.Member;
import com.daily_study_check.daily_study_check.service.MemberService;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberApiController {
	private final MemberService memberService;

	//TODO: make using dto
	@GetMapping(value = "/api/v1/user_info")
	public MemberInfoDTO getMemberInfo(@RequestParam(value = "user_email") String userEmail) {
		return null;
	}

	@Data
	private static class MemberInfoDTO {
		private String userName;
		private RuleInfoDTO rule;
		private TeamInfoDTO team;

		public MemberInfoDTO(Member member) {

		}
	}

	@Data
	private static class RuleInfoDTO {
		private LocalTime startTime;
		private int goalTime;
		private int amountPerPenalty;
	}

	@Data
	private static class TeamInfoDTO {
		private Long teamId;
		private String teamName;
	}

	// @Data
	// private static class CheckStudyInfoDTO {
	// 	private
	// }
}
