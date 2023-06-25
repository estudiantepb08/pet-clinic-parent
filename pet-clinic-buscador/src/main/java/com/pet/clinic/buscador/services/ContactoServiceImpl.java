package com.pet.clinic.buscador.services;

import com.pet.clinic.buscador.models.entity.ContactoElastic;
import com.pet.clinic.buscador.pojos.ContactoRequestPojo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoServiceImpl implements IContactoService {
    @Override
    public List<ContactoElastic> getListContacto() {
        return null;
    }

    @Override
    public ContactoElastic saveContacto(ContactoRequestPojo contactoRequestPojo) {
        return null;
    }

    @Override
    public ContactoElastic updateContacto(ContactoRequestPojo contactoRequestPojo, Long contactoId) {
        return null;
    }

    @Override
    public Boolean deleteContacto(Long contactoId) {
        return null;
    }
}
