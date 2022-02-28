package com.daily_study_check.daily_study_check.controller.DTO.memberInfo;

import com.daily_study_check.daily_study_check.domain.check_study.CheckStudy;
import com.daily_study_check.daily_study_check.domain.member.Member;

import lombok.Data;

@Data
public class MemberInfoDTO {
	private String memberName;
	private RuleInfoDTO rule;
	private TeamInfoDTO team;
	private CheckStudyInfoDTO checkStudy;

	public MemberInfoDTO createMemberInfoDTO(Member member) {
		MemberInfoDTO memberInfoDTO = new MemberInfoDTO();
		RuleInfoDTO ruleInfoDTO = new RuleInfoDTO();
		TeamInfoDTO teamInfoDTO = new TeamInfoDTO();
		CheckStudyInfoDTO checkStudyInfoDTO = new CheckStudyInfoDTO();

		memberInfoDTO.setMemberName(member.getMemberName());
		memberInfoDTO.setTeam(teamInfoDTO.createTeamDTO(member.getTeam()));
		memberInfoDTO.setRule(ruleInfoDTO.createRuleDTO(member.getTeam().getRule()));
		memberInfoDTO.setCheckStudy(checkStudyInfoDTO.createCheckStudyInfoDTO(member.getCheckStudies()));
		return memberInfoDTO;
	}
}