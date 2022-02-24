package com.daily_study_check.daily_study_check.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daily_study_check.daily_study_check.controller.DTO.member.MemberDTO;
import com.daily_study_check.daily_study_check.controller.DTO.member.MemberQueryDTO;
import com.daily_study_check.daily_study_check.controller.DTO.memberInfo.MemberInfoDTO;
import com.daily_study_check.daily_study_check.controller.DTO.member.MemberDeleteRequestDTO;
import com.daily_study_check.daily_study_check.controller.DTO.member.MemberJoinRequestDTO;
import com.daily_study_check.daily_study_check.controller.DTO.member.MemberUpdateRequest;
import com.daily_study_check.daily_study_check.controller.DTO.response.ResponseDTO;
import com.daily_study_check.daily_study_check.domain.member.Discrimination;
import com.daily_study_check.daily_study_check.domain.member.Location;
import com.daily_study_check.daily_study_check.domain.member.Member;
import com.daily_study_check.daily_study_check.repository.MemberRepository;
import com.daily_study_check.daily_study_check.service.MemberService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberApiController {
	private final MemberService memberService;
	private final MemberRepository memberRepository;

	/**
	 * Member CRUD progressing
	 * CREATE done
	 * READ done
	 * UPDATE done
	 * DELETE done
	 */

	/**
	 * Member CREATE
	 * 회원가입
	 * @param memberJoinRequestDTO
	 * @return
	 */
	@PostMapping(value = "/api/v1/members")
	@ResponseBody
	public ResponseDTO<MemberQueryDTO> join(
		@RequestBody MemberJoinRequestDTO memberJoinRequestDTO
	) {
		Location location = new Location(memberJoinRequestDTO.getLocationX(), memberJoinRequestDTO.getLocationY(), memberJoinRequestDTO.getLocationName());
		Member member = Member.createMember(
			memberJoinRequestDTO.getMemberName(),
			memberJoinRequestDTO.getEmail(),
			memberJoinRequestDTO.getPhoneNumber(),
			Discrimination.MEMBER,
			location
			);
		memberService.join(member);
		return new ResponseDTO().createSuccessfulResponse(new MemberQueryDTO().createMemberQueryDTO(member));

	}

	/**
	 * Member READ
	 * 회원 정보
	 * @param memberId
	 * @return
	 */
	@GetMapping(value = "/api/v1/members")
	@ResponseBody
	@ApiOperation(value = "get members")
	public ResponseDTO<MemberQueryDTO> members(
		@RequestParam(value = "id") Long memberId
	) {
		Member member = memberRepository.findOne(memberId);
		return new ResponseDTO().createSuccessfulResponse(new MemberQueryDTO().createMemberQueryDTO(member));
	}

	/**
	 * Member UPDATE
	 * @param memberUpdateRequest
	 * @return
	 */
	@PutMapping(value = "/api/v1/members")
	@ResponseBody
	public ResponseDTO<MemberQueryDTO> updateMember(
		@RequestBody MemberUpdateRequest memberUpdateRequest
	) {
		Location location = new Location(
			memberUpdateRequest.getLocationX(),
			memberUpdateRequest.getLocationY(),
			memberUpdateRequest.getLocationName()
		);
		Member member = Member.createMember(
			memberUpdateRequest.getMemberName(),
			memberUpdateRequest.getEmail(),
			memberUpdateRequest.getPhoneNumber(),
			memberUpdateRequest.getDiscrimination(),
			location
		);
		member.setId(memberUpdateRequest.getMemberId());
		memberService.update(memberUpdateRequest.getMemberId(), member);
		return new ResponseDTO().createSuccessfulResponse(new MemberQueryDTO().createMemberQueryDTO(member));
	}

	/**
	 * Member DELETE
	 * @param memberDeleteRequestDTO
	 * @return
	 */
	@DeleteMapping(value = "/api/v1/members")
	@ResponseBody
	public ResponseDTO<MemberDTO> deleteMember(
		@RequestBody MemberDeleteRequestDTO memberDeleteRequestDTO
	) {
		Long deletedId = memberService.delete(memberDeleteRequestDTO.getMemberId());
		return new ResponseDTO().createSuccessfulResponse(deletedId);
	}

	/**
	 * MemberInfo response
	 * main 화면에 들어갈 정보
	 * @param memberId
	 * @return
	 */
	//TODO: make using dto
	@GetMapping(value = "/api/v1/member_info")
	@ResponseBody
	public MemberInfoDTO memberInfos(
		@RequestParam(value = "id") Long memberId
	) {
		Member byEmail = memberRepository.findOne(memberId);
		MemberInfoDTO memberInfoDTO = new MemberInfoDTO();
		return memberInfoDTO.createMemberInfoDTO(byEmail);
	}
}
