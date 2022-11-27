package com.daily_study_check.daily_study_check.controller.DTO.member;

import com.daily_study_check.daily_study_check.domain.member.Member;

import lombok.Data;

@Data
public class MemberDTO {
	private String memberName;
	private String memberPhoneNumber;
	public static MemberDTO createMemberDTO(Member member) {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setMemberName(member.getMemberName());
		memberDTO.setMemberPhoneNumber(member.getPhoneNumber());
		return memberDTO;
	}
}
