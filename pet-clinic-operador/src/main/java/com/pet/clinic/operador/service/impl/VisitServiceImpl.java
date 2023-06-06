package com.pet.clinic.operador.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pet.clinic.operador.service.impl.*;
import com.pet.clinic.operador.utils.Constants;
import com.pet.clinic.operador.config.ResponseMsBuscador;
import com.pet.clinic.operador.dtos.VisitDto;
import com.pet.clinic.operador.enums.ResponseMessageEnum;
import com.pet.clinic.operador.exceptions.ModelNotFoundException;
import com.pet.clinic.operador.facade.OwnerFacade;
import com.pet.clinic.operador.facade.PetFacade;
import com.pet.clinic.operador.models.VisitModel;
import com.pet.clinic.operador.repository.VisitRepository;
import com.pet.clinic.operador.service.IVisitService;

@Service
public class VisitServiceImpl implements IVisitService{

	@Autowired
	VisitRepository visitRepository;
	
	@Autowired
	OwnerFacade ownerFacade;
	
	@Autowired
	PetFacade petFacade;
	
    private static final Logger LOGGER = LoggerFactory.getLogger(VisitServiceImpl.class);

	
	@Override
	public VisitModel createVisit(VisitDto visitRequest) {
		ResponseMsBuscador responsePet = petFacade.getPet(visitRequest.getIdPet());
		if (responsePet == null){
			throw new ModelNotFoundException(Constants.NOT_FOUND_PET);
		}
        LOGGER.info("getMascotas" + responsePet);
        System.out.println("OBJETO MASCOTa" + responsePet.getData());
        
		ResponseMsBuscador responseOwner = petFacade.getPet(visitRequest.getIdOwner());
		
		if (responseOwner == null){
			throw new ModelNotFoundException(Constants.NOT_FOUND_OWNER);
		}
		
		VisitModel model = VisitModel.builder().dateVisit(visitRequest.getDateVisit()).idPet(visitRequest.getIdPet())
							.idOwner(visitRequest.getIdOwner()).cost(visitRequest.getCost()).idVeterinary(visitRequest.getIdVeterinary())
							.reason(visitRequest.getReason()).isFirstVisit(visitRequest.getIsFirstVisit())
							.status(visitRequest.getStatus()).build();
		
		return visitRepository.save(model);
		
	}

}
