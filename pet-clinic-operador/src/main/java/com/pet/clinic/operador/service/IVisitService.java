package com.pet.clinic.operador.service;

import org.springframework.http.ResponseEntity;

import com.pet.clinic.operador.dtos.VisitDto;
import com.pet.clinic.operador.models.VisitModel;
import java.util.List;

public interface IVisitService {

	public VisitModel createVisit(VisitDto visitRequest);
	
	public List<VisitDto> getVisits();
	
	public VisitModel updateVisit(VisitDto visitRequest);
	
	public List<VisitDto> getVisitById(Long idVisit);
	
	public VisitDto cancelVisit(Long idVisit, VisitDto visit);
	}
