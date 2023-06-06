package com.pet.clinic.buscador.services;

import com.pet.clinic.buscador.enums.ResponseMessageEnum;
import com.pet.clinic.buscador.models.dtos.PropietarioDto;
import com.pet.clinic.buscador.models.entity.Contacto;
import com.pet.clinic.buscador.models.entity.Propietario;
import com.pet.clinic.buscador.pojos.PropietarioRequestPojo;
import com.pet.clinic.buscador.pojos.ResponsePojo;
import com.pet.clinic.buscador.repository.IContactoRespository;
import com.pet.clinic.buscador.repository.IPropietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PropietarioServiceImpl implements IPropietarioService {

    @Autowired
    IPropietarioRepository iPropietarioRepository;
    @Autowired
    ResponsePojo responsePojo;
    @Autowired
    IContactoRespository iContactoRespository;
    private List<PropietarioDto> propietarioDtos;
    @Override
    @Transactional(readOnly = true)
    public ResponsePojo getListPropietario() {

        this.propietarioDtos = new ArrayList<>();
        responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
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
    @Transactional(readOnly = true)
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
    @Transactional
    public ResponsePojo savePropietario(PropietarioRequestPojo propietarioRequestPojo) {

        if(propietarioRequestPojo != null && StringUtils.hasLength(propietarioRequestPojo.getPrimerNombre().trim())
         && StringUtils.hasLength(propietarioRequestPojo.getSegundoNombre().trim())
         && StringUtils.hasLength(propietarioRequestPojo.getPrimerApellido().trim())
         && StringUtils.hasLength(propietarioRequestPojo.getSegundoApellido().trim())
         && StringUtils.hasLength(propietarioRequestPojo.getContacto().getDireccion().trim())
         && StringUtils.hasLength(propietarioRequestPojo.getContacto().getTelefono().trim())
         && StringUtils.hasLength(propietarioRequestPojo.getContacto().getCorreoElectronico().trim())){

            Contacto contacto = Contacto.builder().propietario(Propietario.builder().propietariosId(iPropietarioRepository.getMaxIdPropietario()).build())
                    .telefono(propietarioRequestPojo.getContacto().getTelefono().trim())
                    .direccion(propietarioRequestPojo.getContacto().getDireccion().trim())
                    .correoElectronico(propietarioRequestPojo.getContacto().getCorreoElectronico().trim()).build();

            Propietario propietario = Propietario.builder().primerNombre(propietarioRequestPojo.getPrimerNombre().trim())
                    .segundoNombre(propietarioRequestPojo.getSegundoNombre().trim())
                    .primerApellido(propietarioRequestPojo.getPrimerApellido().trim())
                    .segundoApellido(propietarioRequestPojo.getSegundoApellido().trim())
                    .contactoId(Arrays.asList(contacto)).build();

             Propietario savePropietario = iPropietarioRepository.save(propietario);
             Contacto saveContacto = iContactoRespository.save(contacto);

             if(savePropietario != null && saveContacto != null){
                 responsePojo.setData(savePropietario);
                 responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
             }
        }else{
            responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_CAMPOS.getMessages());
        }
        return responsePojo;
    }

    @Override
    @Transactional
    public ResponsePojo updatePropietario(PropietarioRequestPojo propietarioRequestPojo, Long propietarioId) {

        if(propietarioRequestPojo != null && StringUtils.hasLength(propietarioRequestPojo.getPrimerNombre().trim())
                && StringUtils.hasLength(propietarioRequestPojo.getSegundoNombre().trim())
                && StringUtils.hasLength(propietarioRequestPojo.getPrimerApellido().trim())
                && StringUtils.hasLength(propietarioRequestPojo.getSegundoApellido().trim())
                && StringUtils.hasLength(propietarioRequestPojo.getContacto().getDireccion().trim())
                && StringUtils.hasLength(propietarioRequestPojo.getContacto().getTelefono().trim())
                && StringUtils.hasLength(propietarioRequestPojo.getContacto().getCorreoElectronico().trim())){

            Contacto contacto = Contacto.builder().conctatosId(propietarioId).propietario(Propietario.builder().propietariosId(propietarioId).build())
                    .telefono(propietarioRequestPojo.getContacto().getTelefono().trim())
                    .direccion(propietarioRequestPojo.getContacto().getDireccion().trim())
                    .correoElectronico(propietarioRequestPojo.getContacto().getCorreoElectronico().trim()).build();

            Propietario propietario = Propietario.builder().propietariosId(propietarioId).primerNombre(propietarioRequestPojo.getPrimerNombre().trim())
                    .segundoNombre(propietarioRequestPojo.getSegundoNombre().trim())
                    .primerApellido(propietarioRequestPojo.getPrimerApellido().trim())
                    .segundoApellido(propietarioRequestPojo.getSegundoApellido().trim())
                    .contactoId(Arrays.asList(contacto)).build();

            Propietario savePropietario = iPropietarioRepository.save(propietario);
            Contacto saveContacto = null;

            if (savePropietario != null){
                saveContacto = iContactoRespository.save(contacto);
            }

            if(saveContacto != null){
                responsePojo.setData(savePropietario);
                responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
            }else{
                responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_CAMPOS.getMessages());
            }

        }else{
            responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_CAMPOS.getMessages());
        }
        return responsePojo;
    }

    @Override
    @Transactional
    public ResponsePojo deletePropietario(Long propietarioId) {

        if (propietarioId != null){
            iPropietarioRepository.deleteById(propietarioId);
            iContactoRespository.deleteById(propietarioId);
            responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
        }else {
            responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());
        }
        return responsePojo;
    }
}
