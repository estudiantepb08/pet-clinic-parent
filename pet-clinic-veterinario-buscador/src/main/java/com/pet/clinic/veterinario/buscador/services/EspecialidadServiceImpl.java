package com.pet.clinic.veterinario.buscador.services;

import com.pet.clinic.veterinario.buscador.enums.ResponseMessageEnum;
import com.pet.clinic.veterinario.buscador.models.dto.EspecialidadDto;
import com.pet.clinic.veterinario.buscador.pojos.EspecialidadRequestPojo;
import com.pet.clinic.veterinario.buscador.pojos.ResponsePojo;
import com.pet.clinic.veterinario.buscador.repository.IEspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class EspecialidadServiceImpl implements IEspecialidadService {
    
    @Autowired
    IEspecialidadRepository iEspecialidadRepository;

    @Autowired
    ResponsePojo responsePojo;
    private List<EspecialidadDto> especialidadDtos;

    @Override
	public ResponsePojo getEspecialidad() {

        this.especialidadDtos = new ArrayList<>();

        especialidadDtos = iEspecialidadRepository.getEspecialidad();
        if (especialidadDtos.isEmpty()) {
			responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());
		} else {
			responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
			responsePojo.setData(this.especialidadDtos);
		}
	return responsePojo;
    }

    @Override
	public ResponsePojo findEspecialidadById(Long especialidadId) {

        this.especialidadDtos = new LinkedList<>();

        especialidadDtos = iEspecialidadRepository.getEspecialidad(especialidadId);
        if (especialidadDtos.isEmpty()) {
			responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());
		} else {
			responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
			responsePojo.setData(this.especialidadDtos);
		}
	return responsePojo;
    }

    	// revisar funcionamiento
	@Override
	public ResponsePojo saveEspecialidad(EspecialidadRequestPojo EspecialidadRequestPojo) {
		responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
		return responsePojo;
	}

	@Override
	public ResponsePojo updateEspecialidad(EspecialidadRequestPojo EspecialidadRequestPojo, Long EspecialidadId) {
		responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
		return responsePojo;
	}

	@Override
	public Boolean deleteEspecialidad(Long especialidadId) {
		responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
		return Boolean.TRUE;
    }
}
