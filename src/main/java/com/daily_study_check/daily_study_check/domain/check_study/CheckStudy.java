package com.daily_study_check.daily_study_check.domain.check_study;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class CheckStudy {
	@Id @GeneratedValue
	@Column(name = "check_study_id")
	private Long id;
	private LocalDate date;
	private boolean ok = false;
}
