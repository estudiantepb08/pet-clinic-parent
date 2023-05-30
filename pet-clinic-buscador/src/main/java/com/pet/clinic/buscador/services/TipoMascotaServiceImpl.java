package com.pet.clinic.buscador.services;

import com.pet.clinic.buscador.models.entity.TipoMascota;
import com.pet.clinic.buscador.repository.ITipoMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoMascotaServiceImpl implements ITipoMascotaService{

    @Autowired
    private ITipoMascotaRepository iTipoMascotaRepository;
    @Override
    public List<TipoMascota> getTipoDeMascota() {
        return (List<TipoMascota>) iTipoMascotaRepository.findAll();
    }
}
