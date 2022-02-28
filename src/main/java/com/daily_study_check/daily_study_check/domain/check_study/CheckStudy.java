package com.daily_study_check.daily_study_check.domain.check_study;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.daily_study_check.daily_study_check.domain.member.Member;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class CheckStudy {
	@Id @GeneratedValue
	@Column(name = "check_study_id")
	private Long id;
	private LocalDateTime dateTime;
	private boolean ok = false;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "member_id")
	private Member member;


	//비즈니스 로직
	public void successCheckStudy() {
		this.ok = true;
	}

	public void failCheckStudy() {
		this.ok = false;
	}
}
