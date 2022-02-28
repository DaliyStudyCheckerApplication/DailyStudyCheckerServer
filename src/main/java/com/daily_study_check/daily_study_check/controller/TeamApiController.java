package com.daily_study_check.daily_study_check.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daily_study_check.daily_study_check.controller.DTO.response.ResponseDTO;
import com.daily_study_check.daily_study_check.controller.DTO.team.InviteTeamQueryDTO;
import com.daily_study_check.daily_study_check.controller.DTO.team.InviteTeamResponseDTO;
import com.daily_study_check.daily_study_check.controller.DTO.team.MakeTeamQueryDTO;
import com.daily_study_check.daily_study_check.controller.DTO.team.MakeTeamResponseDTO;
import com.daily_study_check.daily_study_check.controller.DTO.team.TeamQueryDTO;
import com.daily_study_check.daily_study_check.domain.member.Discrimination;
import com.daily_study_check.daily_study_check.domain.member.Member;
import com.daily_study_check.daily_study_check.domain.rule.Rule;
import com.daily_study_check.daily_study_check.domain.team.Team;
import com.daily_study_check.daily_study_check.repository.TeamRepository;
import com.daily_study_check.daily_study_check.service.MemberService;
import com.daily_study_check.daily_study_check.service.TeamService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TeamApiController {
	private final TeamRepository teamRepository;
	private final TeamService teamService;
	private final MemberService memberService;

	@GetMapping("/api/v1/teams")
	@ResponseBody
	public ResponseDTO teams (
		@RequestParam(value = "id") Long teamId
	) {
		Team team = teamRepository.findOne(teamId);
		return new ResponseDTO<>()
			.createSuccessfulResponse(
				new TeamQueryDTO()
					.createTeamQueryDTO(team));
	}

	@PostMapping("/api/v1/teams")
	@ResponseBody
	public ResponseDTO makeTeam (
		@RequestBody MakeTeamQueryDTO makeTeamQueryDTO
	) {
		Member member = memberService.find(makeTeamQueryDTO.getMemberId());
		member.setDiscrimination(Discrimination.LEADER);
		Rule rule = Rule.createRule(
			makeTeamQueryDTO.isLocation(),
			makeTeamQueryDTO.getStartTime(),
			5,
			makeTeamQueryDTO.getPricePerPenalty()
		);

		String invitingCode = teamService.generateInvitingCode();
		Team team = Team.createTeam(
			makeTeamQueryDTO.getTeamName(),
			invitingCode,
			rule,
			member
		);
		Long teamId = teamService.join(team);
		return new ResponseDTO<MakeTeamResponseDTO>()
			.createSuccessfulResponse(
				new MakeTeamResponseDTO()
					.createMakeTeamResponseDTO(teamId,invitingCode));
	}

	@GetMapping("/api/v1/teams/invite")
	@ResponseBody
	public ResponseDTO teamsByInvitingCode (
		@RequestParam(value = "invitingCode") String invitingCode
	) {
		Team team = teamService.findByInvitingCode(invitingCode);
		return new ResponseDTO<>()
			.createSuccessfulResponse(
				new TeamQueryDTO()
					.createTeamQueryDTO(team));
	}

	@PostMapping("/api/v1/teams/invite")
	@ResponseBody
	public ResponseDTO joinMemberInTeam (
		@RequestBody InviteTeamQueryDTO inviteTeamQueryDTO
	) {
		Member member = memberService.find(inviteTeamQueryDTO.getMemberId());
		Team team = teamService.find(inviteTeamQueryDTO.getTeamId());
		member.setTeam(team);
		team.addMember(member);
		teamService.join(team);
		return new ResponseDTO<InviteTeamResponseDTO>()
			.createSuccessfulResponse(
				new InviteTeamResponseDTO()
					.createInviteTeamResponseDTO(inviteTeamQueryDTO.getMemberId(), inviteTeamQueryDTO.getTeamId())
			);
	}
}
