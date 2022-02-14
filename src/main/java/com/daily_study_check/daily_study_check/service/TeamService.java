package com.daily_study_check.daily_study_check.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daily_study_check.daily_study_check.domain.team.Team;
import com.daily_study_check.daily_study_check.repository.TeamRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TeamService {
	private final TeamRepository teamRepository;

	// public Team getTeamByMemberId(Long memberId) {
	//
	// }

	public Team getTeam(Long teamId) {
		return teamRepository.findOne(teamId);
	}
}
