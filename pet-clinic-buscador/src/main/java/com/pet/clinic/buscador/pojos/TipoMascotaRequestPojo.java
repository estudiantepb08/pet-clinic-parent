package com.pet.clinic.buscador.pojos;

import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoMascotaRequestPojo implements Serializable {

    private String id;
    private Integer codigoTipo;
    private String tipoMascota;
    private String descripcionTipo;
}
