package com.pinchuk.resthotelbooking.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pinchuk.resthotelbooking.domain.Greeting;

public interface GreetingRepo extends JpaRepository<Greeting, Long> {
	
	List<Greeting> findByName(final String name);
	
	@Query(value = "SELECT candidate_id FROM candidate WHERE local_id in ?1", nativeQuery = true)
	List<String> findCandidateIdsByLocalIds(final List<String> localIds);

}
