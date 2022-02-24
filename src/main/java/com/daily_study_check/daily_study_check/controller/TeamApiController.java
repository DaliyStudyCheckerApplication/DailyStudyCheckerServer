package com.daily_study_check.daily_study_check.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daily_study_check.daily_study_check.controller.DTO.response.ResponseDTO;
import com.daily_study_check.daily_study_check.controller.DTO.team.TeamQueryDTO;
import com.daily_study_check.daily_study_check.domain.team.Team;
import com.daily_study_check.daily_study_check.repository.TeamRepository;
import com.daily_study_check.daily_study_check.service.TeamService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TeamApiController {
	private final TeamRepository teamRepository;
	private final TeamService teamService;

	@GetMapping("/api/v1/teams")
	@ResponseBody
	public ResponseDTO<TeamQueryDTO> teams(
		@RequestParam(value = "id") Long teamId
	) {
		Team team = teamRepository.findOne(teamId);
		return new ResponseDTO<>().createSuccessfulResponse(new TeamQueryDTO().createTeamQueryDTO(team));
	}
}
