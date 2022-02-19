package com.daily_study_check.daily_study_check.controller.DTO.request;


import lombok.Data;

@Data
public class MemberJoinRequestDTO {
	private Long memberId;
	private String memberName;
	private String email;
	private String phoneNumber;
	private String locationName;
	private double locationX;
	private double locationY;
}
