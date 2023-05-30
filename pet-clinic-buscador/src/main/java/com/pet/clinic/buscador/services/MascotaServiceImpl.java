package com.pet.clinic.buscador.services;

import com.pet.clinic.buscador.models.entity.Mascota;
import com.pet.clinic.buscador.pojos.MascotaRequestPojo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaServiceImpl implements IMascotaService{
    @Override
    public List<Mascota> getMascota() {
        return null;
    }

    @Override
    public Mascota findMascotaById(Long mascotaId) {
        return null;
    }

    @Override
    public Mascota saveMascota(MascotaRequestPojo mascota) {
        return null;
    }

    @Override
    public Mascota updateMascota(MascotaRequestPojo mascota, Long mascotaId) {
        return null;
    }

    @Override
    public Boolean deleteMascota(Long mascotaId) {
        return null;
    }
}
