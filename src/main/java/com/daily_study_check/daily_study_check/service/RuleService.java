package com.daily_study_check.daily_study_check.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daily_study_check.daily_study_check.domain.rule.Rule;
import com.daily_study_check.daily_study_check.repository.RuleRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RuleService {
	private final RuleRepository ruleRepository;

	public List<Rule> getRules() {
		return ruleRepository.findAll();
	}
}
