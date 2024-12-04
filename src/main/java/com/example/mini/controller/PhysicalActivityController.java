package com.example.alimentaTec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import com.example.alimentaTec.model.PhysicalActivity;
import com.example.alimentaTec.service.PhysicalActivityService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Validated
@RestController
@RequestMapping("physicalActivities")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
@Tag(name = "Physical Activities", description = "Various physical activities")
public class PhysicalActivityController {

	@Autowired
	private PhysicalActivityService service;

	@Operation(summary = "Get all accounts with pagination")
	@GetMapping(value = "pagination", params = { "page", "size" })
	public List<PhysicalActivity> getAllPaginated(@RequestParam(value = "page", defaultValue = "0", required = false) int page,
		@RequestParam(value = "size", defaultValue = "10", required = false) int pageSize) {
		return service.getAll(page, pageSize);
	}

	@Operation(summary = "Get a physical activity by its Id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Activity found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = PhysicalActivity.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid activity", content = @Content),
			@ApiResponse(responseCode = "404", description = "Activity not found", content = @Content) })
	@GetMapping("{idActivity}")
	public ResponseEntity<?> getByIdActivity(@PathVariable Integer idActivity) {
		PhysicalActivity physicalActivity = service.getByIdActivity(idActivity);
		return new ResponseEntity<>(physicalActivity, HttpStatus.OK);
	}

	@Operation(summary = "Create a physical activity")
	@PostMapping()
	public ResponseEntity<?> createActivity(@Valid @RequestBody PhysicalActivity activity) {
		service.save(activity);
		return new ResponseEntity<>("Activity created", HttpStatus.CREATED);
	}

	@Operation(summary = "Update a physical activity")
	@PutMapping("{idActivity}")
	public ResponseEntity<?> update(@Valid @RequestBody PhysicalActivity physicalActivity, @PathVariable Integer idActivity) {
		PhysicalActivity auxActivity = service.getByIdActivity(idActivity);
		physicalActivity.setIdActivity(auxActivity.getIdActivity());
		service.save(physicalActivity);
		return new ResponseEntity<>("Updated record", HttpStatus.OK);
	}
}
