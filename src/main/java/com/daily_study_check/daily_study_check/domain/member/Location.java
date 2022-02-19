package com.daily_study_check.daily_study_check.domain.member;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Location {
	private double x;
	private double y;
	private String name;
}
