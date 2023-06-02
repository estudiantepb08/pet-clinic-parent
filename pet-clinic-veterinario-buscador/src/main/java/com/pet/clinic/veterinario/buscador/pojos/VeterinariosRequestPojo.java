package com.pet.clinic.veterinario.buscador.pojos;

import lombok.*;
import java.io.Serializable;
import com.pet.clinic.veterinario.buscador.models.entity.Especialidades;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class VeterinariosRequestPojo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long veterinarioId;
    private String primerNombreVet;
    private String segundoNombreVet;
    private String primerApellidoVet;
    private String segundoApellidoVet;
    private Especialidades Especialidades;
}


