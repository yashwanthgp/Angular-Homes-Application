package com.homes.homesLocation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homes.homesLocation.entities.HomesDetails;
import com.homes.homesLocation.service.HomesDetailsService;


import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/locationss")
@CrossOrigin(origins = "http://localhost:4200")
public class HomesDetailsController {
	
	@Autowired
	private HomesDetailsService homesDetailsService;
	
	@PostMapping
	public ResponseEntity<HomesDetails> createHomesDetails(@RequestBody HomesDetails homesDetails) {
		HomesDetails savedHomesDetails = homesDetailsService.createHomesDetails(homesDetails);
		return new ResponseEntity<>(savedHomesDetails, HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<HomesDetails> getHomesDetailssById(@PathVariable("id") Long id) {
		HomesDetails homesDetails = homesDetailsService.getHomesDetailsById(id);
		return new ResponseEntity<>(homesDetails, HttpStatus.OK); 
	}
	
	@GetMapping
	public ResponseEntity<List<HomesDetails>> getAllHomesDetails() {
		
		List<HomesDetails> allHomesDetails = homesDetailsService.getAllHomesDetails();
		return new ResponseEntity<>(allHomesDetails, HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<HomesDetails> updateupdateHomesDetails(@PathVariable ("id") Long id,
			                                          @RequestBody HomesDetails homesDetails) {
		homesDetails.setId(id);
		HomesDetails updateHomesDetails = homesDetailsService.updateHomesDetails(homesDetails);
		return new ResponseEntity<>(updateHomesDetails, HttpStatus.OK);
	
    }
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteupdateHomesDetails(@PathVariable ("id") Long id) {
		homesDetailsService.deleteHomesDetails(id);
		return new ResponseEntity<>("Catalog successfully deleted!", HttpStatus.OK);
		
	}

}
