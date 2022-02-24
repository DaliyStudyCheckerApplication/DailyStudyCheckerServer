package com.daily_study_check.daily_study_check.domain.team;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.daily_study_check.daily_study_check.domain.member.Member;
import com.daily_study_check.daily_study_check.domain.rule.Rule;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Team {
	@Id
	@GeneratedValue
	@Column(name = "team_id")
	private Long id;

	private String teamName;
	private int memberCount;

	private String invitingCode;

	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
	private List<Member> members = new ArrayList<>();

	@OneToOne
	@JoinColumn(name = "rule_id")
	private Rule rule;

	//연관관계 메서드
	public void addMember(Member member) {
		members.add(member);
		member.setTeam(this);
	}
	//생성 메서드
	public static Team createTeam(String teamName, String invitingCode, Rule rule, Member... members) {
		Team team = new Team();
		team.setTeamName(teamName);
		team.setInvitingCode(invitingCode);
		team.setRule(rule);
		for (Member member : members) {
			team.addMember(member);
		}
		team.setMemberCount(members.length);
		return team;
	}
}
