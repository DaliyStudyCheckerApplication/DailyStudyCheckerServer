package com.daily_study_check.daily_study_check.controller.DTO.team;

import com.daily_study_check.daily_study_check.domain.member.Member;
import com.daily_study_check.daily_study_check.domain.team.Team;

import lombok.Data;

@Data
public class InviteTeamResponseDTO {
	private Long teamId;
	private Long memberId;

	public InviteTeamResponseDTO createInviteTeamResponseDTO(Long memberId, Long teamId) {
		InviteTeamResponseDTO inviteTeamResponseDTO = new InviteTeamResponseDTO();
		inviteTeamResponseDTO.setTeamId(memberId);
		inviteTeamResponseDTO.setMemberId(teamId);

		return inviteTeamResponseDTO;
	}
}
