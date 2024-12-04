package com.example.alimentaTec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated; 
import jakarta.validation.Valid; // Importar Valid

import com.example.alimentaTec.model.Login;
import com.example.alimentaTec.service.LoginService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Validated // Habilitar validación en la clase
@RestController
@RequestMapping("logins")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
@Tag(name = "Logins", description = "Types of logins")
public class LoginController {

	@Autowired
	private LoginService service;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Operation(summary = "Get a Login by his or her Id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Login found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Login.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid Id supplied", content = @Content) })
	@GetMapping("{idUser}")
	public ResponseEntity<?> getByIdlogin(@PathVariable Integer idUser) {
		Login login = service.getByIdLogin(idUser);
		return new ResponseEntity<>(login, HttpStatus.OK);
	}

	@Operation(summary = "Register a Login")
	@PostMapping
	public ResponseEntity<?> register(@Valid @RequestBody Login login) { // Validar el objeto Login
		login.setPasswordUser(passwordEncoder.encode(login.getPasswordUser()));
		service.save(login);
		return new ResponseEntity<>("Saved record", HttpStatus.CREATED);
	}

	@Operation(summary = "Update a Login")
	@PutMapping("{idUser}")
	public ResponseEntity<?> update(@Valid @RequestBody Login login, @PathVariable Integer idUser) { // Validar el objeto Login
		Login auxLogin = service.getByIdLogin(idUser);
		login.setIdUser(auxLogin.getIdUser());
		service.save(login);
		return new ResponseEntity<>("Updated record", HttpStatus.OK);
	}
}