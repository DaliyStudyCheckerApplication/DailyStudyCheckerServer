package com.daily_study_check.daily_study_check.controller.DTO.memberInfo;

import com.daily_study_check.daily_study_check.domain.team.Team;

import lombok.Data;

@Data
public class TeamInfoDTO {
	private Long teamId;
	private String teamName;

	public TeamInfoDTO createTeamDTO(Team team) {
		TeamInfoDTO teamInfoDTO = new TeamInfoDTO();
		teamInfoDTO.teamId = team.getId();
		teamInfoDTO.teamName = team.getTeamName();
		return teamInfoDTO;
	}
}