package com.daily_study_check.daily_study_check.service;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daily_study_check.daily_study_check.domain.member.Member;
import com.daily_study_check.daily_study_check.repository.MemberRepository;
import com.daily_study_check.daily_study_check.repository.RuleRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
//Autowired 보다 생성자 주입을 권장
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	private final RuleRepository ruleRepository;

	/**
	 * 회원가입
	 * 아직 정확한 비즈니스 로직이 나오질 않았기 때문에,
	 * validation은 아직 하지 않는다. 추후 개발 예정
	 * TODO : 비즈니스 로직이 나온 이후에는 db 에 unique 제약 조건을 걸어 두자!!
	 * @param member
	 * @return
	 */
	@Transactional
	public Long join(Member member) {
		memberRepository.save(member);
		return member.getId();
	}

	/**
	 * 멤버 업데이트
	 * @param memberId
	 * @param updateMember
	 * @return
	 */
	@Transactional
	public Long update(Long memberId, Member updateMember) {
		Member member = memberRepository.findOne(memberId);
		member.setId(memberId);
		member.setMemberName(updateMember.getMemberName());
		member.setEmail(updateMember.getEmail());
		member.setPhoneNumber(updateMember.getPhoneNumber());
		member.setLocation(updateMember.getLocation());
		return member.getId();
	}

	/**
	 * 멤버 삭제
	 * @param memberId
	 * @return
	 */
	@Transactional
	public Long delete(Long memberId) {
		memberRepository.delete(memberId);
		return memberId;
	}

	/**
	 * 전체 회원 조회
	 * @return
	 */
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}

	/**
	 * 회원 한 명 조회
	 * @param memberId
	 * @return
	 */
	public Member find(Long memberId) {
		return memberRepository.findOne(memberId);
	}

	/**
	 * ontime 회원 조회
	 * @param localDateTime
	 * @return
	 */
	public List<Member> findByOntime(String localDateTime) {
		return ruleRepository.findByTime(localDateTime);
	}
}
