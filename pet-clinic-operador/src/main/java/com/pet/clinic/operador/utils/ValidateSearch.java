package com.pet.clinic.operador.utils;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pet.clinic.operador.config.ResponseMsBuscador;
import com.pet.clinic.operador.dtos.VisitDto;
import com.pet.clinic.operador.facade.OwnerFacade;
import com.pet.clinic.operador.facade.PetFacade;
import com.pet.clinic.operador.facade.VeterinaryFacade;
import com.pet.clinic.operador.mapper.VisitMapper;
import com.pet.clinic.operador.mapper.VisitMapperSearch;
import com.pet.clinic.operador.models.VisitModel;
@Component
public class ValidateSearch {

	
	@Autowired
	OwnerFacade ownerFacade;
	
	@Autowired
	PetFacade petFacade;
	
	@Autowired
	VeterinaryFacade veterinaryFacade;
	
	private String paramMsBuscador;
	
	private String paramMSVeterinary;
	
	private List<VisitModel> visits;
	
	public  List<VisitDto> mainSearch(String paramMSBuscador, String paramMsVeterinary, List<VisitModel> visits){
		
		this.paramMsBuscador = paramMSBuscador;
		this.paramMSVeterinary = paramMsVeterinary;
		this.visits = visits;

		if(paramMSBuscador != null && paramMsVeterinary != null) {
			return this.searchMultipleMs();
		}
		
		if(paramMSBuscador != null && paramMsVeterinary == null) {
			return this.searchMatchMsBuscador();
		}
		
		if(paramMsBuscador == null && paramMsVeterinary != null) {
			return this.searchMatchMsVeterinary();
		}
		
		return null;
	}
	
	private List<VisitDto> searchMultipleMs (){
		ResponseMsBuscador responsePet = new ResponseMsBuscador();
		ResponseMsBuscador responseVeterinary = new ResponseMsBuscador();
		List<VisitDto> visitResponse = new ArrayList<>();
		List<ResponseMsBuscador> responseListPet = new ArrayList<>();
		List<ResponseMsBuscador> responseListVeterinary = new ArrayList<>();

		 responsePet = petFacade.searchTodo(this.paramMsBuscador);
		 responseVeterinary = veterinaryFacade.searchTodo(this.paramMSVeterinary);
		 responseListVeterinary.add(responseVeterinary);
		 responseListPet.add(responsePet);
		return visitResponse = VisitMapperSearch.mapVisitSearch(responseListPet,responseListVeterinary, this.visits);
		
	}
	
	private List<VisitDto> searchMatchMsBuscador(){
		ResponseMsBuscador responsePet = new ResponseMsBuscador();
		List<VisitDto> visitResponse = new ArrayList<>();
		List<ResponseMsBuscador> responseListPet = new ArrayList<>();

		 responsePet = petFacade.searchTodo(this.paramMsBuscador);
		 responseListPet.add(responsePet);
		 List<ResponseMsBuscador> veterinaries = this.visits.stream()
		            .map(v -> veterinaryFacade.getVeterinary(v.getIdVeterinary()))
		            .collect(Collectors.toList());
		 return visitResponse = VisitMapperSearch.mapVisitSearch(responseListPet,veterinaries, this.visits);

	}
	
	private List<VisitDto> searchMatchMsVeterinary(){
		ResponseMsBuscador responseVeterinary = new ResponseMsBuscador();
		List<VisitDto> visitResponse = new ArrayList<>();
		List<ResponseMsBuscador> responseVeterinaryList = new ArrayList<>();

		responseVeterinary = veterinaryFacade.searchTodo(this.paramMSVeterinary);
		 List<ResponseMsBuscador> owners = this.visits.stream()
		            .map(v -> ownerFacade.getOwner(v.getIdOwner()))
		            .collect(Collectors.toList());
		 List<ResponseMsBuscador> pets = this.visits.stream()
		            .map(v -> petFacade.getPet(v.getIdPet()))
		            .collect(Collectors.toList());
		responseVeterinaryList.add(responseVeterinary);
		return visitResponse = VisitMapper.mapVisit(pets, owners,responseVeterinaryList, this.visits);

	}
}
