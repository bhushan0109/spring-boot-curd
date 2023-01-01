package com.sprint1evaluation1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1evaluation1.domain.Member;
import com.sprint1evaluation1.repository.IMemberRepo;

@Service
class MemberServiceImpl implements MemberService {

	@Autowired
	IMemberRepo IMemberRepo;
	@Override
	public Member saveMember(Member member) {
		return IMemberRepo.save(member);
	}
	@Override
	public List<Member> retrieveMember() {
		List<Member> member = new ArrayList<>();
		member = IMemberRepo.findAll();
		return member;
	}

	@Override
	public Optional<Member> getMember(Long memberId) {
		return IMemberRepo.findById(memberId);
	}

	

	@Override
	public void deleteMember(Long memberId) {
		IMemberRepo.deleteById(memberId);

	}
	
	 @Override
	    public Member updateMember(Long id, Member member) {

	        if (IMemberRepo.findById(id).isPresent()){
	        	Member member1 = IMemberRepo.findById(id).get();
	        	member1.setId(id);
	        	member1.setMobileNo(member.getMobileNo());
	        	member1.setDob(member.getDob());
	        	member1.setEmail(member.getEmail());
	        	member1.setName(member.getName());
	        	member1.setGender(member.getGender());
	        	member1.setUpdatedAt(member.getUpdatedAt());
	        	Member member2 = IMemberRepo.save(member1);

	            return  member2;
	        }else{
	            return null;
	        }
	    }

}
