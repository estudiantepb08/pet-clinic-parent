package com.pet.clinic.buscador.services;

import com.pet.clinic.buscador.pojos.PropietarioRequestPojo;
import com.pet.clinic.buscador.pojos.ResponsePojo;

public interface IPropietarioService {
    ResponsePojo getListPropietario();

    ResponsePojo findPropietarioById(String propietarioId);
    ResponsePojo savePropietario(PropietarioRequestPojo propietarioRequestPojo);
    ResponsePojo updatePropietario(PropietarioRequestPojo propietarioRequestPojo, String propietarioId);
    ResponsePojo deletePropietario(String propietarioId);
}
