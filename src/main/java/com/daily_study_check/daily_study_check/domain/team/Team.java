package com.daily_study_check.daily_study_check.domain.team;

import java.util.ArrayList;
import java.util.List;

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
	@Column(name = "team_id", insertable=false, updatable=false)
	private Long id;

	private String teamName;
	private int memberCount;

	private String invitingCode;

	@OneToMany(mappedBy = "team")
	private List<Member> members = new ArrayList<>();

	@OneToOne
	@JoinColumn(name = "rule_id")
	private Rule rule;
}
