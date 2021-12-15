package com.iiht.training.ratings.controller;

import javax.validation.Valid;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.training.ratings.dto.DevelopmentDto;
import com.iiht.training.ratings.exceptions.InvalidDataException;
import com.iiht.training.ratings.service.DevelopmentService;

@RestController
@RequestMapping("/developments")
public class DevelopmentController {

	@Autowired
	private DevelopmentService developmentService;

	@PostMapping
    public ResponseEntity<?> addDevelopments(@Valid @RequestBody DevelopmentDto developmentDto,
            BindingResult result) {
		if (result.hasErrors()) {
			throw new InvalidDataException("Development Data is not valid");
		}
        System.out.println("Testing Development DTO");
        developmentService.createDevelopment(developmentDto);
        System.out.println(developmentDto);
        System.out.println("Testing Development DTO");
		return ResponseEntity.ok(developmentDto);

	}

	@PutMapping
    public ResponseEntity<?> updateDevelopments(@Valid @RequestBody DevelopmentDto developmentDto,
            BindingResult result) {
		if (result.hasErrors()) {
			throw new InvalidDataException("Development Data is not valid");
		}
		developmentService.updateDevelopment(developmentDto);
		return ResponseEntity.ok(developmentDto);

	}

	@DeleteMapping("/{developmentId}")
	public ResponseEntity<?> deleteDevelopment(@PathVariable Long developmentId) {

		developmentService.deleteDevelopment(developmentId);	
		return ResponseEntity.ok(true);

	}

	@GetMapping("/{developmentId}")
	public ResponseEntity<?> getDevelopmentById(@PathVariable Long developmentId) {

		DevelopmentDto devById = developmentService.getDevelopmentById(developmentId);
		return ResponseEntity.ok(devById);

	}

	@GetMapping
	public ResponseEntity<?> getAllDevelopments() {
		List<DevelopmentDto> list = developmentService.getAllDevelopments();
		return ResponseEntity.ok(list);

	}

	@GetMapping("by-leader-id/{politicalLeaderId}")
	public ResponseEntity<?> getAllDevelopmentsByPoliticalLeaderId(@PathVariable Long politicalLeaderId) {

		List<DevelopmentDto> list = developmentService.getAllDevelopmentsByLeaderId(politicalLeaderId);
		return ResponseEntity.ok(list);

	}

}
