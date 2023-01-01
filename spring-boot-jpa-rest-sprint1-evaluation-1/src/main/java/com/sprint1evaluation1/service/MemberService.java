package com.sprint1evaluation1.service;

import java.util.List;
import java.util.Optional;

import com.sprint1evaluation1.domain.Member;

public interface MemberService {

	List<Member> retrieveMember();

	Optional<Member> getMember(Long memberId);

	Member saveMember(Member member);

	void deleteMember(Long memberId);

	Member updateMember(Long memberId, Member member);

}
