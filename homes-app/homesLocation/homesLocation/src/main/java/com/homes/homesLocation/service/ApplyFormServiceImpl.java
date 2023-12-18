package com.homes.homesLocation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homes.homesLocation.entities.ApplyForm;
import com.homes.homesLocation.entities.HomesDetails;
import com.homes.homesLocation.repository.ApplyFormRepository;

@Service
public class ApplyFormServiceImpl implements ApplyFormService {
	
	@Autowired
	private ApplyFormRepository applyFormRepository;

	@Override
	public ApplyForm createApplyForm(ApplyForm applyForm) {
		
		return applyFormRepository.save(applyForm);
	}

	@Override
	public ApplyForm getApplyFormById(Long id) {
		Optional <ApplyForm> optionalApplyForm = applyFormRepository.findById(id);		
		return optionalApplyForm.get();
	}

	@Override
	public List<ApplyForm> getAllApplyForm() {
		return applyFormRepository.findAll();
	}

	@Override
	public ApplyForm updateApplyForm(HomesDetails applyForm) {
		return null;
	}

	@Override
	public void deleteApplyForm(Long id) {
		applyFormRepository.deleteById(id);
		
	}

}
