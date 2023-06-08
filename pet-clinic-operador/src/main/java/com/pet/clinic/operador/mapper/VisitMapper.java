package com.pet.clinic.operador.mapper;

import java.util.List;
import java.util.Optional;


import java.util.*;

import com.pet.clinic.operador.config.ResponseMsBuscador;
import com.pet.clinic.operador.dtos.MascotaDto;
import com.pet.clinic.operador.dtos.PropietarioDto;
import com.pet.clinic.operador.dtos.VisitDto;
import com.pet.clinic.operador.models.VisitModel;
import com.google.gson.Gson;


public class VisitMapper {

	public static List<VisitDto> mapVisit (List<ResponseMsBuscador> pets , List<ResponseMsBuscador> owners, List<VisitModel> visits) {
		List<VisitDto> visitResponse = new ArrayList<>();
		 for (VisitModel visit : visits) {
		        MascotaDto pet =  findPets(pets, visit.getIdPet());
				VisitDto visitDto = new VisitDto();

		        PropietarioDto owner = (PropietarioDto) findOwners(owners, visit.getIdOwner());
		        visitDto.setIdVisit(visit.getIdVisit());
		        visitDto.setPet(pet);
		        visitDto.setOwner(owner);
		        visitDto.setDateVisit(visit.getDateVisit());
		        visitDto.setCost(visit.getCost());
		        visitDto.setIsFirstVisit(visit.isFirstVisit());
		        visitDto.setReason(visit.getReason());
		        visitDto.setStatus(visit.getStatus());
		        visitDto.setIdVeterinary(visit.getIdVeterinary());

		        visitResponse.add(visitDto);
		    }		
		 	return visitResponse;
	}
	private static MascotaDto findPets(List<ResponseMsBuscador> responses, Long id) {

		
		for (Object response : responses) {
		    Object data = ((ResponseMsBuscador) response).getData();
		    if (data instanceof ArrayList) {
		        ArrayList dataList = (ArrayList) data;
		        if (!dataList.isEmpty() && dataList.get(0) instanceof Map) {
		            Map<String, Object> dataMap = (Map<String, Object>) dataList.get(0);
		            Integer mascotasIdInteger = (Integer) dataMap.get("mascotasId");
		            Long mascotasId = mascotasIdInteger.longValue();
		            String fechaNacimiento = (String) dataMap.get("fechaNacimiento");
		            String nombreMascota = (String) dataMap.get("nombreMascota");
		            String tipoMascota = (String) dataMap.get("tipoMascota");
		            if (mascotasId.equals(id)) {
		                return new MascotaDto(mascotasId, nombreMascota, null, tipoMascota);
		            }
		        }
		    }
		}
		return null;
	}
	private static PropietarioDto findOwners(List<ResponseMsBuscador> responses, Long id) {
		
		for (Object response : responses) {
		    Object data = ((ResponseMsBuscador) response).getData();
		    if (data instanceof ArrayList) {
		        ArrayList dataList = (ArrayList) data;
		        if (!dataList.isEmpty() && dataList.get(0) instanceof Map) {
		            Map<String, Object> dataMap = (Map<String, Object>) dataList.get(0);
		            Integer mascotasIdInteger = (Integer) dataMap.get("propietariosId");
		            Long ownerId = mascotasIdInteger.longValue();
		            String primerNombre = (String) dataMap.get("primerNombre");
		            String segundoNombre = (String) dataMap.get("segundoNombre");
		            String primerApellido = (String) dataMap.get("primerApellido");
		            String segundoApellido = (String) dataMap.get("segundoApellido");
		            String telefono = (String) dataMap.get("telefono");
		            String direccion = (String) dataMap.get("direccion");
		            String correoElectronico = (String) dataMap.get("correoElectronico");

		            if (ownerId.equals(id)) {
		                return new PropietarioDto(ownerId, primerNombre, segundoNombre, primerApellido,segundoApellido,telefono,direccion,correoElectronico);
		            }
		        }
		    }
		}
		return null;
}
}
