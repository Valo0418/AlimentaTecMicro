package com.example.alimentaTec.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.example.alimentaTec.service.JournalService;
import com.example.alimentaTec.model.Journal;
import org.springframework.validation.annotation.Validated; // Importar Validated
import jakarta.validation.Valid; // Importar Valid


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Validated
@RestController
@RequestMapping("journals")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })

@Tag(name = "Journals", description = "Various Journal")
public class JournalController {
	@Autowired
	private JournalService service;
	
	@Operation(summary = "Get all accounts with pagination")
	@GetMapping(value = "pagination", params = { "page", "size" })
	public List<Journal> getAllPaginated(@RequestParam(value = "page", defaultValue = "0", required = false) int 
	page,
	
	@RequestParam(value = "size", defaultValue = "10", required = false) int pageSize) {
		List<Journal> saucer = service.getAll(page, pageSize);
		return saucer;
	}

	@Operation(summary = "Get a Journal by his or her Id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Journal found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Journal.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid Journal", content = @Content),
			@ApiResponse(responseCode = "404", description = "Journal not found", content = @Content) })
	@GetMapping("{idJournal}")
	public ResponseEntity<?> getByIdActivity(@PathVariable Integer idJournal) {
		Journal journal = service.getIdJournal(idJournal);
		return new ResponseEntity<Journal>(journal, HttpStatus.OK);
	}

	@Operation(summary = "Create a Journal")
	@PostMapping
	public ResponseEntity<?> register(@Valid @RequestBody Journal journal) {
		service.save(journal);
		return new ResponseEntity<String>("Saved record", HttpStatus.CREATED);
	}

	@Operation(summary = "Update a Journal")
	@PutMapping("{idJournal}")
	public ResponseEntity<?> update(@Valid @RequestBody Journal journal, @PathVariable Integer idJournal) {
		Journal auxJournal = service.getIdJournal(idJournal);	
		journal.setIdJournal(auxJournal.getIdJournal());
		service.save(journal);
		return new ResponseEntity<String>("Updated record", HttpStatus.OK);
	}

	@Operation(summary = "Delete a Journal")
	@DeleteMapping("{idJournal}")
	public ResponseEntity<?> delete(@PathVariable Integer idJournal) {
		service.delete(idJournal);
		return new ResponseEntity<String>("Deleted record", HttpStatus.OK);
	}
}
