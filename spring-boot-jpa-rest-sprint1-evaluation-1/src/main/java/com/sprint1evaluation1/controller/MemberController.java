package com.sprint1evaluation1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1evaluation1.domain.Member;
import com.sprint1evaluation1.service.MemberService;

@RestController
@RequestMapping("/api/members")
public class MemberController {
	
	MemberService memberService;

	public MemberController(MemberService todoService) {
		this.memberService = todoService;
	}

	// this api for save user

	@PostMapping
	public ResponseEntity<Member> saveCustomer(@RequestBody Member member) {
		Member member1 = memberService.saveMember(member);

		return new ResponseEntity<>(member1, HttpStatus.CREATED);
	}

	// this api for get single user
	
	@GetMapping({ "/{memberId}" })
	public ResponseEntity<Member> getCustomer(@PathVariable Long memberId) {
		Optional<Member> member = null;
		member = memberService.getMember(memberId);
		if (member.isPresent()) {
			return new ResponseEntity<>(member.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(member.get(), HttpStatus.NOT_FOUND);

	}
	
	// this api for get all user	
	
	@GetMapping
	public ResponseEntity<List<Member>> getAllCustomers() {
		try {
			List<Member> customer = memberService.retrieveMember();
			if (customer.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(customer, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

	// this api for edit user	

	@PutMapping({ "/{memberId}" })
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Member> updateTodo(@PathVariable("memberId") Long memberId, @RequestBody Member member) {
		memberService.updateMember(memberId, member);
		return new ResponseEntity<>(memberService.updateMember(memberId, member), HttpStatus.OK);
	}

	// this api for delete user
	
	@DeleteMapping({ "/{memberId}" })
	public ResponseEntity<Member> deleteTodo(@PathVariable("memberId") Long memberId) {
		memberService.deleteMember(memberId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}