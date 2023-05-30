package com.pet.clinic.buscador.services;

import com.pet.clinic.buscador.models.entity.Propietario;
import com.pet.clinic.buscador.pojos.PropietarioRequestPojo;

import java.util.List;

public interface IPropietarioService {
    List<Propietario> getListPropietario();

    Propietario findPropietarioById(Long propietarioId);
    Propietario savePropietario(PropietarioRequestPojo propietarioRequestPojo);
    Propietario updatePropietario(PropietarioRequestPojo propietarioRequestPojo, Long propietarioId);
    Boolean deletePropietario(Long propietarioId);
}
