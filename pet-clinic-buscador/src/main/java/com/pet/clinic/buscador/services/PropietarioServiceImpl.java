package com.pet.clinic.buscador.services;

import com.pet.clinic.buscador.enums.ResponseMessageEnum;
import com.pet.clinic.buscador.models.dtos.PropietarioDto;
import com.pet.clinic.buscador.pojos.PropietarioRequestPojo;
import com.pet.clinic.buscador.pojos.ResponsePojo;
import com.pet.clinic.buscador.repository.IPropietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropietarioServiceImpl implements IPropietarioService {

    @Autowired
    IPropietarioRepository iPropietarioRepository;

    @Autowired
    ResponsePojo responsePojo;
    private List<PropietarioDto> propietarioDtos;
    @Override
    public ResponsePojo getListPropietario() {

        this.propietarioDtos = new ArrayList<>();

        propietarioDtos = iPropietarioRepository.getPropietarioContacto();
        if(propietarioDtos.isEmpty()){
            responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());
        }else{
            responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
            responsePojo.setData(this.propietarioDtos);
        }
        return responsePojo;
    }

    @Override
    public ResponsePojo findPropietarioById(Long propietarioId) {

        this.propietarioDtos = new ArrayList<>();
        this.propietarioDtos = iPropietarioRepository.getPropietarioPorIdContacto(propietarioId);
        if(this.propietarioDtos.isEmpty()){
            responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());
        }else{
            responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
            responsePojo.setData(this.propietarioDtos);
        }
        return responsePojo;
    }

    @Override
    public ResponsePojo savePropietario(PropietarioRequestPojo propietarioRequestPojo) {
        return null;
    }

    @Override
    public ResponsePojo updatePropietario(PropietarioRequestPojo propietarioRequestPojo, Long propietarioId) {
        return null;
    }

    @Override
    public Boolean deletePropietario(Long propietarioId) {
        return null;
    }
}
