package com.pet.clinic.veterinario.buscador.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VeterinarioDto {
        private Long veterinarioId;
        private String primerNombreVet;
        private String segundoNombreVet;
        private String primerApellidoVet;
        private String segundoApellidoVet;


}
