package com.pet.clinic.buscador.services;

import com.pet.clinic.buscador.pojos.MascotaRequestPojo;
import com.pet.clinic.buscador.pojos.ResponsePojo;

import java.util.List;

public interface IMascotaService {
    ResponsePojo getMascota();
    ResponsePojo findMascotaById(String mascotaId);
    ResponsePojo saveMascota(MascotaRequestPojo mascota);
    ResponsePojo updateMascota(MascotaRequestPojo mascota, String mascotaId);
    Boolean deleteMascota(String mascotaId);
    ResponsePojo getListarTodo(String buscar);
}
