package com.pet.clinic.buscador.pojos;

import com.pet.clinic.buscador.models.entity.TipoMascota;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MascotaRequestPojo implements Serializable {

    private Long mascotasId;
    private String nombreMascota;
    private Date fechaNacimiento;
    private TipoMascota tipoMascotasId;
}
