package com.daily_study_check.daily_study_check.controller.DTO.member;

import com.daily_study_check.daily_study_check.domain.member.Location;
import com.daily_study_check.daily_study_check.domain.member.Member;

import lombok.Data;

//회원 수정에서 hint 로 나올 것들 수정 가능 한 것들..
//responseBody로 보내 줘야 함
@Data
public class MemberQueryDTO {
	private Long memberId;
	private String memberName;
	private String locationName;
	private String email;
	private String phoneNumber;
	private double locationX;
	private double locationY;

	public MemberQueryDTO createMemberQueryDTO(Member member) {
		Location location = new Location(member.getLocation().getX(), member.getLocation().getY(), member.getLocation().getLocationName());
		MemberQueryDTO memberQueryDTO = new MemberQueryDTO();
		memberQueryDTO.setMemberId(member.getId());
		memberQueryDTO.setMemberName(member.getMemberName());
		memberQueryDTO.setLocationName(location.getLocationName());
		memberQueryDTO.setEmail(member.getEmail());
		memberQueryDTO.setPhoneNumber(member.getPhoneNumber());
		memberQueryDTO.setLocationX(location.getX());
		memberQueryDTO.setLocationY(location.getY());

		return memberQueryDTO;
	}
}
