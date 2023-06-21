package com.pet.clinic.veterinario.buscador.pojos;

import lombok.*;
import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class VeterinariosRequestPojo implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private Long veterinarioId;
    private String primerNombreVet;
    private String segundoNombreVet;
    private String primerApellidoVet;
    private String segundoApellidoVet;
    private EspecialidadRequestPojo especialidad;
}


