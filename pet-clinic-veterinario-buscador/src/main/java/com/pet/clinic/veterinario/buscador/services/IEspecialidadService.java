package com.pet.clinic.veterinario.buscador.services;

import com.pet.clinic.veterinario.buscador.pojos.EspecialidadRequestPojo;
import com.pet.clinic.veterinario.buscador.pojos.ResponsePojo;

public interface IEspecialidadService {
    ResponsePojo getEspecialidad() ;
    ResponsePojo findEspecialidadById(Long especialidadId);
    ResponsePojo saveEspecialidad(EspecialidadRequestPojo especialidadRequestPojo);
    ResponsePojo updateEspecialidad(EspecialidadRequestPojo especialidadRequestPojo , Long especialidadId);
    Boolean deleteEspecialidad(Long especialidadId);
}
