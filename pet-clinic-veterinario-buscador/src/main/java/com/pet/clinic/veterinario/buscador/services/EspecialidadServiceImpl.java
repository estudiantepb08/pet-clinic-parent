package com.pet.clinic.veterinario.buscador.services;

import com.pet.clinic.veterinario.buscador.enums.ResponseMessageEnum;
import com.pet.clinic.veterinario.buscador.models.dto.EspecialidadDto;
import com.pet.clinic.veterinario.buscador.models.entity.Especialidad;
import com.pet.clinic.veterinario.buscador.pojos.EspecialidadRequestPojo;
import com.pet.clinic.veterinario.buscador.pojos.ResponsePojo;
import com.pet.clinic.veterinario.buscador.repository.IEspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadServiceImpl implements IEspecialidadService {

    private IEspecialidadRepository iEspecialidadRepository;
    private ResponsePojo responsePojo;


    @Autowired
    public EspecialidadServiceImpl(IEspecialidadRepository iEspecialidadRepository, ResponsePojo responsePojo) {
        this.iEspecialidadRepository = iEspecialidadRepository;
        this.responsePojo = responsePojo;
    }

    @Override
    public ResponsePojo getEspecialidad() {

        List<Especialidad> listEspecialidades = new ArrayList<>();

        iEspecialidadRepository.findAll().forEach(listEspecialidades::add);

        if (listEspecialidades.isEmpty()) {
            responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());
        } else {
            responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
            responsePojo.setData(listEspecialidades);
        }
        return responsePojo;
    }

    @Override
    public ResponsePojo findEspecialidadById(Long especialidadId) {

        Optional<Especialidad> optinalEspecialidad = iEspecialidadRepository.findById(especialidadId);

        if (optinalEspecialidad.isPresent()) {
            responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
            responsePojo.setData(optinalEspecialidad.get());
        } else {
            responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());

        }
        return responsePojo;
    }

    // revisar funcionamiento
    @Override
    public ResponsePojo saveEspecialidad(EspecialidadRequestPojo especialidadRequestPojo) {
        return null;
    }

    @Override
    public ResponsePojo updateEspecialidad(EspecialidadRequestPojo especialidadRequestPojo, Long especialidadId) {
        return null;
    }

    @Override
    public Boolean deleteEspecialidad(Long especialidadId) {
        return null;
    }
}
