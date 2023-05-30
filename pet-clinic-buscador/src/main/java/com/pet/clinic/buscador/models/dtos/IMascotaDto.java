package com.pet.clinic.buscador.models.dtos;

import com.pet.clinic.buscador.models.entity.TipoMascota;

import java.util.Date;

public interface IMascotaDto {

    Long getMascotasId();
    String getNombreMascota();
    Date getFechaNacimiento();
    TipoMascota getTipoMascotasId();
}
