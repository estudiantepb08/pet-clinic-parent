package com.pet.clinic.veterinario.buscador.services;

import com.pet.clinic.veterinario.buscador.pojos.ResponsePojo;
import com.pet.clinic.veterinario.buscador.pojos.VeterinariosRequestPojo;

public interface IVeterinarioService  {
    ResponsePojo getVeterinario();
    ResponsePojo findVeterinarioById(String veterinarioId);
    ResponsePojo saveVeterinario(VeterinariosRequestPojo veterinario);
    ResponsePojo updateVeterinario(VeterinariosRequestPojo veterinario, String venerarioId);
    ResponsePojo updateVeterinarioPatch(VeterinariosRequestPojo veterinariosRequestPojo, String id);
    ResponsePojo deleteVeterinario (String id);
    ResponsePojo getListarTodo(String buscar);
}
