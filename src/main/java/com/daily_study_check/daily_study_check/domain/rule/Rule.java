package com.daily_study_check.daily_study_check.domain.rule;

import java.time.LocalDateTime;
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

	//생성메서드
	public static Rule createRule(boolean isLocation, LocalTime startTime, int goalTime, int amountPerPenalty) {
		Rule rule = new Rule();
		rule.setLocation(isLocation);
		rule.setStartTime(startTime);
		rule.setGoalTime(goalTime);
		rule.setAmountPerPenalty(amountPerPenalty);

		return rule;
	}

	//비즈니스 로직
	public boolean checkIfSuccessOrFail(LocalDateTime localDateTime) {
		LocalTime checkingTime = LocalTime.of(
			localDateTime.getHour(),
			localDateTime.getMinute(),
			localDateTime.getSecond(),
			localDateTime.getNano()
			);
		if (checkingTime.isBefore(getStartTime())) {
			return true;
		}
		return false;
	}
}
