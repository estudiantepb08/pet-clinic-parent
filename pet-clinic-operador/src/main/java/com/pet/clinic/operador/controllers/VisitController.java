package com.pet.clinic.operador.controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pet.clinic.operador.config.ResponseSuccesfull;
import com.pet.clinic.operador.dtos.SearchDto;
import com.pet.clinic.operador.dtos.VisitDto;
import com.pet.clinic.operador.exceptions.ExceptionNullData;
import com.pet.clinic.operador.exceptions.ModelNotFoundException;
import com.pet.clinic.operador.models.VisitModel;
import com.pet.clinic.operador.service.IVisitService;
import com.pet.clinic.operador.utils.Constants;

@RequestMapping("/visit")
@RestController
public class VisitController {
	
	
	@Autowired
	private IVisitService visitService;
	
	@Autowired
	private ResponseSuccesfull<VisitDto> responseSuccesfull;
	
	
	
	@GetMapping
	public ResponseEntity<ResponseSuccesfull<VisitDto>> getVisits(){
		List<VisitDto> visits = visitService.getVisits();
		if(visits.isEmpty()) {
			throw new ModelNotFoundException(Constants.NOT_FOUND_PET);
		}
		responseSuccesfull.setListData(visits);
		responseSuccesfull.setData(null);
		responseSuccesfull.setMessage(Constants.SUCCESFULL_CONSULT);
		responseSuccesfull.setCode(Constants.CODE_SUCCESFULL);
		return new ResponseEntity<ResponseSuccesfull<VisitDto>>(responseSuccesfull,HttpStatus.OK);

	}
	
	@GetMapping("/{idVisit}")
	public ResponseEntity<ResponseSuccesfull<VisitDto>> getVisitById(@PathVariable("idVisit") Long idVisit){
		List<VisitDto> visitFound = visitService.getVisitById(idVisit);
		if(visitFound.size() == 0) {
			throw new ModelNotFoundException(Constants.NOT_FOUND_VISIT);
		}
		responseSuccesfull.setListData(visitFound);
		responseSuccesfull.setData(null);
		responseSuccesfull.setMessage(Constants.SUCCESFULL_CONSULT);
		responseSuccesfull.setCode(Constants.CODE_SUCCESFULL);
		return new ResponseEntity<ResponseSuccesfull<VisitDto>>(responseSuccesfull,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ResponseSuccesfull<VisitDto>> createVisit(@RequestBody VisitDto visitRequest){
		VisitModel response = visitService.createVisit(visitRequest);
		
		if(response != null) {
			responseSuccesfull.setData(visitRequest);
			responseSuccesfull.setMessage(Constants.SUCCESFULL_CREATE);
			responseSuccesfull.setCode(Constants.CODE_SUCCESFULL);
			responseSuccesfull.setListData(null);
			return new ResponseEntity<ResponseSuccesfull<VisitDto>>(responseSuccesfull,HttpStatus.CREATED);

		}else {
			throw new ExceptionNullData(Constants.IS_NULL);
		}
	}
	
	@PutMapping
	public ResponseEntity<ResponseSuccesfull<VisitDto>> updateVisit(@RequestBody VisitDto visitRequest){
		VisitModel response = visitService.updateVisit(visitRequest);
		if(response != null) {
			responseSuccesfull.setData(visitRequest);
			responseSuccesfull.setMessage(Constants.SUCCESFULL_UPDATE);
			responseSuccesfull.setCode(Constants.CODE_SUCCESFULL);
			responseSuccesfull.setListData(null);
			return new ResponseEntity<ResponseSuccesfull<VisitDto>>(responseSuccesfull,HttpStatus.OK);

		}else {
			throw new ExceptionNullData(Constants.IS_NULL);
		}
	}
	
	@PatchMapping("{idVisit}")
	public ResponseEntity<ResponseSuccesfull<VisitDto>> cancelVisit(@PathVariable("idVisit") Long idVisit, @RequestBody VisitDto visit){
		VisitDto response = visitService.cancelVisit(idVisit,visit);
		if(response != null) {
			responseSuccesfull.setData(null);
			responseSuccesfull.setMessage(Constants.SUCCESFULL_CANCEL);
			responseSuccesfull.setCode(Constants.CODE_SUCCESFULL);
			responseSuccesfull.setListData(null);
			return new ResponseEntity<ResponseSuccesfull<VisitDto>>(responseSuccesfull,HttpStatus.OK);

		}else {
			throw new ExceptionNullData(Constants.IS_NULL);
		}
	}
	
	@PostMapping("/search")
	public ResponseEntity<ResponseSuccesfull<VisitDto>> searchVisit(@RequestBody SearchDto search){
		
		List<VisitDto> visitsFound = visitService.searchVisit(search);
		
		if(visitsFound != null || visitsFound.isEmpty()) {
			responseSuccesfull.setData(null);
			responseSuccesfull.setMessage(Constants.SUCCESFULL_CONSULT);
			responseSuccesfull.setCode(Constants.CODE_SUCCESFULL);
			responseSuccesfull.setListData(visitsFound);
			return new ResponseEntity<ResponseSuccesfull<VisitDto>>(responseSuccesfull,HttpStatus.OK);
		}else {
			throw new ModelNotFoundException(Constants.VISITS_SEARCH_NOT_FOUND);
		}
	}
}
