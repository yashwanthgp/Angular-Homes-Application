package com.homes.homesLocation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homes.homesLocation.entities.ApplyForm;
import com.homes.homesLocation.service.ApplyFormService;


import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/clients")
@CrossOrigin(origins = "http://localhost:4200")
public class ApplyFormController {
	
	@Autowired
	private ApplyFormService applyFormService;
	
	@PostMapping
	public ResponseEntity<ApplyForm> createApplyForm(@RequestBody ApplyForm applyForm) {
		ApplyForm savedApplyForm = applyFormService.createApplyForm(applyForm);
		return new ResponseEntity<>(savedApplyForm, HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ApplyForm> getHomesDetailssById(@PathVariable("id") Long id) {
		ApplyForm applyForm = applyFormService.getApplyFormById(id);
		return new ResponseEntity<>(applyForm, HttpStatus.OK); 
	}
	
	@GetMapping
	public ResponseEntity<List<ApplyForm>> getAllApplyForm() {
		
		List<ApplyForm> allApplyFormDetails = applyFormService.getAllApplyForm();
		return new ResponseEntity<>(allApplyFormDetails, HttpStatus.OK);
	}

}
