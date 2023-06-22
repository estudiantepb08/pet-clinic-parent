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
	
	private static BuscarTodoDtoResponse matchData(List<ResponseMsBuscador> dataMs, String ownerId, String petId ) {
		for (Object response : dataMs) {
		    Object data = ((ResponseMsBuscador) response).getData();
		    if (data instanceof ArrayList) {
		        ArrayList dataList = (ArrayList) data;
		        if (!dataList.isEmpty() && dataList.get(0) instanceof Map) {
		            Map<String, Object> dataMap = (Map<String, Object>) dataList.get(0);

		            String nombreMascota = (String) dataMap.get("nombreMascota");
		            String correoElectronico = (String) dataMap.get("correoElectronico");
		            Map<String, Object> dataMapPropietario = (Map<String, Object>) dataMap.get("propietario");
		            String direccion = (String) dataMapPropietario.get("direccion");
		            String telefono = (String) dataMapPropietario.get("telefono");
		            Map<String, Object> dataMapTipoMascota = (Map<String, Object>) dataMap.get("tipoMascota");

		            String tipoMascota = (String) dataMapTipoMascota.get("tipoMascota");
		            String fechaNacimiento = (String) dataMap.get("fechaNacimiento");
		            String primerNombre = (String) dataMapPropietario.get("primerNombre");
		            String segundoNombre = (String) dataMapPropietario.get("segundoNombre");
		            String primerApellido = (String) dataMapPropietario.get("primerApellido");
		            String segundoApellido = (String) dataMapPropietario.get("segundoApellido");
		            String ownerIdLong = (String) dataMapPropietario.get("id");
		            String petIdLong = (String) dataMap.get("id");
		            if (ownerId.equals(ownerId) && petIdLong.equals(petId)) {
		                return new BuscarTodoDtoResponse(ownerIdLong, petIdLong, primerNombre, segundoNombre, primerApellido,segundoApellido,
		                		telefono,direccion,correoElectronico,nombreMascota,fechaNacimiento,tipoMascota);
		            }
		        }
		    }
		}
		return null;
	}
	private static BuscarVeterinariosDto matchDataVeterinary(List<ResponseMsBuscador> dataMs, String veterinaryId ) {
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
		    			
		    			String veterinaryIdLong = (String) dataMap.get("id");
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

		            String veterinaryIdLong = (String) dataMap.get("id");
		            if (veterinaryIdLong.equals(veterinaryId)) {
		                return new BuscarVeterinariosDto(veterinaryIdLong, primerNombrevet, segundoNombrevet,
		                		primerApellidovet, segundoApellidovet);
		            }

		        }
		    
		}
		return null;
	}
}
