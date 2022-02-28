package com.daily_study_check.daily_study_check.controller.DTO.checkStudy;

import java.time.LocalDateTime;

import com.daily_study_check.daily_study_check.domain.check_study.CheckStudy;

import lombok.Data;

@Data
public class CheckStudyDTO {
	private LocalDateTime dateTime;
	private boolean ok;

	public static CheckStudyDTO createCheckStudyDTO(CheckStudy checkStudy) {
		CheckStudyDTO checkStudyDTO = new CheckStudyDTO();
		checkStudyDTO.setDateTime(checkStudy.getDateTime());
		checkStudyDTO.setOk(checkStudy.isOk());

		return checkStudyDTO;
	}
}
