package com.pet.clinic.operador.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pet.clinic.operador.service.impl.*;
import com.pet.clinic.operador.utils.Constants;
import com.pet.clinic.operador.utils.ValidDataVisitMicroservices;
import com.pet.clinic.operador.config.ResponseMsBuscador;
import com.pet.clinic.operador.dtos.SearchDto;
import com.pet.clinic.operador.dtos.VisitDto;
import com.pet.clinic.operador.enums.ResponseMessageEnum;
import com.pet.clinic.operador.enums.StatusVisit;
import com.pet.clinic.operador.exceptions.ModelNotFoundException;
import com.pet.clinic.operador.exceptions.VisitCancel;
import com.pet.clinic.operador.facade.OwnerFacade;
import com.pet.clinic.operador.facade.PetFacade;
import com.pet.clinic.operador.mapper.VisitMapper;
import com.pet.clinic.operador.mapper.VisitMapperSearch;
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
	
	@Autowired
	ValidDataVisitMicroservices validDataVisitMS;
	
    private static final Logger LOGGER = LoggerFactory.getLogger(VisitServiceImpl.class);

	
	@Override
	public VisitModel createVisit(VisitDto visitRequest) {
		ResponseMsBuscador responsePet = petFacade.getPet(visitRequest.getPet().getMascotasId());
		if (responsePet == null){
			throw new ModelNotFoundException(Constants.NOT_FOUND_PET);
		}  
		ResponseMsBuscador responseOwner = ownerFacade.getOwner(visitRequest.getOwner().getPropietariosId());
		
		if (responseOwner == null){
			throw new ModelNotFoundException(Constants.NOT_FOUND_OWNER);
		}
		
		VisitModel model = VisitModel.builder().dateVisit(visitRequest.getDateVisit()).idPet(visitRequest.getPet().getMascotasId())
							.idOwner(visitRequest.getOwner().getPropietariosId()).cost(visitRequest.getCost()).idVeterinary(visitRequest.getIdVeterinary())
							.reason(visitRequest.getReason()).isFirstVisit(visitRequest.getIsFirstVisit())
							.status(visitRequest.getStatus()).build();
		
		return visitRepository.save(model);
		
	}


	@Override
	public List<VisitDto> getVisits() {
		
		List<VisitModel> visits = visitRepository.findAll();
		
		List<ResponseMsBuscador> pets = visits.stream()
	            .map(v -> petFacade.getPet(v.getIdPet()))
	            .collect(Collectors.toList());	
		
		List<ResponseMsBuscador> owners = visits.stream()
	            .map(v -> ownerFacade.getOwner(v.getIdOwner()))
	            .collect(Collectors.toList());
		
		List<VisitDto> visitResponse = VisitMapper.mapVisit(pets, owners, visits);
		return visitResponse;
	}


	@Override
	public VisitModel updateVisit(VisitDto visitRequest) {
		Optional<VisitModel> existVisit = visitRepository.findById(visitRequest.getIdVisit());
	
		if(existVisit.isEmpty()) {
			throw new ModelNotFoundException(Constants.NOT_FOUND_VISIT);
		}
		validDataVisitMS.ValidData(visitRequest.getPet().getMascotasId(), visitRequest.getOwner().getPropietariosId());
		
		VisitModel visit = existVisit.get();
		visit.setDateVisit(visitRequest.getDateVisit());
		visit.setFirstVisit(visitRequest.getIsFirstVisit());
		visit.setIdOwner(visitRequest.getOwner().getPropietariosId());
		visit.setIdPet(visitRequest.getPet().getMascotasId());
		visit.setReason(visitRequest.getReason());
		visit.setStatus(visit.getStatus());
		visit.setCost(visitRequest.getCost());
		visit = visitRepository.save(visit);
		return visit;
	}


	@Override
	public List<VisitDto> getVisitById(Long idVisit) {
		Optional<VisitModel> existVisit = visitRepository.findById(idVisit);
		
		if(existVisit.isEmpty()) {
			throw new ModelNotFoundException(Constants.NOT_FOUND_VISIT);
		}
		VisitModel visitFound = existVisit.get();
		ResponseMsBuscador responsePet = petFacade.getPet(visitFound.getIdPet());
		if (!responsePet.getMessages().equals(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages())){
			throw new ModelNotFoundException(Constants.NOT_FOUND_PET);
		}  
		ResponseMsBuscador responseOwner = ownerFacade.getOwner(visitFound.getIdOwner());
		
		if (!responseOwner.getMessages().equals(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages())){
			throw new ModelNotFoundException(Constants.NOT_FOUND_OWNER);
		}
		List<ResponseMsBuscador> pets = new ArrayList<>();
		List<ResponseMsBuscador> owners = new ArrayList<>();
		List<VisitModel> visits = new ArrayList<>();
		pets.add(responsePet);
		owners.add(responseOwner);
		visits.add(visitFound);

		List<VisitDto> visitResponse = VisitMapper.mapVisit(pets, owners, visits);
		return visitResponse;
		
	}


	@Override
	public VisitDto cancelVisit(Long idVisit, VisitDto visit) {
		
		Optional<VisitModel> existVisit = visitRepository.findById(idVisit);
		if(existVisit.isEmpty()) {
			throw new ModelNotFoundException(Constants.NOT_FOUND_VISIT);
		}
		VisitModel visitUpdate = existVisit.get();
		if (visitUpdate.getStatus() == StatusVisit.INACTIVE) {
		    throw new VisitCancel(Constants.VISIT_CANCEL);
		}
		visitUpdate.setStatus(visit.getStatus());
		visitUpdate = visitRepository.save(visitUpdate);
		return visit;
	}


	@Override
	public List<VisitDto> searchVisit(SearchDto search) {
			List<VisitDto> visitResponse = new ArrayList<>();
			ResponseMsBuscador response = new ResponseMsBuscador();
			List<VisitModel> visits = new ArrayList<>();
		if( search.getParamMSBuscador() != null) {
			List<ResponseMsBuscador> responseList = new ArrayList<>();
			 response = petFacade.searchTodo(search.getParamMSBuscador());
			 responseList.add(response);
			visits = visitRepository.searchAll(search.getCost(),search.getReason(),search.getStatus(),search.getIsFirstVisit());
			visitResponse = VisitMapperSearch.mapVisitSearch(responseList, visits);
			return visitResponse;
		}
		visits = visitRepository.searchAll(search.getCost(),search.getReason(),search.getStatus(),search.getIsFirstVisit());
		List<ResponseMsBuscador> pets = visits.stream()
	            .map(v -> petFacade.getPet(v.getIdPet()))
	            .collect(Collectors.toList());	
		
		List<ResponseMsBuscador> owners = visits.stream()
	            .map(v -> ownerFacade.getOwner(v.getIdOwner()))
	            .collect(Collectors.toList());
		visitResponse = VisitMapper.mapVisit(pets, owners, visits);
		return visitResponse;
		}

}
