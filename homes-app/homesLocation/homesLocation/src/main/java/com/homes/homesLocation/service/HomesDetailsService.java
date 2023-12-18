package com.homes.homesLocation.service;

import java.util.List;

import com.homes.homesLocation.entities.HomesDetails;



public interface HomesDetailsService {
	
    HomesDetails createHomesDetails(HomesDetails homesDetails);
	
    HomesDetails getHomesDetailsById(Long id);
	
	List<HomesDetails> getAllHomesDetails();
	
	HomesDetails updateHomesDetails(HomesDetails homesDetails);
	
	void deleteHomesDetails(Long id);

}
