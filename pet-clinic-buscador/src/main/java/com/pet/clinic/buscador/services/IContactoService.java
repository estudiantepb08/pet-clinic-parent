package com.pet.clinic.buscador.services;

import com.pet.clinic.buscador.models.entity.ContactoElastic;
import com.pet.clinic.buscador.pojos.ContactoRequestPojo;

import java.util.List;

public interface IContactoService {

    List<ContactoElastic> getListContacto();
    ContactoElastic saveContacto(ContactoRequestPojo contactoRequestPojo);
    ContactoElastic updateContacto(ContactoRequestPojo contactoRequestPojo, Long contactoId);
    Boolean deleteContacto(Long contactoId);


}
