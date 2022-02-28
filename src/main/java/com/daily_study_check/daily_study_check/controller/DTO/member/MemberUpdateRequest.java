package com.daily_study_check.daily_study_check.controller.DTO.member;

import com.daily_study_check.daily_study_check.domain.member.Discrimination;

import lombok.Data;

@Data
public class MemberUpdateRequest {
	private Long memberId;
	private String memberName;
	private String email;
	private Discrimination discrimination;
	private String phoneNumber;
	private String locationName;
	private double locationX;
	private double locationY;
}
