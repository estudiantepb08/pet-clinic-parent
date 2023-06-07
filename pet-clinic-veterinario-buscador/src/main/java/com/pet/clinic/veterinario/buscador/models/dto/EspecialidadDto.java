package com.pet.clinic.veterinario.buscador.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class EspecialidadDto {

    private Long especialidadeId;
    private Integer codigoEspecialidad;
    private String tipoEspecialidad;
    private String descripcionTipo;

}
