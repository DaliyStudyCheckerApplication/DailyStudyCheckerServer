package com.daily_study_check.daily_study_check.controller.DTO.team;

import lombok.Data;

@Data
public class MakeTeamResponseDTO {
	private Long teamId;
	private String invitingCode;

	public MakeTeamResponseDTO createMakeTeamResponseDTO (Long teamId, String invitingCode) {
		MakeTeamResponseDTO makeTeamResponseDTO = new MakeTeamResponseDTO();
		makeTeamResponseDTO.setTeamId(teamId);
		makeTeamResponseDTO.setInvitingCode(invitingCode);

		return makeTeamResponseDTO;
	}
}
