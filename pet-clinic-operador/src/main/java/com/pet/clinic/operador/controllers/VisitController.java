package com.pet.clinic.operador.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/visit")
@RestController
public class VisitController {
	
	@PostMapping
	public ResponseEntity<?> createVisit(){
		return null;
	}
}
