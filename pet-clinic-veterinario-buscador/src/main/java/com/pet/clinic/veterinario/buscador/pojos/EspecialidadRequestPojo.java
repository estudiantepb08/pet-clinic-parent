package com.pet.clinic.veterinario.buscador.pojos;

import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EspecialidadRequestPojo  implements Serializable {

    private String especialidadId;
    private Integer codigoEspecialidad;
    private String tipoEspecialidad;
    private String descripcionTipo;

}
