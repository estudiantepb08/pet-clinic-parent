package com.pet.clinic.buscador.services;

import com.pet.clinic.buscador.enums.ResponseMessageEnum;
import com.pet.clinic.buscador.models.dtos.PropietarioDto;
import com.pet.clinic.buscador.models.entity.Contacto;
import com.pet.clinic.buscador.models.entity.ContactoElastic;
import com.pet.clinic.buscador.models.entity.Propietario;
import com.pet.clinic.buscador.models.entity.PropietarioElastic;
import com.pet.clinic.buscador.pojos.PropietarioRequestPojo;
import com.pet.clinic.buscador.pojos.ResponsePojo;
import com.pet.clinic.buscador.repository.DataAccessRepositoryOwners;
import com.pet.clinic.buscador.repository.IContactoRespository;
import com.pet.clinic.buscador.repository.IPropietarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PropietarioServiceImpl implements IPropietarioService {

   /* @Autowired
    IPropietarioRepository iPropietarioRepository;*/
	
	@Autowired
	DataAccessRepositoryOwners iPropietarioRepository;
    @Autowired
    ResponsePojo responsePojo;
    @Autowired
    IContactoRespository iContactoRespository;
    private List<PropietarioElastic> propietarioDtos;
    @Override
    @Transactional(readOnly = true)
    public ResponsePojo getListPropietario() {

        this.propietarioDtos = new ArrayList<>();
        responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
        
        propietarioDtos = iPropietarioRepository.findAll();
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
    public ResponsePojo findPropietarioById(String propietarioId) {
    	Optional<PropietarioElastic> propietario = iPropietarioRepository.findById(propietarioId);
        if(propietario.isEmpty()){
            responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());
        }else{
            responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
            responsePojo.setData(propietario);
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

            ContactoElastic contacto = ContactoElastic.builder()
                    .telefono(propietarioRequestPojo.getContacto().getTelefono().trim())
                    .direccion(propietarioRequestPojo.getContacto().getDireccion().trim())
                    .correoElectronico(propietarioRequestPojo.getContacto().getCorreoElectronico().trim()).build();

            PropietarioElastic propietario = PropietarioElastic.builder().primerNombre(propietarioRequestPojo.getPrimerNombre().trim())
                    .segundoNombre(propietarioRequestPojo.getSegundoNombre().trim())
                    .primerApellido(propietarioRequestPojo.getPrimerApellido().trim())
                    .segundoApellido(propietarioRequestPojo.getSegundoApellido().trim())
                    .contactoId(Arrays.asList(contacto)).build();

             PropietarioElastic savePropietario = iPropietarioRepository.save(propietario);

             if(savePropietario != null){
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
    public ResponsePojo updatePropietario(PropietarioRequestPojo propietarioRequestPojo, String propietarioId) {

        if(propietarioRequestPojo != null && StringUtils.hasLength(propietarioRequestPojo.getPrimerNombre().trim())
                && StringUtils.hasLength(propietarioRequestPojo.getSegundoNombre().trim())
                && StringUtils.hasLength(propietarioRequestPojo.getPrimerApellido().trim())
                && StringUtils.hasLength(propietarioRequestPojo.getSegundoApellido().trim())
                && StringUtils.hasLength(propietarioRequestPojo.getContacto().getDireccion().trim())
                && StringUtils.hasLength(propietarioRequestPojo.getContacto().getTelefono().trim())
                && StringUtils.hasLength(propietarioRequestPojo.getContacto().getCorreoElectronico().trim())){

        	ContactoElastic contacto = ContactoElastic.builder().conctatosId(propietarioId)
                    .telefono(propietarioRequestPojo.getContacto().getTelefono().trim())
                    .direccion(propietarioRequestPojo.getContacto().getDireccion().trim())
                    .correoElectronico(propietarioRequestPojo.getContacto().getCorreoElectronico().trim()).build();

            PropietarioElastic propietario = PropietarioElastic.builder().id(propietarioId).propietariosId(propietarioRequestPojo.getPropietariosId()).primerNombre(propietarioRequestPojo.getPrimerNombre().trim())
                    .segundoNombre(propietarioRequestPojo.getSegundoNombre().trim())
                    .primerApellido(propietarioRequestPojo.getPrimerApellido().trim())
                    .segundoApellido(propietarioRequestPojo.getSegundoApellido().trim())
                    .contactoId(Arrays.asList(contacto)).build();

            PropietarioElastic updatePropietario = iPropietarioRepository.save(propietario);
            Contacto updateContacto = null;

        }else{
            responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_CAMPOS.getMessages());
        }
        return responsePojo;
    }

    @Override
    @Transactional
    public ResponsePojo deletePropietario(String propietarioId) {
		Optional<PropietarioElastic> existVet = iPropietarioRepository.findById(propietarioId);

        if (existVet.isPresent()){
            iPropietarioRepository.deleteById(existVet.get());
            responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
        }else {
            responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());
        }
        return responsePojo;
    }
}
