package com.pet.clinic.operador.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pet.clinic.operador.config.ResponseMsBuscador;
import com.pet.clinic.operador.exceptions.ModelNotFoundException;
import com.pet.clinic.operador.facade.OwnerFacade;
import com.pet.clinic.operador.facade.PetFacade;
import com.pet.clinic.operador.facade.VeterinaryFacade;
@Component
public class ValidDataVisitMicroservices {

	@Autowired
	OwnerFacade ownerFacade;
	
	@Autowired
	PetFacade petFacade;
	
	@Autowired
	VeterinaryFacade veterinaryFacade;
	public  Boolean ValidData(Long idPet, Long idOwner, Long idVeterinary){
		ResponseMsBuscador responsePet = petFacade.getPet(idPet);

		if (responsePet == null){
			throw new ModelNotFoundException(Constants.NOT_FOUND_PET);
		}  
		ResponseMsBuscador responseOwner = ownerFacade.getOwner(idOwner);
		
		if (responseOwner == null){
			throw new ModelNotFoundException(Constants.NOT_FOUND_OWNER);
		}
		ResponseMsBuscador responseVeterinary = veterinaryFacade.getVeterinary(idVeterinary);

		if (responseVeterinary == null){
			throw new ModelNotFoundException(Constants.NOT_FOUND_VETERINARY);
		}
		
		return true;
	}
}
