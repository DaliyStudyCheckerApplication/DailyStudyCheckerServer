package com.daily_study_check.daily_study_check.controller.DTO.memberInfo;

import java.time.LocalTime;

import com.daily_study_check.daily_study_check.domain.rule.Rule;

import lombok.Data;

@Data
public class RuleInfoDTO {
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