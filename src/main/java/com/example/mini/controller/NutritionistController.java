package com.example.alimentaTec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import com.example.alimentaTec.model.Nutritionist;
import com.example.alimentaTec.service.NutritionistService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Validated
@RestController
@RequestMapping("nutritionist")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
@Tag(name = "Nutritionists", description = "Types of Nutritionists")
public class NutritionistController {
	@Autowired
	NutritionistService service;

	@Operation(summary = "Get all accounts with pagination")
	@GetMapping(value = "pagination", params = { "page", "size" })
	public List<Nutritionist> getAllPaginated(@RequestParam(value = "page", defaultValue = "0", required = false) int page,
		@RequestParam(value = "size", defaultValue = "10", required = false) int pageSize) {
		return service.getAll(page, pageSize);
	}

	@Operation(summary = "Get a Nutritionist by his or her id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Nutritionist found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Nutritionist.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid control number supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "Nutritionist not found", content = @Content) })
	@GetMapping("{idNutritionist}")
	public ResponseEntity<?> getByIdNutritionist(@PathVariable Integer idNutritionist) {
		Nutritionist nutritionist = service.getByIdNutritionist(idNutritionist);
		return new ResponseEntity<>(nutritionist, HttpStatus.OK);
	}

	@Operation(summary = "Register a Nutritionist")
	@PostMapping
	public ResponseEntity<?> register(@Valid @RequestBody Nutritionist nutritionist) {
		service.save(nutritionist);
		return new ResponseEntity<>("Saved record", HttpStatus.CREATED);
	}

	@Operation(summary = "Update a Nutritionist")
	@PutMapping("{idNutritionist}")
	public ResponseEntity<?> update(@Valid @RequestBody Nutritionist nutritionist, @PathVariable Integer idNutritionist) {
		Nutritionist auxNutritionist = service.getByIdNutritionist(idNutritionist);
		nutritionist.setIdNutritionist(auxNutritionist.getIdNutritionist());
		service.save(nutritionist);
		return new ResponseEntity<>("Updated record", HttpStatus.OK);
	}

	@Operation(summary = "Get a Nutritionist by his or her name")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Nutritionist found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Nutritionist.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid control number supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "Nutritionist not found", content = @Content) })
	@GetMapping("/name/{nutritionistName}")
	public List<Nutritionist> searchbyNutritionistName(@PathVariable String nutritionistName) {
		return service.searchbyNutritionistName(nutritionistName);
	}
}
