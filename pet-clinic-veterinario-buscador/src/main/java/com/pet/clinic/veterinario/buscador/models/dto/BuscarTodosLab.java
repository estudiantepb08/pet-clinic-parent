package com.pet.clinic.veterinario.buscador.models.dto;

import java.util.Date;

public interface BuscarTodosLab {

    String getPrimerNombreVet();
    String getSegundoNombreVet();
    String getPrimerApellidoVet();
    String getSegundoApellidoVet();
    Integer getCodigoEspecialidad();
    String getTipoEspecialidad();
    Long getVeterinarioId();

}
