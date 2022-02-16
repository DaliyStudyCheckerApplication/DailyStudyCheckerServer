package com.daily_study_check.daily_study_check.controller;

import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daily_study_check.daily_study_check.domain.member.Member;
import com.daily_study_check.daily_study_check.domain.rule.Rule;
import com.daily_study_check.daily_study_check.domain.team.Team;
import com.daily_study_check.daily_study_check.repository.MemberRepository;
import com.daily_study_check.daily_study_check.service.MemberService;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberApiController {
	private final MemberService memberService;
	private final MemberRepository memberRepository;


	//TODO: make using dto
	@GetMapping(value = "/api/v1/user_info")
	@ResponseBody
	public MemberInfoDTO getMemberInfo(@RequestParam(value = "user_email") String userEmail) {
		Member byEmail = memberRepository.findByEmail(userEmail);
		MemberInfoDTO memberInfoDTO = new MemberInfoDTO();
		return memberInfoDTO.createMemberInfoDTO(byEmail);
	}

	@Data
	private static class MemberInfoDTO {
		private String memberName;
		private RuleInfoDTO rule;
		private TeamInfoDTO team;

		public MemberInfoDTO createMemberInfoDTO(Member member) {
			MemberInfoDTO memberInfoDTO = new MemberInfoDTO();
			RuleInfoDTO ruleInfoDTO = new RuleInfoDTO();
			TeamInfoDTO teamInfoDTO = new TeamInfoDTO();

			memberInfoDTO.setMemberName(member.getMemberName());
			memberInfoDTO.setTeam(teamInfoDTO.createTeamDTO(member.getTeam()));
			memberInfoDTO.setRule(ruleInfoDTO.createRuleDTO(member.getTeam().getRule()));
			return memberInfoDTO;
		}
	}

	@Data
	private static class RuleInfoDTO {
		private LocalTime startTime;
		private int goalTime;
		private int amountPerPenalty;

		public RuleInfoDTO createRuleDTO(Rule rule) {
			RuleInfoDTO ruleInfoDTO = new RuleInfoDTO();
			ruleInfoDTO.startTime = rule.getStartTime();
			ruleInfoDTO.goalTime = rule.getGoalTime();
			ruleInfoDTO.amountPerPenalty = rule.getAmountPerPenalty();
			return ruleInfoDTO;
		}
	}

	@Data
	private static class TeamInfoDTO {
		private Long teamId;
		private String teamName;

		public TeamInfoDTO createTeamDTO(Team team) {
			TeamInfoDTO teamInfoDTO = new TeamInfoDTO();
			teamInfoDTO.teamId = team.getId();
			teamInfoDTO.teamName = team.getTeamName();
			return teamInfoDTO;
		}
	}

	// @Data
	// private static class CheckStudyInfoDTO {
	// 	private
	// }
}
