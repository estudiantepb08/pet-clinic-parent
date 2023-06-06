package com.pet.clinic.operador.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pet.clinic.operador.config.ResponseSuccesfull;
import com.pet.clinic.operador.dtos.VisitDto;
import com.pet.clinic.operador.exceptions.ExceptionNullData;
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
	
	@PostMapping
	public ResponseEntity<ResponseSuccesfull<VisitDto>> createVisit(@RequestBody VisitDto visitRequest){
		VisitModel response = visitService.createVisit(visitRequest);
		
		if(response != null) {
			responseSuccesfull.setData(visitRequest);
			responseSuccesfull.setMessage(Constants.SUCCESFULL_CREATE);
			responseSuccesfull.setCode(Constants.CODE_SUCCESFULL);
			return new ResponseEntity<ResponseSuccesfull<VisitDto>>(responseSuccesfull,HttpStatus.OK);

		}else {
			throw new ExceptionNullData(Constants.SAVE_NULL);
		}
	}
}
