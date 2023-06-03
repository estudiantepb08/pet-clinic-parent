package com.pet.clinic.veterinario.buscador.services;

import com.pet.clinic.veterinario.buscador.pojos.ResponsePojo;
import com.pet.clinic.veterinario.buscador.pojos.VeterinariosRequestPojo;

public interface IVeterinarioService {
    ResponsePojo getVeterinario();
    ResponsePojo findVeterinarioById(Long veterinarioId);
    ResponsePojo saveVeterinario(VeterinariosRequestPojo veterinario);
    ResponsePojo updateVeterinario(VeterinariosRequestPojo veterinario, Long venerarioId);
    Boolean deleteVeterinario (Long veterinarioId);
}
