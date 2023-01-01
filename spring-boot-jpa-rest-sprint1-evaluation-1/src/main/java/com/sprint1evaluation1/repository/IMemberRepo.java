package com.sprint1evaluation1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint1evaluation1.domain.Member;
@Repository
public interface IMemberRepo extends JpaRepository<Member, Long> {

	void save(Optional<Member> memberld);

}
