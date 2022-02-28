package com.daily_study_check.daily_study_check.controller.DTO.checkStudy;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CheckStudyTodayResponseDTO {
	private boolean ok;
	private LocalDateTime checkingTime;

	public CheckStudyTodayResponseDTO createCheckStudyTodayResponseDTO(boolean ok, LocalDateTime checkingTime) {
		CheckStudyTodayResponseDTO checkStudyTodayResponseDTO = new CheckStudyTodayResponseDTO();
		checkStudyTodayResponseDTO.setOk(ok);
		checkStudyTodayResponseDTO.setCheckingTime(checkingTime);

		return checkStudyTodayResponseDTO;
	}
}
