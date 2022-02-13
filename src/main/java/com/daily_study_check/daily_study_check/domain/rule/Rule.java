package com.daily_study_check.daily_study_check.domain.rule;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Rule {
	@Id @GeneratedValue
	@Column(name = "rule_id")
	private Long id;

	private boolean isLocation;

	private LocalTime startTime;

	private int goalTime;//minute

	private int amountPerPenalty;
}
