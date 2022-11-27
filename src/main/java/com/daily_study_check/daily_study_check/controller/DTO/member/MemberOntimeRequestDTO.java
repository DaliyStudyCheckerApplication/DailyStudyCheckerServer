package com.daily_study_check.daily_study_check.controller.DTO.member;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MemberOntimeRequestDTO {
	private LocalDate date;
	private String sendTime;
	private String checkTime;
}
