package com.daily_study_check.daily_study_check.service;

import java.util.List;

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

	@Transactional(readOnly = false)
	public Long join(Team team) {
		teamRepository.save(team);
		return team.getId();
	}


	public Team find(Long teamId) {
		return teamRepository.findOne(teamId);
	}

	public Team findTeamByMemberId(Long memberId) {
		return teamRepository.findByMemberId(memberId);
	}

	public String generateInvitingCode() {
		String inviteCode = "";
		for (int i = 0; i < 6; i++) {
			double dValue = Math.random();
			int iValue = (int)(dValue *10);
			inviteCode += iValue;
		}
		// if (!validateDuplicateInvitingCode(inviteCode)) {
		// 	inviteCode = generateInvitingCode();
		// }
		return inviteCode;
	}

	public boolean validateDuplicateInvitingCode(String invitingCode) {
		return teamRepository.validateDuplicationOfInvitingCode(invitingCode);
	}

	public Team findByInvitingCode(String invitingCode) {
		return teamRepository.findByInvitingCode(invitingCode);
	}
}
