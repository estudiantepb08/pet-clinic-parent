package com.pet.clinic.veterinario.buscador.services;

import com.pet.clinic.veterinario.buscador.enums.ResponseMessageEnum;
import com.pet.clinic.veterinario.buscador.models.dto.VeterinarioDto;
import com.pet.clinic.veterinario.buscador.models.entity.Veterinario;
import com.pet.clinic.veterinario.buscador.pojos.VeterinariosRequestPojo;
import com.pet.clinic.veterinario.buscador.pojos.ResponsePojo;
import com.pet.clinic.veterinario.buscador.repository.IVererinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class VeterinariosServiceImpl implements IVeterinarioService {
    
    @Autowired
    IVererinarioRepository iVeterinarioRepository;

	@Autowired
	ResponsePojo responsePojo;
	private List<Veterinario> veterinarios;

    @Override
	public ResponsePojo getVeterinario() {

		this.veterinarios = new ArrayList<>();

		iVeterinarioRepository.findAll().forEach(veterinarios::add); // pendiente repository
		if (veterinarios.isEmpty()) {
			responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());
		} else {
			responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
			responsePojo.setData(this.veterinarios);
		}
	return responsePojo;
	}

	@Override
	public ResponsePojo findVeterinarioById(Long veterinarioId) {

		Optional<Veterinario> optionalVeterionario = iVeterinarioRepository.findById(veterinarioId); // pendiente repository
		if (optionalVeterionario.isPresent()) {
			responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
			responsePojo.setData(optionalVeterionario.get());
		} else {
			responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());
		}
		return responsePojo;
		}


		// revisar funcionamiento
	@Override
	public ResponsePojo saveVeterinario(VeterinariosRequestPojo VeterinariosRequestPojo) {

		//iVeterinarioRepository.save();

		return null;
	}

	@Override
	public ResponsePojo updateVeterinario(VeterinariosRequestPojo VeterinariosRequestPojo, Long veterinarioId) {

		return null;
	}

	@Override
	public Boolean deleteVeterinario(Long veterinarioId) {

		return null;
	}
    
}
