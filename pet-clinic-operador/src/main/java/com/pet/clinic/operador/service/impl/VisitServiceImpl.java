package com.pet.clinic.operador.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.pet.clinic.operador.repository.VisitRepository;
import com.pet.clinic.operador.service.VisitService;

public class VisitServiceImpl implements VisitService{

	@Autowired
	VisitRepository visitRepository;
	
	
	@Override
	public ResponseEntity<?> createVisit() {
		// TODO Auto-generated method stub
		return null;
	}

}
