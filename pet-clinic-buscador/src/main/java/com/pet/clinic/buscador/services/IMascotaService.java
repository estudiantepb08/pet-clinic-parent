package com.pet.clinic.buscador.services;

import com.pet.clinic.buscador.models.entity.Mascota;
import com.pet.clinic.buscador.pojos.MascotaRequestPojo;

import java.util.List;

public interface IMascotaService {
    List<Mascota> getMascota();
    Mascota findMascotaById(Long mascotaId);
    Mascota saveMascota(MascotaRequestPojo mascota);
    Mascota updateMascota(MascotaRequestPojo mascota, Long mascotaId);
    Boolean deleteMascota(Long mascotaId);
}
