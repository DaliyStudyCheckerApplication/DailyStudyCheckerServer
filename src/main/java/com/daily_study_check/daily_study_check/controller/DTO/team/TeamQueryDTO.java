package com.daily_study_check.daily_study_check.controller.DTO.team;

import java.util.ArrayList;
import java.util.List;

import com.daily_study_check.daily_study_check.controller.DTO.member.MemberDTO;
import com.daily_study_check.daily_study_check.domain.member.Member;
import com.daily_study_check.daily_study_check.domain.team.Team;

import lombok.Data;

@Data
public class TeamQueryDTO {
	private String teamName;
	private int memberCount;
	private String invitingCode;
	private List<MemberDTO> members = new ArrayList<>();


	public TeamQueryDTO createTeamQueryDTO(Team team) {
		TeamQueryDTO teamQueryDTO = new TeamQueryDTO();
		teamQueryDTO.setTeamName(team.getTeamName());
		teamQueryDTO.setInvitingCode(team.getInvitingCode());
		teamQueryDTO.setMemberCount(team.getMemberCount());
		for (Member member : team.getMembers()) {
			teamQueryDTO.getMembers().add(new MemberDTO().createMemberDTO(member));
		}

		return teamQueryDTO;
	}

}
