package com.pet.clinic.operador.service;

import org.springframework.http.ResponseEntity;

import com.pet.clinic.operador.dtos.VisitDto;
import com.pet.clinic.operador.models.VisitModel;

public interface IVisitService {

	public VisitModel createVisit(VisitDto visitRequest);
}
