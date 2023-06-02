package com.pet.clinic.veterinario.buscador.pojos;

import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EspecialidadRequestPojo  implements Serializable {

    private Long especialidadId;
    private String especialidad;

}
