package com.homes.homesLocation.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.homes.homesLocation.entities.HomesDetails;
import com.homes.homesLocation.repository.HomesDetailsRepository;


@Service
public class HomesDetailsServiceImpl implements HomesDetailsService {
	
	@Autowired
	private HomesDetailsRepository homeDetailsRepository;

	@Override
	public HomesDetails createHomesDetails(HomesDetails homesDetails) {
		
		return homeDetailsRepository.save(homesDetails);
	}

	@Override
	public HomesDetails getHomesDetailsById(Long id) {
		Optional <HomesDetails> optionalHomesDetails = homeDetailsRepository.findById(id);

		return optionalHomesDetails.get();
	}

	@Override
	public List<HomesDetails> getAllHomesDetails() {
		return homeDetailsRepository.findAll();
	}

	@Override
	public HomesDetails updateHomesDetails(HomesDetails homesDetails) {
		HomesDetails existingHomesDetails = homeDetailsRepository.findById(homesDetails.getId()).get();
		
		existingHomesDetails.setId(homesDetails.getId());
		existingHomesDetails.setName(homesDetails.getName());
		existingHomesDetails.setCity(homesDetails.getCity());
		existingHomesDetails.setState(homesDetails.getState());
		existingHomesDetails.setPhoto(homesDetails.getPhoto());
		existingHomesDetails.setAvailableUnits(homesDetails.getAvailableUnits());
		existingHomesDetails.setWifi(homesDetails.isWifi());
		existingHomesDetails.setLaundry(homesDetails.isLaundry());


		
		HomesDetails updatedHomesDetails = homeDetailsRepository.save(existingHomesDetails);
		
		return updatedHomesDetails;
	}

	@Override
	public void deleteHomesDetails(Long id) {
		homeDetailsRepository.deleteById(id);
		
	}

}
