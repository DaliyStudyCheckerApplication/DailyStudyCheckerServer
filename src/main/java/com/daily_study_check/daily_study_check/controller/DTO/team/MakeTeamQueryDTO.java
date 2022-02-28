package com.daily_study_check.daily_study_check.controller.DTO.team;

import java.time.LocalTime;

import lombok.Data;

@Data
public class MakeTeamQueryDTO {
	private Long memberId;
	private String teamName;
	private boolean isLocation;
	private LocalTime startTime;
	private int pricePerPenalty;


	public MakeTeamQueryDTO createMakeTeamQueryDTO(Long memberId, String teamName, boolean isLocation, LocalTime startTime, int pricePerPenalty) {
		MakeTeamQueryDTO makeTeamQueryDTO = new MakeTeamQueryDTO();
		makeTeamQueryDTO.setMemberId(memberId);
		makeTeamQueryDTO.setTeamName(teamName);
		makeTeamQueryDTO.setLocation(isLocation);
		makeTeamQueryDTO.setStartTime(startTime);
		makeTeamQueryDTO.setPricePerPenalty(pricePerPenalty);

		return makeTeamQueryDTO;
	}
}
