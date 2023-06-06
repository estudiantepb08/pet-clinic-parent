package com.pet.clinic.buscador.services;

import com.pet.clinic.buscador.pojos.PropietarioRequestPojo;
import com.pet.clinic.buscador.pojos.ResponsePojo;

public interface IPropietarioService {
    ResponsePojo getListPropietario();

    ResponsePojo findPropietarioById(Long propietarioId);
    ResponsePojo savePropietario(PropietarioRequestPojo propietarioRequestPojo);
    ResponsePojo updatePropietario(PropietarioRequestPojo propietarioRequestPojo, Long propietarioId);
    ResponsePojo deletePropietario(Long propietarioId);
}
