package com.pet.clinic.buscador.services;

import com.pet.clinic.buscador.models.entity.Contacto;
import com.pet.clinic.buscador.pojos.ContactoRequestPojo;

import java.util.List;

public interface IContactoService {

    List<Contacto> getListContacto();
    Contacto saveContacto(ContactoRequestPojo contactoRequestPojo);
    Contacto updateContacto(ContactoRequestPojo contactoRequestPojo, Long contactoId);
    Boolean deleteContacto(Long contactoId);


}
