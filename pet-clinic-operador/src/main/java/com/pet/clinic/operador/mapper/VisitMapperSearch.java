package com.pet.clinic.operador.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pet.clinic.operador.config.ResponseMsBuscador;
import com.pet.clinic.operador.dtos.BuscarTodoDtoResponse;
import com.pet.clinic.operador.dtos.MascotaDto;
import com.pet.clinic.operador.dtos.PropietarioDto;
import com.pet.clinic.operador.dtos.VisitDto;
import com.pet.clinic.operador.models.VisitModel;

public class VisitMapperSearch {
	public static List<VisitDto> mapVisitSearch (List<ResponseMsBuscador> dataMs , List<VisitModel> visits) {
		List<VisitDto> visitsResponse = new ArrayList<>();
		
		for(VisitModel visit : visits) {
			BuscarTodoDtoResponse response = matchData(dataMs, visit.getIdOwner(), visit.getIdPet());
			
			if(response != null) {
				VisitDto visitDto = new VisitDto();
				PropietarioDto owner = new PropietarioDto();
				MascotaDto pet = new MascotaDto();
				owner.setPropietariosId(response.getOwnerId());
				owner.setCorreoElectronico(response.getCorreoElectronico());
				owner.setPrimerApellido(response.getPrimerApellido());
				owner.setPrimerNombre(response.getPrimerNombre());
				owner.setSegundoApellido(response.getSegundoApellido());
				owner.setSegundoNombre(response.getSegundoNombre());
				owner.setTelefono(response.getTelefono());
				owner.setDireccion(response.getDireccion());
				pet.setNombreMascota(response.getNombreMascota());
				pet.setTipoMascota(response.getTipoMascoTa());
				visitDto.setOwner(owner);
				visitDto.setPet(pet);
				visitDto.setCost(visit.getCost());
				visitDto.setDateVisit(visit.getDateVisit());
				visitDto.setIdVeterinary(visit.getIdVeterinary());
				visitDto.setReason(visit.getReason());
				visitDto.setStatus(visit.getStatus());
				visitDto.setIdVisit(visit.getIdVisit());
				visitsResponse.add(visitDto);
			}
		}
		return visitsResponse;
	}
	
	private static BuscarTodoDtoResponse matchData(List<ResponseMsBuscador> dataMs, Long ownerId, Long petId ) {
		for (Object response : dataMs) {
		    Object data = ((ResponseMsBuscador) response).getData();
		    if (data instanceof ArrayList) {
		        ArrayList dataList = (ArrayList) data;
		        if (!dataList.isEmpty() && dataList.get(0) instanceof Map) {
		            Map<String, Object> dataMap = (Map<String, Object>) dataList.get(0);

		            String nombreMascota = (String) dataMap.get("nombreMascota");
		            String correoElectronico = (String) dataMap.get("correoElectronico");
		            String direccion = (String) dataMap.get("direccion");
		            String telefono = (String) dataMap.get("telefono");
		            String tipoMascota = (String) dataMap.get("tipoMascota");
		            String fechaNacimiento = (String) dataMap.get("fechaNacimiento");
		            String primerNombre = (String) dataMap.get("primerNombre");
		            String segundoNombre = (String) dataMap.get("segundoNombre");
		            String primerApellido = (String) dataMap.get("primerApellido");
		            String segundoApellido = (String) dataMap.get("segundoApellido");
		            Integer ownerIdInteger = (Integer) dataMap.get("propietariosId");
		            Long ownerIdLong = ownerIdInteger.longValue();
		            Integer petInteger = (Integer) dataMap.get("mascotasId");
		            Long petIdLong = petInteger.longValue();
		            if (ownerId.equals(ownerId) && petIdLong.equals(petId)) {
		                return new BuscarTodoDtoResponse(ownerIdLong, petIdLong, primerNombre, segundoNombre, primerApellido,segundoApellido,
		                		telefono,direccion,correoElectronico,nombreMascota,fechaNacimiento,tipoMascota);
		            }
		        }
		    }
		}
		return null;
	}
}
