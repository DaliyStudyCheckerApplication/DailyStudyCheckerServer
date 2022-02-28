package com.daily_study_check.daily_study_check.controller.DTO.memberInfo;

import java.util.ArrayList;
import java.util.List;

import com.daily_study_check.daily_study_check.controller.DTO.checkStudy.CheckStudyDTO;
import com.daily_study_check.daily_study_check.domain.check_study.CheckStudy;
import com.daily_study_check.daily_study_check.domain.member.Member;

import lombok.Data;

@Data
public class CheckStudyInfoDTO {
	private List<CheckStudyDTO> checkStudyList = new ArrayList<>();

	public CheckStudyInfoDTO createCheckStudyInfoDTO(List<CheckStudy> checkStudies) {
		CheckStudyInfoDTO checkStudyInfoDTO = new CheckStudyInfoDTO();
		for (CheckStudy checkStudy : checkStudies) {
			checkStudyInfoDTO
				.getCheckStudyList()
				.add(CheckStudyDTO.createCheckStudyDTO(checkStudy));
		}
		return checkStudyInfoDTO;
	}
}
