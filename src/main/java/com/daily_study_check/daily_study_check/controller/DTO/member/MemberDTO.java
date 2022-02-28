package com.daily_study_check.daily_study_check.controller.DTO.member;

import com.daily_study_check.daily_study_check.domain.member.Member;

import lombok.Data;

@Data
public class MemberDTO {
	private String memberName;
	public MemberDTO createMemberDTO(Member member) {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setMemberName(member.getMemberName());
		return memberDTO;
	}
}
