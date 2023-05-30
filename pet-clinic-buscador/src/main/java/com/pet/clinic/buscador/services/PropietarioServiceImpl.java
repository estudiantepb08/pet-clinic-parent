package com.pet.clinic.buscador.services;

import com.pet.clinic.buscador.models.entity.Propietario;
import com.pet.clinic.buscador.pojos.PropietarioRequestPojo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropietarioServiceImpl implements IPropietarioService {
    @Override
    public List<Propietario> getListPropietario() {
        return null;
    }

    @Override
    public Propietario findPropietarioById(Long propietarioId) {
        return null;
    }

    @Override
    public Propietario savePropietario(PropietarioRequestPojo propietarioRequestPojo) {
        return null;
    }

    @Override
    public Propietario updatePropietario(PropietarioRequestPojo propietarioRequestPojo, Long propietarioId) {
        return null;
    }

    @Override
    public Boolean deletePropietario(Long propietarioId) {
        return null;
    }
}
