package com.daily_study_check.daily_study_check.controller.DTO.member;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.daily_study_check.daily_study_check.domain.member.Member;

import lombok.Data;

@Data
public class MemberOnTimeDTO {
	private List<MemberDTO> members = new ArrayList<>();
	private String sendTime;

	public MemberOnTimeDTO createMemberMemberOntimeRequestDTO(List<Member> members, String sendTime) {
		MemberOnTimeDTO memberOnTimeDTO = new MemberOnTimeDTO();
		for (Member m : members) {
			memberOnTimeDTO
				.getMembers()
				.add(MemberDTO.createMemberDTO(m));
		}
		memberOnTimeDTO.setSendTime(sendTime);
		return memberOnTimeDTO;
	}
}
