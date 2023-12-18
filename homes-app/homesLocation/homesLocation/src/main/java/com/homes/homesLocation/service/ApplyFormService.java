package com.homes.homesLocation.service;

import java.util.List;

import com.homes.homesLocation.entities.ApplyForm;
import com.homes.homesLocation.entities.HomesDetails;

public interface ApplyFormService {
	
    ApplyForm createApplyForm(ApplyForm applyForm);
	
    ApplyForm getApplyFormById(Long id);
	
	List<ApplyForm> getAllApplyForm();
	
	ApplyForm updateApplyForm(HomesDetails applyForm);
	
	void deleteApplyForm(Long id);

}
