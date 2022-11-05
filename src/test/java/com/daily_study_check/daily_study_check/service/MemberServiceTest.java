// package com.daily_study_check.daily_study_check.service;
//
// import static org.junit.jupiter.api.Assertions.*;
// import static org.mockito.BDDMockito.*;
//
// import java.util.Optional;
//
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.junit.jupiter.MockitoExtension;
// import org.springframework.test.util.ReflectionTestUtils;
//
// import com.daily_study_check.daily_study_check.domain.member.Discrimination;
// import com.daily_study_check.daily_study_check.domain.member.Location;
// import com.daily_study_check.daily_study_check.domain.member.Member;
// import com.daily_study_check.daily_study_check.repository.MemberRepository;
//
// @ExtendWith(MockitoExtension.class)
// class MemberServiceTest {
// 	@InjectMocks
// 	private MemberService memberService;
//
// 	@Mock
// 	private MemberRepository memberRepository;
//
// 	/**
// 	 * join
// 	 * update
// 	 * delete
// 	 * findMembers
// 	 */
//
//
// 	@Test
// 	public void join_test() throws Exception {
// 		// given
// 		Member testMember = Member.createMember(
// 			"test name",
// 			"test email",
// 			"test phone number",
// 			Discrimination.MEMBER,
// 			new Location(0.0, 0.0, "test location")
// 		);
//
// 		Long fakeMemberId = 2l;
// 		ReflectionTestUtils.setField(testMember, "id", fakeMemberId);
//
// 		// mocking
// 		given(
// 			memberRepository.save(any())
// 		)
// 			.willReturn(fakeMemberId);
//
// 		given(
// 			memberRepository.findOne(fakeMemberId)
// 		)
// 			.willReturn(testMember);
//
// 		// when
// 		Long newMemberId = memberService.join(testMember);
//
// 		// then
// 		Member findMember = memberRepository.findOne(newMemberId);
//
// 		assertEquals(
// 			testMember.getId(),
// 			findMember.getId()
// 		);
// 		assertEquals(
// 			testMember.getMemberName(),
// 			findMember.getMemberName()
// 		);
//
// 	}
// }