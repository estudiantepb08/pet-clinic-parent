package com.pet.clinic.veterinario.buscador.services;

import com.pet.clinic.veterinario.buscador.enums.ResponseMessageEnum;
import com.pet.clinic.veterinario.buscador.models.dto.VeterinarioDto;
import com.pet.clinic.veterinario.buscador.pojos.VeterinariosRequestPojo;
import com.pet.clinic.veterinario.buscador.pojos.ResponsePojo;
import com.pet.clinic.veterinario.buscador.repository.IVererinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
@Service
public class VeterinariosServiceImpl implements IVeterinarioService {
    
    @Autowired
    IVeterinarioService iVeterinarioRepository;

	@Autowired
	ResponsePojo responsePojo;
	private List<VeterinarioDto> veterinarioDtos;

    @Override
	public ResponsePojo getVeterinario() {

		this.veterinarioDtos = new ArrayList<>();
		veterinarioDtos = IVererinarioRepository.getVeterinario(); // pendiente repository
		if (veterinarioDtos.isEmpty()) {
			responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());
		} else {
			responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
			responsePojo.setData(this.veterinarioDtos);
		}
	return responsePojo;
	}

	@Override
	public ResponsePojo findVeterinarioById(Long veterinarioId) {
		this.veterinarioDtos = new LinkedList<>();
		veterinarioDtos = iVeterinarioRepository.getVeterinario(veterinarioId); // pendiente repository
		if (veterinarioDtos.isEmpty()) {
			responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());
		} else {
			responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
			responsePojo.setData(this.veterinarioDtos);
		}
		return responsePojo;
		}


		// revisar funcionamiento
	@Override
	public ResponsePojo saveVeterinario(VeterinariosRequestPojo VeterinariosRequestPojo) {
		responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
		return responsePojo;
	}

	@Override
	public ResponsePojo updateVeterinario(VeterinariosRequestPojo VeterinariosRequestPojo, Long venerarioId) {
		responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
		return responsePojo;
	}

	@Override
	public Boolean deleteVeterinario(Long veterinarioId) {
		responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
		return Boolean.TRUE;
	}
    
}
