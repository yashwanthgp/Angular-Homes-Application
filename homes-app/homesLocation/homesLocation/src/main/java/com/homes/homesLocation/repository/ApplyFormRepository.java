package com.homes.homesLocation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.homes.homesLocation.entities.ApplyForm;

@Repository
public interface ApplyFormRepository extends JpaRepository<ApplyForm, Long> {
	
	Optional<ApplyForm> findById(Long id);
	

}
