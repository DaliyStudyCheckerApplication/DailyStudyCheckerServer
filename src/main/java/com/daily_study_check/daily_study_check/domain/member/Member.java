package com.daily_study_check.daily_study_check.domain.member;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.daily_study_check.daily_study_check.domain.check_study.CheckStudy;
import com.daily_study_check.daily_study_check.domain.team.Team;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Member {

	@Id @GeneratedValue
	@Column(name = "member_id")
	private Long id;
	private String memberName;
	private String email;
	private String phoneNumber;


	@Embedded
	private Location location;

	@Enumerated(value = EnumType.STRING)
	private Discrimination discrimination;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id")
	private Team team;

	@OneToOne
	@JoinColumn(name = "check_id")
	private CheckStudy checkStudy;

	//생성메서드
	public static Member createMember(String memberName, String email, String phoneNumber, Discrimination discrimination, Location location ) {
		Member member = new Member();
		member.setMemberName(memberName);
		member.setEmail(email);
		member.setPhoneNumber(phoneNumber);
		member.setDiscrimination(discrimination);
		member.setLocation(location);

		return member;
	}
}
