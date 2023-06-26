package com.pet.clinic.operador.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pet.clinic.operador.config.ResponseMsBuscador;
import com.pet.clinic.operador.dtos.BuscarTodoDtoResponse;
import com.pet.clinic.operador.dtos.BuscarVeterinariosDto;
import com.pet.clinic.operador.dtos.MascotaDto;
import com.pet.clinic.operador.dtos.PropietarioDto;
import com.pet.clinic.operador.dtos.VeterinaryDto;
import com.pet.clinic.operador.dtos.VisitDto;
import com.pet.clinic.operador.models.VisitModel;

public class VisitMapperSearch {
	public static List<VisitDto> mapVisitSearch (List<ResponseMsBuscador> dataMs , List<ResponseMsBuscador> dataMSVet, List<VisitModel> visits) {
		List<VisitDto> visitsResponse = new ArrayList<>();
		
		for(VisitModel visit : visits) {
			BuscarTodoDtoResponse response = matchData(dataMs, visit.getIdOwner(), visit.getIdPet());
			BuscarVeterinariosDto veterinaryResp = matchDataVeterinary(dataMSVet, visit.getIdVeterinary());
			if(response != null && veterinaryResp != null) {
				VisitDto visitDto = new VisitDto();
				PropietarioDto owner = new PropietarioDto();
				MascotaDto pet = new MascotaDto();
				VeterinaryDto veterinary = new VeterinaryDto();

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
				veterinary.setVeterinarioId(veterinaryResp.getVeterinarioId());
				veterinary.setPrimerApellidoVet(veterinaryResp.getPrimerApellidovet());
				veterinary.setPrimerNombreVet(veterinaryResp.getPrimerNombrevet());
				veterinary.setSegundoApellidoVet(veterinaryResp.getSegundoApellidovet());
				veterinary.setSegundoNombreVet(veterinaryResp.getSegundoNombrevet());
				visitDto.setOwner(owner);
				visitDto.setPet(pet);
				visitDto.setCost(visit.getCost());
				visitDto.setDateVisit(visit.getDateVisit());
				visitDto.setVeterinary(veterinary);
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
	private static BuscarVeterinariosDto matchDataVeterinary(List<ResponseMsBuscador> dataMs, Long veterinaryId ) {
		for (Object response : dataMs) {
		    Object data = ((ResponseMsBuscador) response).getData();
		    	if(data instanceof List) {
		    		
		    		ArrayList dataList = (ArrayList) data;
		    		if (!dataList.isEmpty() && dataList.get(0) instanceof Map) {
		    			Map<String, Object> dataMap = (Map<String, Object>) dataList.get(0);
		    			
		    			String segundoNombrevet = (String) dataMap.get("segundoNombreVet");
		    			String primerApellidovet = (String) dataMap.get("primerApellidoVet");
		    			String segundoApellidovet = (String) dataMap.get("segundoApellidoVet");
		    			String primerNombrevet = (String) dataMap.get("primerNombreVet");
		    			
		    			Integer veterinaryIdInteger = (Integer) dataMap.get("veterinarioId");
		    			Long veterinaryIdLong = veterinaryIdInteger.longValue();
		    			if (veterinaryIdLong.equals(veterinaryId)) {
		    				return new BuscarVeterinariosDto(veterinaryIdLong, primerNombrevet, segundoNombrevet,
		    						primerApellidovet, segundoApellidovet);
		    			}
		    	}
		        }else {
		            Map<String, Object> dataMap = (Map<String, Object>)data;
		            String segundoNombrevet = (String) dataMap.get("segundoNombreVet");
		            String primerApellidovet = (String) dataMap.get("primerApellidoVet");
		            String segundoApellidovet = (String) dataMap.get("segundoApellidoVet");
		            String primerNombrevet = (String) dataMap.get("primerNombreVet");

		            Integer veterinaryIdInteger = (Integer) dataMap.get("veterinarioId");
		            Long veterinaryIdLong = veterinaryIdInteger.longValue();
		            if (veterinaryIdLong.equals(veterinaryId)) {
		                return new BuscarVeterinariosDto(veterinaryIdLong, primerNombrevet, segundoNombrevet,
		                		primerApellidovet, segundoApellidovet);
		            }

		        }
		    
		}
		return null;
	}
}
